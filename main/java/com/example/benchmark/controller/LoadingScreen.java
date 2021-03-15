package com.example.benchmark.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.benchmark.R;
import com.example.benchmark.view.ScoreScreen;
import com.example.benchmark.model.CPU;
import com.example.benchmark.model.Memory;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LoadingScreen extends AppCompatActivity {
    private ArrayList<String> resultArray = new ArrayList<>();
    private static ArrayList<Context> context = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context.add(0,getApplicationContext());
        setContentView(R.layout.activity_loading_screen);
        startProcessing();
    }

    private void startProcessing(){
        new Calculate().execute(resultArray);
    }

    private class Collector{
        public AtomicInteger finish = new AtomicInteger(0);
        public AtomicLong scoreCpu = new AtomicLong(0);
        public AtomicLong scoreMem = new AtomicLong(0);
    }

    private static class CPUThread implements Runnable{
        private final Collector collector;

        private CPUThread(Collector collector) {
            this.collector = collector;
        }

        @Override
        public void run() {
            long l = CPU.cpuScore();
            collector.scoreCpu.addAndGet(l);
            collector.finish.incrementAndGet();
        }
    }

    public static Thread ofCPUThread(Collector collector){
        return new Thread(new CPUThread(collector));
    }

    private static class MemThread implements Runnable{
        private final Collector collector;

        private MemThread(Collector collector) {
            this.collector = collector;
        }

        @Override
        public void run() {

            Memory mem = new Memory(context.get(0));
            long l = mem.memScore();
            collector.scoreMem.addAndGet(l);
            collector.finish.incrementAndGet();
        }
    }

    public static Thread ofMemThread(Collector collector){
        return new Thread(new MemThread(collector));
    }


    private class Calculate extends AsyncTask<ArrayList<String>,Void,ArrayList<String>>{

        @Override
        protected ArrayList<String> doInBackground(ArrayList<String>... params) {
            Collector collector = new Collector();
            //start CPU, GPU, mem tests
            ofCPUThread(collector).start();
            ofMemThread(collector).start();
            //new Thread(new CPUThread(collector)).start();
            while(collector.finish.get() != 2){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return new ArrayList<String>();
                }
            }
            resultArray.add(Long.toString(collector.scoreCpu.get()));
            resultArray.add(Long.toString(collector.scoreMem.get()));
            long total = 10000000/((collector.scoreCpu.get() + collector.scoreMem.get())/2);
            resultArray.add(Long.toString(total));
            //long final_score = 10000000 / (collector.score.get());
            //return Long.toString(final_score);
            //return Long.toString(CPU.cpuScore());
            return resultArray;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            Intent i = new Intent(LoadingScreen.this, ScoreScreen.class);
            i.putExtra("data", result);
            startActivity(i);
            finish();
        }
    }

}
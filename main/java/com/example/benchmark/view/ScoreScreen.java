package com.example.benchmark.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.benchmark.R;
import com.example.benchmark.model.DatabaseRepository;
import com.example.benchmark.model.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ScoreScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        TextView scoreLabelCpu = (TextView) findViewById(R.id.id_score);
        TextView scoreLabelMem = (TextView) findViewById(R.id.id_score2);
        TextView scoreTotal = (TextView) findViewById(R.id.id_score3);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> score = extras.getStringArrayList("data");

        DatabaseRepository db = new DatabaseRepository(this);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        java.util.Date date = new java.util.Date();
        String strDate = formatter.format(date);

        Test test = new Test(strDate, score.get(0),score.get(1),score.get(2));
        db.insertTest(test);

        scoreLabelCpu.setText(score.get(0));
        scoreLabelMem.setText(score.get(1));
        scoreTotal.setText(score.get(2));

    }
}
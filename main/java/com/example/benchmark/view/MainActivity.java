package com.example.benchmark.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.benchmark.R;
import com.example.benchmark.controller.LoadingScreen;

public class MainActivity extends AppCompatActivity {
    private Button devInfo;
    private Button start;
    private Button scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        devInfo = (Button) findViewById(R.id.devInfo_button);
        start = (Button) findViewById(R.id.start_button);
        scores = (Button) findViewById(R.id.scores_button);

        devInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeviceInfo();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String score = Long.toString(CPU.cpuScore());
                //score_label.setText(score);
                openLoadingScreen();

            }
        });

        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScores();
            }
        });
    }

    public void openDeviceInfo(){
        Intent intent = new Intent(this, DeviceInfo.class);
        startActivity(intent);
    }

    public void openLoadingScreen(){
        Intent intent = new Intent(this, LoadingScreen.class);
        startActivity(intent);
    }

    public void openScores(){
        Intent intent = new Intent(this,PreviousScores.class);
        startActivity(intent);
    }
}
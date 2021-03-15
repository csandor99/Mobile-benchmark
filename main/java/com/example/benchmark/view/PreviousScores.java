package com.example.benchmark.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.benchmark.R;
import com.example.benchmark.model.DatabaseRepository;
import com.example.benchmark.model.Test;

import java.util.List;

public class PreviousScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_scores);

        ListView scoreList = (ListView) findViewById(R.id.scoreList);

        DatabaseRepository db = new DatabaseRepository(this);
        List<Test> list = db.getAllTests();

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        scoreList.setAdapter(listAdapter);
    }
}
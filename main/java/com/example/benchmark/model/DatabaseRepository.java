package com.example.benchmark.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository extends SQLiteOpenHelper {

    public DatabaseRepository(@Nullable Context context) {
        super(context, "Benchmark.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RUNS(id CHAR(50) PRIMARY KEY, cpu char(20), mem char(25), total char(25));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS RUNS;");
        this.onCreate(db);
    }

    public void insertTest(Test test) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", test.getDate());
        contentValues.put("cpu", test.getCpuScore());
        contentValues.put("mem", test.getMemScore());
        contentValues.put("total", test.getTotalScore());

        this.getWritableDatabase().insertOrThrow("RUNS", null, contentValues);
    }

    public List<Test> getAllTests() {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM RUNS", null);
        List<Test> runs = new ArrayList<>();
        while (cursor.moveToNext()){
            Test test = new Test();
            test.setDate(cursor.getString(0));
            test.setCpuScore(cursor.getString(1));

            String deviceTypeString = cursor.getString(2);
            test.setMemScore(cursor.getString(2));
            test.setTotalScore(cursor.getString(3));
            runs.add(test);
        }
        cursor.close();
        return runs;
    }
}

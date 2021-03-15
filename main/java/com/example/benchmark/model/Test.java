package com.example.benchmark.model;

public class Test {
    private String date;
    private String cpuScore;
    private String memScore;
    private String totalScore;

    public Test(String date, String cpu, String mem, String total ){
        this.date = date;
        this.cpuScore = cpu;
        this.memScore = mem;
        this.totalScore = total;
    }

    public Test() {
        this.date = "date";
        this.cpuScore = "cpu";
        this.memScore = "mem";
        this.totalScore = "total";
    }

    public String getDate() {
        return date;
    }

    public String getCpuScore() {
        return cpuScore;
    }

    public String getMemScore() {
        return memScore;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCpuScore(String cpuScore) {
        this.cpuScore = cpuScore;
    }

    public void setMemScore(String memScore) {
        this.memScore = memScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return
                "Date: " + date + '\n' +
                "CPU time: " + cpuScore + '\n' +
                "Memory time: " + memScore + '\n' +
                "Total score: " + totalScore + '\n'
               ;
    }
}

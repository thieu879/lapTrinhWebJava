package com.example.ss1.bt8;

public class Task {
    private int id;
    private String jobName;
    private String status;

    public Task(int id, String jobName, String status) {
        this.id = id;
        this.jobName = jobName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

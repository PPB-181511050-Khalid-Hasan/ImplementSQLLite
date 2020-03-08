package com.example.alonso_app;

import java.util.ArrayList;

public class Task {
    private String mTaskName;
    private String mTaskDetails;

    public Task(String name, String details) {
        mTaskName = name;
        mTaskDetails = details;
    }

    public String getName() {
        return mTaskName;
    }

    public String getDetails() {
        return mTaskDetails;
    }

    public static ArrayList<Task> createTaskList(int numDeadline) {
        ArrayList<Task> taskArrayList = new ArrayList<Task>();

        return taskArrayList;
    }
}

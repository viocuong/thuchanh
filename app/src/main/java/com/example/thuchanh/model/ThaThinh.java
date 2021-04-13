package com.example.thuchanh.model;

public class ThaThinh {
    private int rsImg;
    private String name;
    private int id;
    private String time;
    private float rating;

    public ThaThinh(int rsImg, String name, int id, String time, float rating) {
        this.rsImg = rsImg;
        this.name = name;
        this.id = id;
        this.time = time;
        this.rating = rating;
    }

    public int getRsImg() {
        return rsImg;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public float getRating() {
        return rating;
    }
}

package com.example.saurav.donateblood;

public class BlogPost {

    private String date,post,title,time,uid,username;

    public BlogPost() {
    }

    public BlogPost(String date, String post, String title, String time, String uid, String username) {
        this.date = date;
        this.post = post;
        this.title = title;
        this.time = time;
        this.uid = uid;
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

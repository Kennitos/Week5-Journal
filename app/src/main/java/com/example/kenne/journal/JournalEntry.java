package com.example.kenne.journal;

import java.sql.Timestamp;

public class JournalEntry {
    private int id;
    private String title;
    private String content;
    private Timestamp timestamp;
    private String mood;


    public JournalEntry (int id,String title,String content,Timestamp timestamp,String mood) {
        this.id =  id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.mood = mood;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}

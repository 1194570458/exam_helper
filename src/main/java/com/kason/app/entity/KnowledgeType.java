package com.kason.app.entity;

import java.util.Date;

public class KnowledgeType {
    private Integer id;

    private String chapter;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "KnowledgeType{" +
                "id=" + id +
                ", chapter='" + chapter + '\'' +
                ", date=" + date +
                '}';
    }
}
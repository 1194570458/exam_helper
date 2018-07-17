package com.kason.app.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Property {
    private Integer proId;

    private String chapter;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
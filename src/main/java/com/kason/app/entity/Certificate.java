package com.kason.app.entity;

public class Certificate {
    private Integer cerId;

    private String name;

    private String grade;

    public Integer getCerId() {
        return cerId;
    }

    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}
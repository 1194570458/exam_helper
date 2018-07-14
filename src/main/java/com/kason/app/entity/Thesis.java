package com.kason.app.entity;

public class Thesis {
    private Integer thesisId;

    private String content;

    private Integer proId;

    private Integer cerId;

    public Integer getThesisId() {
        return thesisId;
    }

    public void setThesisId(Integer thesisId) {
        this.thesisId = thesisId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getCerId() {
        return cerId;
    }

    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }
}
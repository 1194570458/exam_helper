package com.kason.app.entity;

public class Synthesize {
    private Integer synId;

    private String title;

    private String select;

    private Integer result;

    private String analysis;

    private Integer proId;

    private Integer cerId;

    public Integer getSynId() {
        return synId;
    }

    public void setSynId(Integer synId) {
        this.synId = synId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select == null ? null : select.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
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
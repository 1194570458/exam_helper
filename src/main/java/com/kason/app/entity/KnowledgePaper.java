package com.kason.app.entity;

public class KnowledgePaper {
    private Integer id;

    private String subject;

    private String question;

    private String answer;

    private Integer knowledgeTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getKnowledgeTypeId() {
        return knowledgeTypeId;
    }

    public void setKnowledgeTypeId(Integer knowledgeTypeId) {
        this.knowledgeTypeId = knowledgeTypeId;
    }
}
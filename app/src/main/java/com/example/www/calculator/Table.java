package com.example.www.calculator;

public class Table {
    private int question;
    private int multiple;
    private int result;

    public Table(int question, int multiple, int result) {
        this.question = question;
        this.multiple = multiple;
        this.result = result;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

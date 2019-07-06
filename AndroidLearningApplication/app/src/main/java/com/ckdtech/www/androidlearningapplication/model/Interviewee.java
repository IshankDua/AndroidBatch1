package com.ckdtech.www.androidlearningapplication.model;

public class Interviewee {

    String name;
    String emailID;
    String phoneNumber;
    int finalTestScore;
    int correctAnswers;
    int wrongAnswers;
    int leftBlank;
    boolean finalStatus;

    public Interviewee(String name, String emailID) {
        this.name = name;
        this.emailID = emailID;
    }

    public String getName() {
        if(name!=null){
            return name;
        }else{return "";}

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFinalTestScore() {
        return finalTestScore;
    }

    public void setFinalTestScore(int finalTestScore) {
        this.finalTestScore = finalTestScore;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getLeftBlank() {
        return leftBlank;
    }

    public void setLeftBlank(int leftBlank) {
        this.leftBlank = leftBlank;
    }

    public boolean isFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(boolean finalStatus) {
        this.finalStatus = finalStatus;
    }

    public Interviewee(String name, String emailID, int finalTestScore, int correctAnswers, int wrongAnswers, int leftBlank) {
        this.name = name;
        this.emailID = emailID;
        this.finalTestScore = finalTestScore;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.leftBlank = leftBlank;
        this.phoneNumber="";
    }

    @Override
    public String toString() {
        return "Interviewee{" +
                "name='" + name + '\'' +
                ", emailID='" + emailID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", finalTestScore='" + finalTestScore + '\'' +
                ", correctAnswers='" + correctAnswers + '\'' +
                ", wrongAnswers='" + wrongAnswers + '\'' +
                ", leftBlank='" + leftBlank + '\'' +
                ", finalStatus=" + finalStatus +
                '}';
    }
}

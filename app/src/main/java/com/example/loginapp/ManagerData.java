package com.example.loginapp;

class ManagerData {
    private String feedbackDepartment, feedbackSubject, feedbackStaff, feedbackRating, feedbackSuggestion;
    public ManagerData() {
    }

    public ManagerData(String feedbackDepartment, String feedbackSubject, String feedbackStaff, String feedbackRating, String feedbackSuggestion) {
        this.feedbackDepartment = feedbackDepartment;
        this.feedbackSubject = feedbackSubject;
        this.feedbackStaff = feedbackStaff;
        this.feedbackRating = feedbackRating;
        this.feedbackSuggestion = feedbackSuggestion;
    }

    public String getFeedbackDepartment() {
        return feedbackDepartment;
    }

    public void setFeedbackDepartment(String feedbackDepartment) {
        this.feedbackDepartment = feedbackDepartment;
    }

    public String getFeedbackSubject() {
        return feedbackSubject;
    }

    public void setFeedbackSubject(String feedbackSubject) {
        this.feedbackSubject = feedbackSubject;
    }

    public String getFeedbackStaff() {
        return feedbackStaff;
    }

    public void setFeedbackStaff(String feedbackStaff) {
        this.feedbackStaff = feedbackStaff;
    }

    public String getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackSuggestion() {
        return feedbackSuggestion;
    }

    public void setFeedbackSuggestion(String feedbackSuggestion) {
        this.feedbackSuggestion = feedbackSuggestion;
    }
}

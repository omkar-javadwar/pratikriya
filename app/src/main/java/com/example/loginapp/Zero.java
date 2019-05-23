package com.example.loginapp;

public class Zero {

    public String dept, sub, staff, rating, suggest;

    public Zero() {
    }

    public Zero(String dept, String sub, String staff, String rating, String suggest) {
        this.dept = dept;
        this.sub = sub;
        this.staff = staff;
        this.rating = rating;
        this.suggest = suggest;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}

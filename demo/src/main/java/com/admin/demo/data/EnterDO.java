package com.admin.demo.data;

public class EnterDO {
    private Integer enterId;

    private Integer activitesId;

    private Integer userId;

    private Integer status;

    private String year;

    private Integer longtime;

    private Integer score;

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public Integer getActivitesId() {
        return activitesId;
    }

    public void setActivitesId(Integer activitesId) {
        this.activitesId = activitesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getLongtime() {
        return longtime;
    }

    public void setLongtime(Integer longtime) {
        this.longtime = longtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
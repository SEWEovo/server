package com.admin.demo.query;
import java.util.List;

public class VolunteerScoreQuery {

    private  Integer id;

    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Integer> getVolunteerIds() {
        return volunteerIds;
    }

    public void setVolunteerIds(List<Integer> volunteerIds) {
        this.volunteerIds = volunteerIds;
    }

    private List<Integer> volunteerIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

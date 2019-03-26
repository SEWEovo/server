package com.admin.demo.data;

import lombok.Data;

import java.util.Date;

@Data
public class ActivitiesDO {
    private Integer activitesId;

    private Integer userId;

    private String name;

    private String des;

    private String content;

    private String place;

    private Date time;

    private Date deadline;

    private Integer num;

    private String welfare;

    private Integer type;

    private String toplace;

    private Date totime;

    private String year;

    private Integer longtime;

    private Integer status;

}
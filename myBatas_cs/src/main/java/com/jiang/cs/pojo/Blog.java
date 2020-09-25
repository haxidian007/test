package com.jiang.cs.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createtime;
    private int views;


    public void setCreateTime(Date date) {
        this.createtime=date;
    }
}

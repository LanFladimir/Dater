package com.dev_lan.dater.bean;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

public class Dater extends LitePalSupport {
    private String dateTitle;
    private String dateDetail;
    private boolean hasCountDown = false;
    private Date deadLine;

    public String getDateTitle() {
        return dateTitle;
    }

    public void setDateTitle(String dateTitle) {
        this.dateTitle = dateTitle;
    }

    public String getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(String dateDetail) {
        this.dateDetail = dateDetail;
    }

    public boolean isHasCountDown() {
        return hasCountDown;
    }

    public void setHasCountDown(boolean hasCountDown) {
        this.hasCountDown = hasCountDown;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "dateTitle = " + dateTitle + " | " + "dateDetail = " + dateDetail ;
    }
}

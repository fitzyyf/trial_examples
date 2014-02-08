/*
 * Copyright (c) 2012-2012 www.iflytek.com. All Rights Reserved.
 * This software for customer relationship management system, developed by Ifly@ZY team.
 * Software code and design for the team, copy rights reserved.
 */

package com.iflytek.train.domain;

import java.util.Date;

public class PeriodicReservation {

    private String courtName;
    private Date fromDate;
    private Date toDate;
    private int period;
    private int hour;
    private Player player;

    public String getCourtName() {
        return courtName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public int getHour() {
        return hour;
    }

    public int getPeriod() {
        return period;
    }

    public Player getPlayer() {
        return player;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}

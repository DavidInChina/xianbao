package com.ws.xianbao.bean;

public class Things {
    private String id;

    private String thingsname;

    private String userid;

    private String userhead;

    private String username;

    private String thingsdes;

    private String thingsimgs;

    private String thingsprice;

    private String uptime;

    private String thingsstatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getThingsname() {
        return thingsname;
    }

    public void setThingsname(String thingsname) {
        this.thingsname = thingsname == null ? null : thingsname.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getThingsdes() {
        return thingsdes;
    }

    public void setThingsdes(String thingsdes) {
        this.thingsdes = thingsdes == null ? null : thingsdes.trim();
    }

    public String getThingsimgs() {
        return thingsimgs;
    }

    public void setThingsimgs(String thingsimgs) {
        this.thingsimgs = thingsimgs == null ? null : thingsimgs.trim();
    }

    public String getThingsprice() {
        return thingsprice;
    }

    public void setThingsprice(String thingsprice) {
        this.thingsprice = thingsprice == null ? null : thingsprice.trim();
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public String getThingsstatus() {
        return thingsstatus;
    }

    public void setThingsstatus(String thingsstatus) {
        this.thingsstatus = thingsstatus == null ? null : thingsstatus.trim();
    }
}
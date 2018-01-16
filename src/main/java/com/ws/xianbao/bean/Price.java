package com.ws.xianbao.bean;

public class Price {
    private String id;

    private String userid;

    private String username;

    private String userhead;

    private String thingsid;

    private String pricetime;

    private String pricedes;

    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public String getThingsid() {
        return thingsid;
    }

    public void setThingsid(String thingsid) {
        this.thingsid = thingsid == null ? null : thingsid.trim();
    }

    public String getPricetime() {
        return pricetime;
    }

    public void setPricetime(String pricetime) {
        this.pricetime = pricetime == null ? null : pricetime.trim();
    }

    public String getPricedes() {
        return pricedes;
    }

    public void setPricedes(String pricedes) {
        this.pricedes = pricedes == null ? null : pricedes.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}
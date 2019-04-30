package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.AppDetail;

import java.math.BigDecimal;
import java.util.List;

public class AppDetailForContactVO {
    private Integer id;
    private Integer parkId;
    private Integer appId;
    private String cover;
    private String address;
    private BigDecimal price;
    private String model;
    private String color;
    private List contact;
    private String description;
    private String introduction;
    private Byte status;
    private String content;

    public AppDetailForContactVO() {
    }

    public AppDetailForContactVO(AppDetail appDetail,List contact) {
        this.id = appDetail.getId();
        this.parkId = appDetail.getParkId();
        this.appId = appDetail.getAppId();
        this.cover = appDetail.getCover();
        this.address = appDetail.getAddress();
        this.price = appDetail.getPrice();
        this.model = appDetail.getModel();
        this.color = appDetail.getColor();
        this.contact = contact;
        this.description = appDetail.getDescription();
        this.introduction = appDetail.getIntroduction();
        this.status = appDetail.getStatus();
        this.content = appDetail.getContent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List getContact() {
        return contact;
    }

    public void setContact(List contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

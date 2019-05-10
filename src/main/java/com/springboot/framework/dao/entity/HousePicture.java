package com.springboot.framework.dao.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_house_picture")
public class HousePicture {
    @Id
    private Integer id;

    private String picture;

    private Integer houseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
package com.springboot.framework.dao.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_connection")
public class Connection {
    @Id
    private Integer id;

    private Integer parkId;

    private Integer appId;

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
}
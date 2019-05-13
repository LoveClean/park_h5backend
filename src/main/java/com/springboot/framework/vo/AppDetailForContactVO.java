package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.AppDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
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

    public AppDetailForContactVO(AppDetail appDetail, List contact) {
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
}

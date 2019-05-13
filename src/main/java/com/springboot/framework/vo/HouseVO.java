package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.House;
import com.springboot.framework.dao.entity.HousePicture;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class HouseVO {
    private Integer houseId;
    private Integer parkId;
    private String cover;
    private String contact;
    private String location;
    private Integer acreage;
    private Integer floor;

    private String orientation;
    private String finish;
    private String elevator;
    private String tenancyTerm;
    private String registeredCompany;

    private BigDecimal usageRate;
    private BigDecimal unitPrice;
    private BigDecimal price;
    private BigDecimal serviceCharge;
    private BigDecimal cashPledge;
    private BigDecimal propertyFee;
    private String label;
    private String introduction;
    private String remark;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    private List<HousePicture> pictureList;

    public HouseVO() {
    }

    public HouseVO(House house, List<HousePicture> pictureList) {
        this.houseId = house.getId();
        this.parkId = house.getParkId();
        this.cover = house.getCover();
        this.contact = house.getContact();
        this.location = house.getLocation();
        this.acreage = house.getAcreage();
        this.floor = house.getFloor();
        switch (house.getOrientation()) {
            case 1:
                this.orientation = "北";
                break;
            case 2:
                this.orientation = "东北";
                break;
            case 3:
                this.orientation = "东";
                break;
            case 4:
                this.orientation = "东南";
                break;
            case 5:
                this.orientation = "南";
                break;
            case 6:
                this.orientation = "西南";
                break;
            case 7:
                this.orientation = "西";
                break;
            case 8:
                this.orientation = "西北";
                break;
            default:
                ;
        }
        switch (house.getFinish()) {
            case 1:
                this.finish = "毛胚";
                break;
            case 2:
                this.finish = "简装";
                break;
            case 3:
                this.finish = "精装";
                break;
            default:
                ;
        }
        switch (house.getElevator()) {
            case 1:
                this.elevator = "有";
                break;
            case 2:
                this.elevator = "无";
                break;
            default:
                ;
        }
        switch (house.getTenancyTerm()) {
            case 1:
                this.tenancyTerm = "月租";
                break;
            case 2:
                this.tenancyTerm = "三个月";
                break;
            case 3:
                this.tenancyTerm = "半年";
                break;
            case 4:
                this.tenancyTerm = "一年";
                break;
            case 5:
                this.tenancyTerm = "两年及以上";
                break;
            default:
                ;
        }
        switch (house.getRegisteredCompany()) {
            case 1:
                this.registeredCompany = "是";
                break;
            case 2:
                this.registeredCompany = "否";
                break;
            default:
                ;
        }
        this.usageRate = house.getUsageRate();
        this.unitPrice = house.getUnitPrice();
        this.price = house.getPrice();
        this.serviceCharge = house.getServiceCharge();
        this.cashPledge = house.getCashPledge();
        this.propertyFee = house.getPropertyFee();
        this.label = house.getLabel();
        this.introduction = house.getIntroduction();
        this.remark = house.getRemark();
        this.createBy = house.getCreateBy();
        this.createDate = house.getCreateDate();
        this.updateBy = house.getUpdateBy();
        this.updateDate = house.getUpdateDate();
        this.status = house.getStatus();
        this.pictureList = pictureList;
    }
}

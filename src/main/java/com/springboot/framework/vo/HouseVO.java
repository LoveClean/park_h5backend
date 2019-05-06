package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.House;
import com.springboot.framework.dao.entity.HousePicture;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
        }
        switch (house.getElevator()) {
            case 1:
                this.elevator = "有";
                break;
            case 2:
                this.elevator = "无";
                break;
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
        }
        switch (house.getRegisteredCompany()) {
            case 1:
                this.registeredCompany = "是";
                break;
            case 2:
                this.registeredCompany = "否";
                break;
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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getTenancyTerm() {
        return tenancyTerm;
    }

    public void setTenancyTerm(String tenancyTerm) {
        this.tenancyTerm = tenancyTerm;
    }

    public String getRegisteredCompany() {
        return registeredCompany;
    }

    public void setRegisteredCompany(String registeredCompany) {
        this.registeredCompany = registeredCompany;
    }

    public BigDecimal getUsageRate() {
        return usageRate;
    }

    public void setUsageRate(BigDecimal usageRate) {
        this.usageRate = usageRate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(BigDecimal cashPledge) {
        this.cashPledge = cashPledge;
    }

    public BigDecimal getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(BigDecimal propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<HousePicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<HousePicture> pictureList) {
        this.pictureList = pictureList;
    }
}

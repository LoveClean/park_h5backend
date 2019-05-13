package com.springboot.framework.vo;

import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.dao.entity.InformationInfo;
import lombok.Data;

import java.util.Date;

@Data
public class InformationVO {
    private Integer informationId;
    private Integer parkId;
    private Integer categoryId;
    private String title;
    private String introduction;
    private String cover;
    private Integer readCount;
    private Integer likeCount;
    private Byte sort;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Byte status;

    private String picture;
    private String content;

    public InformationVO() {
    }

    public InformationVO(Information information, InformationInfo informationInfo) {
        this.informationId = information.getId();
        this.parkId = information.getParkId();
        this.categoryId = information.getCategoryId();
        this.title = information.getTitle();
        this.introduction = information.getIntroduction();
        this.cover = information.getCover();
        this.readCount = information.getReadCount();
        this.likeCount = information.getLikeCount();
        this.sort = information.getSort();
        this.createBy = information.getCreateBy();
        this.createDate = information.getCreateDate();
        this.updateBy = information.getUpdateBy();
        this.updateDate = information.getUpdateDate();
        this.status = information.getStatus();
        this.picture = informationInfo.getPicture();
        this.content = informationInfo.getContent();
    }
}

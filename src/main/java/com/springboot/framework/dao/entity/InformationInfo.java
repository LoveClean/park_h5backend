package com.springboot.framework.dao.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_information_info")
public class InformationInfo {
    @Id
    private Integer informationId;

    private String picture;

    private String content;

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
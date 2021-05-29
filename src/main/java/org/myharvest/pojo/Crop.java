package org.myharvest.pojo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "crop")
@EntityListeners({AuditingEntityListener.class})
public class Crop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cropId;

    private String cropName;

    private Integer userId;

    private BigDecimal cropPrice;

    private BigDecimal cropWeight;

    private String cropProduction;

    private String cropArea;

    private String cropComment;

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getCropPrice() {
        return cropPrice;
    }

    public void setCropPrice(BigDecimal cropPrice) {
        this.cropPrice = cropPrice;
    }

    public BigDecimal getCropWeight() {
        return cropWeight;
    }

    public void setCropWeight(BigDecimal cropWeight) {
        this.cropWeight = cropWeight;
    }

    public String getCropProduction() {
        return cropProduction;
    }

    public void setCropProduction(String cropProduction) {
        this.cropProduction = cropProduction;
    }

    public String getCropArea() {
        return cropArea;
    }

    public void setCropArea(String cropArea) {
        this.cropArea = cropArea;
    }

    public String getCropComment() {
        return cropComment;
    }

    public void setCropComment(String cropComment) {
        this.cropComment = cropComment;
    }

}


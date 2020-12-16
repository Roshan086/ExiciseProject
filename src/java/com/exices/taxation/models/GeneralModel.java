/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.models;

import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author Roshan
 */
public class GeneralModel {
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_by")
    private Integer modifiedBy;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="modified_date")
    private Date modifiedDate;

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    
}

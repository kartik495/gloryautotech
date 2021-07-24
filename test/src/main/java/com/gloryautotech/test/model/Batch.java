package com.gloryautotech.test.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Batch {
    @Id
    @GeneratedValue
    private int id;
    private int batchId;
    private int mtr;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stockId", referencedColumnName = "id", insertable = true, updatable = true)        
    private Stock stock;
    public int getId() {
        return id;
    }
    // public void setId(int id) {
    //     this.id = id;
    // }
    public int getBatchId() {
        return batchId;
    }
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }
    public int getMtr() {
        return mtr;
    }
    public void setMtr(int mtr) {
        this.mtr = mtr;
    }
    public int getStockId() {
        return stock.getId();
    }
    public void setStockId(Stock stock) {
        this.stock = stock;
    }
    public int getQualityId(){
        return this.stock.getQualityId();
    }
    

}

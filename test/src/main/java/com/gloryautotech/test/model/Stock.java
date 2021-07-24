package com.gloryautotech.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Stock {
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="qualityId", referencedColumnName = "id", insertable = true, updatable = true)    
private Quality quality;

@OneToMany(mappedBy = "stock", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
    CascadeType.REFRESH ,CascadeType.REMOVE})
private List<Batch> batches;  



    public int getId() {
        return id;
    }
    // public void setId(int id) {
    //     this.id = id;
    // }
    public int getQualityId() {
        return quality.getId();
    }
    public void setQualityId(Quality quality) {
        this.quality = quality;
    }
    public void getQualityName(){
        System.out.println(this.quality.getName());
    }
    
    
}

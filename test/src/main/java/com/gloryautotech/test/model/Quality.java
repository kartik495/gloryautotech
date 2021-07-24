package com.gloryautotech.test.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class Quality {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @OneToMany(mappedBy = "quality", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
        CascadeType.REFRESH ,CascadeType.REMOVE})
private List<Stock> stocks;  
    public int getId() {
        return id;
    }
    // public void setId(int id) {
    //     this.id = id;
    // }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}

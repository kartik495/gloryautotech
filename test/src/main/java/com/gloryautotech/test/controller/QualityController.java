package com.gloryautotech.test.controller;


import com.gloryautotech.test.crud.BatchCrud;
import com.gloryautotech.test.crud.QualityCrud;
import com.gloryautotech.test.crud.StockCrud;
import com.gloryautotech.test.model.Batch;
import com.gloryautotech.test.model.Quality;
import com.gloryautotech.test.model.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
@Controller
public class QualityController{
    @Autowired
    BatchCrud batchrepo;
    @Autowired
    QualityCrud qualityrepo;
    @Autowired
    StockCrud stockrepo;

    @PostMapping("/addQuality")
    public Quality add(Quality quality){
        System.out.println(quality.getId());
        qualityrepo.save(quality);
        
        return quality;
    }

    @DeleteMapping("/deleteQuality/{id}")
    public String delete(@PathVariable int id){
        qualityrepo.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/quality/{id}")
    public Quality get(@PathVariable int id){
        return qualityrepo.findById(id).get();
    }

    @PutMapping("/update/quality")
    public Quality update( int id,String name){
        Quality q=qualityrepo.findById(id).get();
        q.setName( name);
        qualityrepo.save(q);
        return q;
    }


}


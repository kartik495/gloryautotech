package com.gloryautotech.test.controller;


import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestBody;

@ResponseBody
@Controller
public class StockController {
    @Autowired
    BatchCrud batchrepo;
    @Autowired
    QualityCrud qualityrepo;
    @Autowired
    StockCrud stockrepo;


    @PostMapping("/addStock")
    public Stock add(Stock stock){

stock.getQualityName();
        stockrepo.save(stock);
        return stock;
    }

    @DeleteMapping("/deleteStock/{id}")
    public String delete(@PathVariable int id){
        stockrepo.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/stock/{id}")
    public Stock get(@PathVariable int id){
        return stockrepo.findById(id).get();
    }
    
    @PutMapping("/update/stock")
    public Stock update( int id,int qualityId) {
        //TODO: process POST request
        Stock s=stockrepo.findById(id).get();
        Quality q=qualityrepo.findById(qualityId).get();
        s.setQualityId( q);
        stockrepo.save(s);
        
        return s;
    }
    

}

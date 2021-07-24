package com.gloryautotech.test.controller;
import java.util.HashMap;
import java.util.List;

import com.gloryautotech.test.crud.BatchCrud;
import com.gloryautotech.test.crud.QualityCrud;
import com.gloryautotech.test.crud.StockCrud;
import com.gloryautotech.test.model.Batch;
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
public class BatchController {
    @Autowired
    BatchCrud batchrepo;
    @Autowired
    QualityCrud qualityrepo;
    @Autowired
    StockCrud stockrepo;

    @PostMapping("/addBatch")
    public Batch add(Batch batch){
batchrepo.save(batch);
        return batch;
    } 

    @DeleteMapping("/deleteBatch/{id}")
    public String delete(@PathVariable int id){
        batchrepo.deleteById(id);
        return "Deleted";
    }

    @GetMapping("/batch/{id}")
    public Batch get(@PathVariable int id){
        return batchrepo.findById(id).get();
    }


    @PutMapping("/update/batch")
    public Batch update( int id,int stockId,int batchId,int mtr) {
        //TODO: process POST request
        Batch s=batchrepo.findById(id).get();
        Stock q=stockrepo.findById(stockId).get();
        s.setStockId( q);
        s.setBatchId(batchId);
        s.setMtr(mtr);

        batchrepo.save(s);
        
        return s;
    }


    @GetMapping("/batch/metersum/{id}")
    public HashMap getMeterSum(@PathVariable int id){
        HashMap data=new HashMap<Integer,Integer>();
        for(Batch batch:batchrepo.findAll()){
if(batch.getQualityId()==id){
    int key=batch.getBatchId();
    if (data.containsKey( key)){
        data.put(key, (int)data.get(key)+batch.getMtr());
    }
    else{
        data.put(key, batch.getMtr());
    }
}
        }
        return data;
    }

}

package com.gloryautotech.test.crud;

import com.gloryautotech.test.model.Stock;

import org.springframework.data.repository.CrudRepository;

public interface StockCrud extends CrudRepository<Stock,Integer> {
    
}

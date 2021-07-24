package com.gloryautotech.test.crud;

import com.gloryautotech.test.model.Batch;

import org.springframework.data.repository.CrudRepository;

public interface BatchCrud extends CrudRepository<Batch,Integer>  {
    
}

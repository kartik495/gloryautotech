package com.gloryautotech.test.crud;

import com.gloryautotech.test.model.Quality;

import org.springframework.data.repository.CrudRepository;

public interface QualityCrud extends CrudRepository<Quality,Integer> {
    
}

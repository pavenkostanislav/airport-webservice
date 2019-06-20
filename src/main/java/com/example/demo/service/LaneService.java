package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ILaneRepository;
import com.example.demo.model.Lane;

@Component
public class LaneService extends GenericService<Lane, ILaneRepository> {
    private static final Logger logger = LoggerFactory.getLogger(LaneService.class);
    
	@Override
	@Cacheable(value="LaneServiceCache", key="T(classType).hash(#id)")
	public Lane get(ILaneRepository crudRepository, Long id) {
        logger.info("called get method with id.equal(" + id + ") param");
		return super.get(crudRepository, id);
	}
}

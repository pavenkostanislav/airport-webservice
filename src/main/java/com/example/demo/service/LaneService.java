package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ILaneRepository;
import com.example.demo.model.Lane;

@Component
public class LaneService extends GenericService<Lane, ILaneRepository> {
    private static final Logger logger = LoggerFactory.getLogger(Lane.class);
	@Override
	@Cacheable(cacheNames="getLane")
	public Lane get(ILaneRepository crudRepository, Long id) {
        logger.info("get lane: " + id);
		return super.get(crudRepository, id);
	}
}

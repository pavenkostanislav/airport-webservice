package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ILaneRepository;
import com.example.demo.model.Lane;

@Component
@EnableCaching
@CacheConfig(cacheNames = "LaneServiceCache")
public class LaneService extends GenericService<Lane, ILaneRepository> {
    private static final Logger logger = LoggerFactory.getLogger(LaneService.class);
	@Override
	@Cacheable(sync=true)
	public Lane get(ILaneRepository crudRepository, Long id) {
        logger.info("called method get with params: crudRepository: " + crudRepository.toString() + " id=" + id);
		return super.get(crudRepository, id);
	}
}

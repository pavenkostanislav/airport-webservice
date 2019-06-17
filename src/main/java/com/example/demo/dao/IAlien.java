package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface IAlien extends CrudRepository<Alien, Integer> {

}

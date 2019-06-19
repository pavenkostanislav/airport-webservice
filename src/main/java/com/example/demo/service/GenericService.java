package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.controller.Vocabulary;
import com.example.demo.controller.VocabularyKeys;
import com.example.demo.dao.ICleanAndId;


public class GenericService<T extends ICleanAndId> {	 
	public T set(CrudRepository<T, Long> crudRepository, T row) throws Exception {
		T objFromDb = crudRepository.save(row);
		objFromDb.clean();
		return objFromDb;
	}

	public T put(CrudRepository<T, Long> crudRepository, Long id, T obj) throws Exception {
			if(obj.getID().longValue() != id) {
				throw new Exception(Vocabulary.dictionary.get(VocabularyKeys.notFound));
			}
			T objFromDb = crudRepository.findById(id).orElseThrow(null);
			if(objFromDb == null) {
				throw new Exception(Vocabulary.dictionary.get(VocabularyKeys.notFound));
			}
			return this.set(crudRepository, obj);
	}

	public T get(CrudRepository<T, Long> crudRepository, Long id) {
		T obj = crudRepository.findById(id).orElseThrow(null);
		obj.clean();
		return obj;
	}
	
	public Long delete(CrudRepository<T, Long> crudRepository, Long id) {
		crudRepository.deleteById(id);
		return id;
	}
	
	public Iterable<T> getAll(CrudRepository<T, Long> crudRepository) {
		Iterable<T> collection = crudRepository.findAll();
		
		collection.forEach(row -> {
		    row.clean();
		});
		return collection;
	}

}

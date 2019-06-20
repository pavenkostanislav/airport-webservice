package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.controller.Vocabulary;
import com.example.demo.controller.VocabularyKeys;
import com.example.demo.dao.ICleanAndId;


public class GenericService<T extends ICleanAndId, U extends CrudRepository<T, Long>> {
    private static final Logger logger = LoggerFactory.getLogger(GenericService.class);
    
	public T set(U crudRepository, T row) throws Exception {
		T objFromDb = crudRepository.save(row);
		objFromDb.clean();
		return objFromDb;
	}

	public T put(U crudRepository, Long id, T obj) throws Exception {
			if(obj.getID().longValue() != id) {
				throw new Exception(Vocabulary.dictionary.get(VocabularyKeys.notFound));
			}
			T objFromDb = crudRepository.findById(id).orElseThrow(null);
			if(objFromDb == null) {
				throw new Exception(Vocabulary.dictionary.get(VocabularyKeys.notFound));
			}
			return this.set(crudRepository, obj);
	}

	public T get(U crudRepository, Long id) {
        logger.info("called get method with id.equal(" + id + ") param");
        
		T obj = crudRepository.findById(id).orElseThrow(null);
		obj.clean();
		return obj;
	}
	
	public Long delete(U crudRepository, Long id) {
		crudRepository.deleteById(id);
		return id;
	}
	
	public Iterable<T> getAll(U crudRepository) {
		Iterable<T> collection = crudRepository.findAll();
		
		collection.forEach(row -> {
		    row.clean();
		});
		return collection;
	}

}

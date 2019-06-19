package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;


public final class Vocabulary {

	public static final Map<VocabularyKeys,String> dictionary = new HashMap<VocabularyKeys,String>();
	
	static {
		 dictionary.put(VocabularyKeys.notNull, "Data should be is not null!");
		 dictionary.put(VocabularyKeys.badRequest, "Somefing went wrong...");
		 dictionary.put(VocabularyKeys.notFound, "Data is not found!");
	}
}

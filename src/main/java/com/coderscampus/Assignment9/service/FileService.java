package com.coderscampus.Assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
//import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.Recipe;

@Service
public class FileService {

	
		//Read the file twice? Once to get Headers, then read a second time to get the rest
		public ArrayList<Recipe> readRecipe(ArrayList<Recipe> recipeList) throws IOException {
		//ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		Reader in = new FileReader("recipes.txt");
		
//	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader().parse(in);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("Cooking Minutes", "Dairy Free", "Instructions", "Preparation Minutes", "Price Per Serving",
//				"Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian").parse(in);
	//	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withQuote(null).parse(in);
		//Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			
			
			//convert from string for all types
			recipeList.add(new Recipe(
					Integer.parseInt(record.get("Cooking Minutes")),
					Boolean.parseBoolean(record.get("Dairy Free")),
					Boolean.parseBoolean(record.get("Gluten Free")),
					record.get("Instructions"),
					Double.parseDouble(record.get("Preparation Minutes")),
					Double.parseDouble(record.get("Price Per Serving")),
					Integer.parseInt(record.get("Ready In Minutes")),
					Integer.parseInt(record.get("Servings")),
					Double.parseDouble(record.get("Spoonacular Score")),
					record.get("Title"),
					Boolean.parseBoolean(record.get("Vegan")),				
							Boolean.parseBoolean(record.get("Vegetarian"))
					));
//			int parseInt = Integer.parseInt(record.get(0));
//			Boolean.parseBoolean(record.get(1));
//			Boolean.parseBoolean(record.get(2));
//			record.get(3);
		 }
	
	return recipeList;
	}
}

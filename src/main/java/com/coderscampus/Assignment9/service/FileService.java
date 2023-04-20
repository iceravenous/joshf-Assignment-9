package com.coderscampus.Assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.Recipe;

@Service
public class FileService {

	
		//Read the file twice? Once to get Headers, then read a second time to get the rest
		public ArrayList<Recipe> readRecipe(ArrayList<Recipe> recipeList) throws IOException {
	
			Reader in = new FileReader("recipes.txt");
			
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',')
					.withQuote('"')
					.withEscape('\\')
					.withIgnoreSurroundingSpaces(true)
//					.withSkipHeaderRecord()
					.parse(in);
			if (recipeList.size() == 0) {
				for (CSVRecord record : records) {
					if (record.get(0).equals("Cooking Minutes")) {
						System.out.println("Header");
					} else {
						recipeList.add(new Recipe(
								Integer.parseInt(record.get(0)),
								Boolean.parseBoolean(record.get(1)),
								Boolean.parseBoolean(record.get(2)),
								record.get(3),
								Double.parseDouble(record.get(4)),
								Double.parseDouble(record.get(5)),
								Integer.parseInt(record.get(6)),
								Integer.parseInt(record.get(7)),
								Double.parseDouble(record.get(8)),
								record.get(9),
								Boolean.parseBoolean(record.get(10)),				
										Boolean.parseBoolean(record.get(11))
								));	
					}
					
				}
			}
		return recipeList;
	}
		public List<Recipe> readRecipe(List<Recipe> recipeList, String filter) throws IOException {
			
			Reader in = new FileReader("recipes.txt");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',')
					.withQuote('"')
					.withEscape('\\')
					.withIgnoreSurroundingSpaces(true)
					.withSkipHeaderRecord().parse(in);
			if (recipeList.size() == 0) {
				for (CSVRecord record : records) {
					recipeList.add(new Recipe(
							Integer.parseInt(record.get(0)),
							Boolean.parseBoolean(record.get(1)),
							Boolean.parseBoolean(record.get(2)),
							record.get(3),
							Double.parseDouble(record.get(4)),
							Double.parseDouble(record.get(5)),
							Integer.parseInt(record.get(6)),
							Integer.parseInt(record.get(7)),
							Double.parseDouble(record.get(8)),
							record.get(9),
							Boolean.parseBoolean(record.get(10)),				
									Boolean.parseBoolean(record.get(11))
							));
				}
			}
			if (filter.equals("vegan")) {
				System.out.println("This is a vegan list");
				List<Recipe> vList = new ArrayList<Recipe>();
				vList = recipeList.stream()
						.filter(type -> type.getVegan()==true)
						.collect(Collectors.toList());
				return vList;
			} else if(filter.equals("gluten-free")) {
				System.out.println("This is a gluten free list");
				List<Recipe> vList = new ArrayList<Recipe>();
				vList = recipeList.stream()
						.filter(type -> type.getGlutenFree()==true)
						.collect(Collectors.toList());
				return vList;
			}else if(filter.equals("vegetarian")) {
				System.out.println("This is a vegetarian list");
				List<Recipe> vList = new ArrayList<Recipe>();
				vList = recipeList.stream()
						.filter(type -> type.getVegetarian()==true)
						.collect(Collectors.toList());
				return vList;
			}else if(filter.equals("vegetarian-and-gluten-free")) {
				System.out.println("This is a vegatarin and Gluten Free list");
				List<Recipe> vList = new ArrayList<Recipe>();
				vList = recipeList.stream()
						.filter(type -> (type.getVegetarian()==true) || (type.getGlutenFree()==true))
						.collect(Collectors.toList());
				return vList;
			}
			System.out.println("This is the whole list");
			return recipeList;
		
	}
}

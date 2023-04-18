package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.Recipe;
import com.coderscampus.Assignment9.service.FileService;

@RestController
public class FileController {
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	
@Autowired
private FileService fileService;
	
	
	@GetMapping("/all-recipes")
	public List<Recipe> readLines() throws IOException {
	
		return fileService.readRecipe(recipeList);		
	}
	
	@GetMapping("/vegan")
	public List<Recipe> readLinesVegan() throws IOException {
		return fileService.readRecipe(recipeList, "vegan");
				
	}
	@GetMapping("/gluten-free")
	public List<Recipe> readLinesGlutenFree() throws IOException {
		return fileService.readRecipe(recipeList, "gluten-free");
				
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> readLinesVegetarian() throws IOException {
		return fileService.readRecipe(recipeList, "vegetarian");
				
	}
	@GetMapping("/vegetarian-and-gluten-free")
	public List<Recipe> readLinesVegetariangf() throws IOException {
		return fileService.readRecipe(recipeList, "vegetarian-and-gluten-free");
				
	}
	
}

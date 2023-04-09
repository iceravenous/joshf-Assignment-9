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
}

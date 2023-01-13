package com.cucumber.test;

import com.curd.functions.test.CreateReviewFinal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdef {
	
	@Given ("setup test data into jason & use post method")
	public void setup() {
		CreateReviewFinal.post();
	}
    @Then ("validate test cases")
    public void postTestcases() {
    	CreateReviewFinal.postTestcases();
    }

}

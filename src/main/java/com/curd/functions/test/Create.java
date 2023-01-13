package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {
public static void post () {
	
	//1st>> write test data into JSON
			JsonObject jo= new JsonObject();
			jo.addProperty("Batch", "29");
			jo.addProperty("Name", "sarower");
			//2nd>>add json data in restassured body
			RequestSpecification rs=RestAssured.given();
			rs.body(jo.toString());
			// 3rd specify test data format inside header
			rs.header("Content-Type","application/json");
			
			// 4th use post() and send new data via post URL
			Response response = rs.post("https://httpbin.org/post");
			System.out.println(response.prettyPrint());
			//Test cases 
			 //1st=status code=200
			System.out.println("Status code found ="+response.statusCode());
			SoftAssert sf = new SoftAssert();
			sf.assertEquals(response.statusCode(), 200);
			//2nd= response time
			System.out.println("Response time found ="+response.time());// <3000
			sf.assertTrue(response.time()<3000);
			//3rd= data format check >> contenttype
			System.out.println("Data format check ="+response.contentType());// JSON
			sf.assertTrue(response.contentType().contains("json"));
			//4th= data null or not
			System.out.println("Data should not be null ="+ response.body());// null or not null
			sf.assertTrue(!response.body().equals(null));
}
	
		
	}
	

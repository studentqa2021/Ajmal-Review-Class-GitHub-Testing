package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Read {

	public static void get () {
		
		Response response = RestAssured.get("https://httpbin.org/get");
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

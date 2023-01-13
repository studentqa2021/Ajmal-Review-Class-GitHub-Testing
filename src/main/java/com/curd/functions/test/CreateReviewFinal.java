package com.curd.functions.test;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateReviewFinal {
	
	static Response response;
	
public static void post() {
	JsonObject jo = new JsonObject();
	jo.addProperty("Batch", "29");
	
	RequestSpecification rs = RestAssured.given();
	rs.body(jo.toString());
	rs.header("Content-Type", "application/json");
	
	 response = rs.post("https://httpbin.org/post");
	System.out.println(response.prettyPrint());
}
	public static void postTestcases() {
		SoftAssert sa = new SoftAssert();
		// ******Writing these extra message in code will help us to find which test case is failing after execution as without msg we won't be able to see which test case is failing as SOFT ASSERT does not let code to stop 
	//Status Code Check 
	sa.assertTrue(response.statusCode()==200,"Expected = 200"+"Actual ="+response.statusCode());
	//Response Time
	
	sa.assertTrue(response.time()<2000,"Expected = 1000"+ "Actual ="+response.time());
	//Content Type
	sa.assertTrue(response.contentType().contains("json"),"+Expected = Json"+"Actual="+response.contentType().contains("json"));
	//Body >> data null or not 
	sa.assertTrue(!response.body().asString().equals(null),"Expected = not null"+"Actual ="+response.body().asString().equals(null));
	// Check Attribute or locator present or not 
	sa.assertTrue(response.asString().contains("Batch"));
	//Check Value of Attribute in this case attribute Value is 29
	JsonPath jp = response.jsonPath();
	//System.out.println(jp.get("json.Batch").toString().contains("29"));
	//In all test cases we replaced System.out.println with sa.assertTrue as SYSO is only for our understanding not included in automation. 
	sa.assertTrue(jp.get("json.Batch").toString().contains("29"));
	
	sa.assertAll();
}  


}

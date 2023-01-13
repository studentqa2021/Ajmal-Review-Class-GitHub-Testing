package com.api.testrun;

import org.testng.annotations.Test;

import com.curd.functions.test.CreateReviewFinal;
import com.report.ExtentReportAutomation;

public class FinalPostTestRunTestNG extends ExtentReportAutomation{
	
//	@BeforeTest
//	public void setup() {
//		CreateReviewFinal.post();
//		
//			}
	@Test 
	public void postTestCases() {
		CreateReviewFinal.post();
		CreateReviewFinal.postTestcases();
	}
	
}

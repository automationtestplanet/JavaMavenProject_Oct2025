package com.testng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationtestplanet.ExcelUtils;

public class BaseTestNG {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuit() {
		System.out.println("This is BeforeSuit");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("This is BeforeTest");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("This is BeforeClass");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("This is BeforeMethod");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("This is AfterMethod");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("This is AfterClass");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("This is AfterTest");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuit() {
		System.out.println("This is AfterSuit");
	}

	@DataProvider(name = "objectArray")
	public Object[] testData1() {
		Object[] objArr = new Object[3];
		objArr[0] = "Apple";
		objArr[1] = "Banana";
		objArr[2] = "Cherry";
		return objArr;
	}

	@DataProvider(name = "twoDimensionObjectArray")
	public Object[][] testData2() {
		Object[][] objArr = { { "Apple", "Banana", "Cherry" }, { "Onion", "Tamoto", "Chilly" } };
		return objArr;
	}

	@DataProvider(name = "iteratorOfString")
	public Iterator<String> testData3() {
		List<String> stringsList = new ArrayList<>();
		stringsList.add("Apple");
		stringsList.add("Banana");
		stringsList.add("Cherry");

		return stringsList.iterator();
	}

	@DataProvider(name = "iteratorOfMaps")
	public Iterator<Map<String, String>> dataDrivenWithIteratorOfMaps() {
		ExcelUtils excel = new ExcelUtils();
		String excelFilePath = System.getProperty("user.dir") + "//src//test//resources//Test.xlsx";

		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "Languages");

		return testData.iterator();
	}
}

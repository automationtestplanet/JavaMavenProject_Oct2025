package com.testng;


import java.util.Map;
import org.testng.annotations.Test;


public class DataDrivenTest extends BaseTestNG {

	@Test(dataProvider = "objectArray")
	public void dataDrivenWithObjectArray(String eachString) {
		System.out.println("DataDriven Testing with Object Array: " + eachString);
	}

	@Test(dataProvider = "twoDimensionObjectArray")
	public void dataDrivenWithTwoDimentsionObjectArray(String[] eachArray) {
		for (String eachStr : eachArray) {
			System.out.println("DataDriven Testing with Two Dimension Object Array: " + eachStr);
		}
	}

	@Test(dataProvider = "iteratorOfString")
	public void dataDrivenWithIterator(String eachItem) {
		System.out.println("DataDriven Testing with Iterator: " + eachItem);
	}

	@Test(dataProvider = "iteratorOfMaps")
	public void dataDrivenWithIteratorOfMaps(Map<String, String> eachMap) {
		System.out.println("DataDriven Testing with Iterator of Maps : " + eachMap.get("Language") + "   "
				+ eachMap.get("TypeOfLanguage"));
	}

}

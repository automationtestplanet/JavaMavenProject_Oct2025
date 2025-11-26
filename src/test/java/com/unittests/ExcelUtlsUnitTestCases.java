package com.unittests;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.automationtestplanet.ExcelUtils;

public class ExcelUtlsUnitTestCases {

	ExcelUtils excel = new ExcelUtils();
	
	@Test
	public void readDataFromInvalidExcelFileTest() {		
		String excelFilePath = System.getProperty("user.dir") + "//src//test//resources//InputData.txt";

		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "Languages");
		Assert.assertNull(testData);
	}

	@Test
	public void readDataFromValidExcelFileAndInvalidSheetTest() {
		String excelFilePath = System.getProperty("user.dir") + "//src//test//resources//Test.xlsx";

		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "Languages1");
		Assert.assertNull(testData);
	}

	@Test
	public void readDataFromValidExcelFileAndValidSheetTest() {
		String excelFilePath = System.getProperty("user.dir") + "//src//test//resources//Test.xlsx";

		List<Map<String, String>> testData = excel.readDataFromExcel(excelFilePath, "Languages");
		
//		if(testData.isEmpty() || testData==null) {
//			System.out.println("Fail");
//		}else {
//			System.out.println("Fail");
//		}
		
		Assert.assertNotNull("Test Data should not be null", testData);
		Assert.assertTrue("Test Data SHould not be Empty", !testData.isEmpty());
		
		
		Map<String,String> filteredMap = testData.stream().filter(eachMap -> eachMap.get("Language").equals("Java")).findFirst()
	    .orElseThrow(() -> new NoSuchElementException("Expected to find a map with key 'Java'"));
		
//		System.out.println(filteredMap);

		Assert.assertEquals("Expected Value is Object Oriendted Programming","Object Oriendted Programming", filteredMap.get("TypeOfLanguage") );
		
//		

		
	}

}

package com.testing;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.automationtestplanet.JsonUtils;

import models.UserDetails;

public class JsonUtilsUnitTestCases {

	JsonUtils json = new JsonUtils();

	@Test
	public void readDataFromInvalidJsonFileTest() {
		String jsonFilePath = System.getProperty("user.dir") + "//src//main//resources//InputData.txt";
		JSONObject jsonData = json.readDataFromJson(jsonFilePath);
		Assert.assertNull(jsonData);
	}

	@Test
	public void readDataFromValidJsonFileWithInvalidFieldTest() {
		String jsonFilePath = System.getProperty("user.dir") + "//src//main//resources//UserDetails.json";
		JSONObject jsonData = json.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(jsonData);
		Assert.assertNull(jsonData.get("name1"));
	}

	@Test
	public void readDataFromValidJsonFileWithValidFieldTest() {
		String jsonFilePath = System.getProperty("user.dir") + "//src//main//resources//UserDetails.json";
		JSONObject jsonData = json.readDataFromJson(jsonFilePath);
		Assert.assertNotNull(jsonData);
		Assert.assertEquals("Both the values should match", "Raju", jsonData.get("name"));
	}

	@Test
	public void readDataFromValidJsonWithUserDetailsModelTest() {
		String jsonFilePath = System.getProperty("user.dir") + "//src//main//resources//UserDetails.json";
		UserDetails userDetails = json.readDataFromJsonAsUserDetails(jsonFilePath);
		Assert.assertNotNull(userDetails);
		Assert.assertEquals("Name should match with Raju", "Raju", userDetails.getName());
		Assert.assertEquals("Landmark should match with Near Icici Bank", "Near Icici Bank",
				userDetails.getAddress().getLandmark());

	}

}

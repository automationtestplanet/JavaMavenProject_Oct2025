package com.automationtestplanet;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.UserDetails;

public class JsonUtils {

	public JSONObject readDataFromJson(String jsonFilePath) {
		try {
			JSONParser jParse = new JSONParser();
			JSONObject josnObj = (JSONObject) jParse.parse(new FileReader(new File(jsonFilePath)));
			return josnObj;
		} catch (Exception e) {
			System.out.println("Exception Occured while reading the data from Json: " + e.getMessage());
			return null;
		}
	}

	public JSONObject readDataFromJsonWithObjectMapper(String jsonFilePath) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			JSONObject jsonObject = objMapper.readValue(Paths.get(jsonFilePath).toFile(), JSONObject.class);
			return jsonObject;
		} catch (Exception e) {
			System.out.println("Exception Occured while reading the data from Json: " + e.getMessage());
			return null;
		}
	}
	
	public UserDetails readDataFromJsonAsUserDetails(String jsonFilePath) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			UserDetails userDetails = objMapper.readValue(Paths.get(jsonFilePath).toFile(), UserDetails.class);
			return userDetails;
		} catch (Exception e) {
			System.out.println("Exception Occured while reading the data from Json: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		JsonUtils json = new JsonUtils();
		String jsonFilePath = System.getProperty("user.dir") + "//src//main//resources//UserDetails.json";
		JSONObject jsonData = json.readDataFromJson(jsonFilePath);

		System.out.println(jsonData.toString());
		System.out.println(jsonData.get("name"));
		System.out.println(jsonData.get("address"));
		System.out.println(((Map) jsonData.get("address")).get("pincode"));

		System.out.println("-------------------------------------------------------");
		JSONObject jsonData2 = json.readDataFromJsonWithObjectMapper(jsonFilePath);
		System.out.println(jsonData2.toString());
		System.out.println(jsonData2.get("name"));
		System.out.println(jsonData2.get("address"));
		System.out.println(((Map) jsonData2.get("address")).get("pincode"));
		
		System.out.println("-------------------------------------------------------");
		UserDetails userDetails = json.readDataFromJsonAsUserDetails(jsonFilePath);
		System.out.println(userDetails.getName());
		System.out.println(userDetails.getAddress().getDno());
	}

}

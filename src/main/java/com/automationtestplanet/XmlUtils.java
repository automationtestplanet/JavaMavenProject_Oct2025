package com.automationtestplanet;

import java.nio.file.Paths;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Credentials;


public class XmlUtils {

	public Credentials readDataFromXML(String xmlFilePath) {
		try {
			XmlMapper xmlMap = new XmlMapper();
			Credentials credentials = xmlMap.readValue(Paths.get(xmlFilePath).toFile(), Credentials.class);
			return credentials;
		} catch (Exception e) {
			System.out.println("Exception Occured while reading the data from XML file: " + e.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) {
		XmlUtils xml = new XmlUtils();
		String xmlFilePath = System.getProperty("user.dir") + "//src//main//resources//Credentials.xml";
		 Credentials credentials = xml.readDataFromXML(xmlFilePath);
		 
		 System.out.println(credentials.getUserName());
		 System.out.println(credentials.getPassword());
	}

}

package com.unittests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.automationtestplanet.XmlUtils;

import models.Credentials;

public class XmlUtilsUnitTestCases {
	XmlUtils xml = new XmlUtils();
	
	@Test
	public void readDataFromInvalidXmlFileTest() {
		String xmlFilePath = System.getProperty("user.dir") + "//src//main//resources//InputData.txt";
		 Credentials credentials = xml.readDataFromXML(xmlFilePath);
		 Assert.assertNull(credentials);
	}

	@Test
	public void readDataFromValidXmlFileTest() {
		
		String xmlFilePath = System.getProperty("user.dir") + "//src//main//resources//Credentials.xml";
		 Credentials credentials = xml.readDataFromXML(xmlFilePath);
		 Assert.assertNotNull(credentials);
		 Assert.assertEquals("UserName should match with ABC@123","ABC@123", credentials.getUserName());
	}

}

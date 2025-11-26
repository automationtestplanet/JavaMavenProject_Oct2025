package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest2 extends BaseTestNG {

	@Test(groups = "SmokeTest")
	@Parameters({ "UserName", "Password" })
	public void modDivision(String userName, String password) {
		System.out.println("This is Modular Division");
		System.out.println("UserName: " + userName + "  Password: " + password);
	}

}

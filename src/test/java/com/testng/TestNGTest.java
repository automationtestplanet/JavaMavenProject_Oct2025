package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest extends BaseTestNG {

	@Test(priority = 0, dependsOnMethods = "subtraction", groups = { "SanityTest", "RegressionTest" })
	public void multiplication() {
		System.out.println("This is Multiplication Method");
	}

	@Test(priority = 1, invocationCount = 5, groups = "RegressionTest")
	public void division() {
		System.out.println("This is Division Method");
	}

	@Test(priority = 0, groups = { "SmokeTest", "RegressionTest" })
	@Parameters({ "UserName", "Password" })
	public void subtraction(String userName, String password) {
		System.out.println("This is Subtraction Method");
		System.out.println("UserName: " + userName + "  Password: " + password);
	}

//	@Test(priority=3, enabled = false)
	@Test(priority = 3, groups = { "SanityTest", "RegressionTest" })
	void addition() {
		System.out.println("This is Addition Method");
	}

}

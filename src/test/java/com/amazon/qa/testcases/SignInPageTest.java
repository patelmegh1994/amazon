package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.util.TestUtil;

public class SignInPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	ProductPage productPage;
	SignInPage signInpage;
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil= new TestUtil();
		homePage = new HomePage();
		productPage = new ProductPage();
		signInpage = new SignInPage();
		homePage.signInacc();
		
	}
	
	@Test(priority = 1)
	public void signInPageTitleTest() {
		String pageTitle = signInpage.SignInPageTitle();
		 Assert.assertEquals(pageTitle,"Amazon Sign In", "Title isn't matched");
	}
	
	@Test(priority = 2)
	public void LogoTest() {
		 boolean flag = signInpage.pageLogo();
		 Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void wronEmailTest() {
		String msg = signInpage.wrongEmail();
		Assert.assertEquals(msg, "We cannot find an account with that e-mail address");
	}
	
	@Test(priority = 4)
	public void wrongPassTest() {
		String passMssg = signInpage.wrongPass();
		Assert.assertEquals(passMssg,"Your password is incorrect");
	}
	
	@Test(priority = 5)
	public void correctSignInTest() {
		signInpage.correctsignIn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}

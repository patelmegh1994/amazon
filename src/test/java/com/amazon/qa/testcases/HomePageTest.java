package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	TestUtil testutil;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}

 @BeforeMethod
 public void setUp() {
	 
	 initialization();
	 testutil = new TestUtil();
	 homePage = new HomePage();
	 
 }
 
@Test
 
 public void homePageTitleTest() {
	 
	 String homePageTitle = homePage.homePageTitle();
	 Assert.assertEquals(homePageTitle, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items", "Home Page Title isn't Match");
 }
 
@Test
 public void pageLogoTest() {
	 boolean flag = homePage.pageLogo();
	 Assert.assertTrue(flag);
 }

 @Test
 public void globalLocationTest() {
	 
	 String count = homePage.globalLocation();
	 Assert.assertEquals(count, "Canada");
 }
 
 @Test
 public void searchTest() {
	 homePage.search();
	
	 
 }
 
 @Test
 public void languagesTest() {
	String languages = homePage.languages();
	Assert.assertEquals(languages, "English", "Doesn't match");
 }
 
 @Test
 public void footerListTest() {
	int list = homePage.footerList();
	Assert.assertEquals(list, 1, "The number of footer links are not matched");
 }
 
@Test
 public void headerListTest() {
	 int hList = homePage.headerList();
	 Assert.assertEquals(hList, 28, "The numbers of Header Links are not matched");
 }
 
 @AfterMethod
 public void tearDown() {
	 driver.quit();
 }
 
}


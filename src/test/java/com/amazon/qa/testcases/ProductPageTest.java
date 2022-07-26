package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.util.TestUtil;

public class ProductPageTest extends TestBase {

	TestUtil testUtil;
	HomePage homePage;
	ProductPage productPage;
	
	
	public ProductPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil= new TestUtil();
		homePage = new HomePage();
		productPage = new ProductPage();
		homePage.search();
		
	}
	
	@Test(priority = 1)
	public void pageTitleTest() {
		productPage.pageTitle();
	}
	
	@Test(priority = 2)
	public void proPageLogoTest() {
		boolean flag = productPage.prodLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void prodBrandTest() {
		int brandList = productPage.proBrand();
		Assert.assertEquals(brandList, 12, "The number of brand categories are not mathced");
	}

	@Test(priority = 4)
	public void prodPriceTest() {
		int priceList = productPage.proPrice();
		Assert.assertEquals(priceList, 6, "The number of price list are not same");
	}
	
	@Test(priority = 5)
	public void purchaseProductTest() throws InterruptedException {
		String product =  productPage.productLink();
		Assert.assertEquals(product, "Amazon.ca Shopping Cart");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}

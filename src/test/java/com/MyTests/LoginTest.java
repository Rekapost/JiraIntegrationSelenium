package com.MyTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mypages.HomePage;
import com.mypages.LoginPage;
import com.util.JiraPolicy;

public class LoginTest extends BaseTest{
	
	@JiraPolicy(logTicketReady=true)  // TO create bug
	@Test(priority=1, enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot LoginXX");  // failing to create bug
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=2, enabled=true)
	public void verifyLoginPageHeaderTest(){
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?XXX");
	}
	
	@JiraPolicy(logTicketReady=true)
	@Test(priority=3)
	public void doLoginTest(){
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("dahar0616@gmail.com", "Jira@123");
		String headerHome = homePage.getHomePageHeader();   //"dahar0616@gmail.com", "Jira@123"    //"naveenanimation20@gmail.com", "Test@12345"
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "Getting started with HubSpotXXXXX");
	}
	
	
	
	

}

package com.sapient.qa.testcases;

import com.sapient.qa.base.TestBase;
import com.sapient.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homepage;

    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        homepage = new HomePage();
    }
    @Test(priority = 1,description="Title Test")
    public void validateHomePageTitleTest()  {
        //homepage.login(prop.getProperty("username"),prop.getProperty("password"));

        Assert.assertEquals(homepage.getTitle(),"Tricentis Vehicle Insurance", "Title Test");
    }


    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException {

            driver.quit();
        }






}

package com.sapient.qa.testcases;

import com.aventstack.extentreports.Status;
import com.sapient.qa.base.TestBase;

import com.sapient.qa.pages.HomePage;
import com.sapient.qa.pages.MotorcyclePageObjects;

import com.sapient.qa.reusableComponents.ObjectsRepo;
import com.sapient.qa.util.Constants;
import com.sapient.qa.util.ExcelOperations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.HashMap;

public class MotorcyclePageTest extends TestBase {
    MotorcyclePageObjects motorcyclePageObjects;
    String sheetName;
    ExcelOperations ex;

    public MotorcyclePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        motorcyclePageObjects = new MotorcyclePageObjects();
    }

    @DataProvider(name = "VehicleData")
    public Object[][] getTestData() {
        sheetName = "MotorCycle";
        ex = new ExcelOperations(Constants.TESTDATA_SHEET_PATH, sheetName);
        return ex.getTestData();
    }

    @Test(priority = 1, description="Verify if the save button is enabled",dataProvider = "VehicleData")
    public void motorcycleInsuranceCalculator(Object obj) {
        HashMap<String, String> testData = (HashMap<String, String>) obj;
        motorcyclePageObjects.navigateToMotorcycleTab();
        motorcyclePageObjects.enterVehicleData(testData);
        motorcyclePageObjects.clickOnNextButton();

        //ObjectsRepo.test.log(Status.PASS,"This is to check the logging");
    }






    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}

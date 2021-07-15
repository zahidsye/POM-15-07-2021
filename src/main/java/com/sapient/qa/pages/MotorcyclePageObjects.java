package com.sapient.qa.pages;

import com.sapient.qa.base.TestBase;
import com.sapient.qa.util.ActionEngine;
import com.sapient.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class MotorcyclePageObjects extends TestBase {

    ElementFetch action = new ElementFetch();
    ActionEngine actionEngine = new ActionEngine();
    HomePage homePage = new HomePage();


    @FindBy(id="nav_motorcycle")
    WebElement tab_motorcycle;

    @FindBy(id="make")
    WebElement dd_make;

    @FindBy(id="model")
    WebElement dd_model;

    @FindBy(xpath="//input[@id='cylindercapacity']")
    WebElement txt_cylindercapacity;

    @FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
    WebElement error_cylinderCapacity;

    @FindBy(id="engineperformance")
    WebElement txt_engineperformance;

    @FindBy(id="dateofmanufacture")
    WebElement date_dateofmanufacture;

    @FindBy(id="numberofseatsmotorcycle")
    WebElement dd_numberofseats;

    @FindBy(id="listprice")
    WebElement txt_listprice;

    @FindBy(id="annualmileage")
    WebElement txt_annualmileage;

    @FindBy(id="nextenterinsurantdata")
    WebElement btn_Next;

    public MotorcyclePageObjects() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToMotorcycleTab(){
        action.fluientWaitforElement(tab_motorcycle,10,2);
        action.clickOn(driver,tab_motorcycle,10);

    }

    public void enterVehicleData(HashMap<String, String> testData)  {
        action.fluientWaitforElement(dd_make,10,2);
     /*
        action.selectDropdownOption(driver,dd_make,10,testData.get("Vehicle_Make"));
        action.selectDropdownOption(driver,dd_model,10,testData.get("Vehicle_Model"));
        action.sendKeys(driver,txt_cylindercapacity,10,testData.get("Vehicle_CylinderCapacity"));
        action.sendKeys(driver,txt_engineperformance,10,testData.get("Vehicle_Enging Performance"));
        action.sendKeys(driver,date_dateofmanufacture,10,testData.get("Vehicle_Date of Manufacture"));
        action.selectDropdownOption(driver,dd_numberofseats,10,testData.get("Vehicle_No of Seats_motorcycle"));
        action.sendKeys(driver,txt_listprice,10,testData.get("Vehicle_List Price"));
        action.sendKeys(driver,txt_annualmileage,10,testData.get("Vehicle_Annual Mileage"));

      */


        actionEngine.selectDropDownByValue_custom(dd_make,"Vehicle Make",testData.get("Vehicle_Make"));
        actionEngine.selectDropDownByValue_custom(dd_model,"Vehicle Model",testData.get("Vehicle_Model"));
        actionEngine.sendKeys_custom(txt_cylindercapacity,"Vehicle CylinderCapacity",testData.get("Vehicle_CylinderCapacity"));
        actionEngine.sendKeys_custom(txt_engineperformance,"Vehicle Enging Performance",testData.get("Vehicle_Enging Performance"));
        actionEngine.sendKeys_custom(date_dateofmanufacture,"Vehicle Date of Manufacture",testData.get("Vehicle_Date of Manufacture"));
        actionEngine.selectDropDownByValue_custom(dd_numberofseats,"Vehicle No of Seats_motorcycle",testData.get("Vehicle_No of Seats_motorcycle"));
        actionEngine.sendKeys_custom(txt_listprice,"Vehicle List Price",testData.get("Vehicle_List Price"));
        actionEngine.sendKeys_custom(txt_annualmileage,"Vehicle Annual Mileage",testData.get("Vehicle_Annual Mileage"));
        actionEngine.assertEqualsString_custom("Test Expected Sting","Test Actual String","String Locator Test");
    }

    public void clickOnNextButton() {
        action.clickOn(driver,btn_Next,10);
       // action.hardWait(5000);
    }




}

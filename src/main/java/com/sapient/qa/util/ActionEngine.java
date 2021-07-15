package com.sapient.qa.util;

import com.aventstack.extentreports.Status;
import com.sapient.qa.base.TestBase;
import com.sapient.qa.reusableComponents.ObjectsRepo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ActionEngine extends TestBase {

    //this class has common methods that will log action events in the extent report.

    public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
        try {
            element.sendKeys(valueToBeSent);
            //log success message in exgent report
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Ented value as: "+valueToBeSent);
        } catch (Exception e) {
            //log failure in extent
            ObjectsRepo.test.log(Status.FAIL, "Value enter in field: "+fieldName + " is failed due to exception: "+e);
        }
    }


    //custom click method to log evey click action in to extent report
    public void click_custom(WebElement element, String fieldName) {
        try {
            element.click();
            //log success message in exgent report
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Clicked Successfully! ");
        } catch (Exception e) {
            //log failure in extent
            ObjectsRepo.test.log(Status.FAIL, "Unable to click on field: " +fieldName +" due to exception: "+e);
        }
    }


    //clear data from field
    public void clear_custom(WebElement element,String fieldName) {
        try {
            element.clear();
            Thread.sleep(250);
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Data Cleared Successfully! ");
        } catch (Exception e) {
            ObjectsRepo.test.log(Status.FAIL, "Unable to clear Data on field: " +fieldName +" due to exception: "+e);

        }
    }

    //custom mouseHover
    public void moveToElement_custom(WebElement element,String fieldName){
        try{
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Mouse hovered Successfully! ");
            Thread.sleep(1000);
        }catch(Exception e){
            ObjectsRepo.test.log(Status.FAIL, "Unable to hover mouse on field: " +fieldName +" due to exception: "+e);

        }
    }


    //check if element is Present
    public boolean isElementPresent_custom(WebElement element,String fieldName){
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Presence of field is: "+ flag);
            return flag;
        } catch (Exception e) {
            ObjectsRepo.test.log(Status.FAIL, "Checking for presence of field: " +fieldName +" not tested due to exception: "+e);
            return flag;
        }
    }


    //Select dropdown value value by visibleText
    public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText){
        try {
            Select s = new Select(element);
            s.selectByVisibleText(ddVisibleText);
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Dropdown Value Selected by visible text: "+ ddVisibleText);
        } catch (Exception e) {
            ObjectsRepo.test.log(Status.FAIL, "Dropdown value not selected for field: " +fieldName +"  due to exception: "+e);
        }
    }

    //Select dropdown value value by value
    public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) {
        try {
            Select s = new Select(element);
            s.selectByValue(ddValue);
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Dropdown Value Selected by visible text: "+ ddValue);
        } catch (Exception e) {
            ObjectsRepo.test.log(Status.FAIL, "Dropdown value not selected for field: " +fieldName +"  due to exception: "+e);
        }
    }

    //String Asserts
    public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) {
        try {
            if(actualValue.equals(expvalue)) {
                ObjectsRepo.test.log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
            }else {
                ObjectsRepo.test.log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            Assert.assertTrue(false, e.toString());
        }
    }

    //Get text from webelement
    public String getText_custom(WebElement element, String fieldName) {
        String text = "";
        try {
            text = element.getText();
            ObjectsRepo.test.log(Status.PASS, fieldName+"==> Text retried is: "+ text);
            return text;
        } catch (Exception e) {
            ObjectsRepo.test.log(Status.FAIL, fieldName+"==> Text not retried due to exception: "+ e);

        }
        return text;
    }
}

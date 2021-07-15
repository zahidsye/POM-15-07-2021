package com.sapient.qa.util;

import com.sapient.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class ElementFetch extends TestBase {

    public void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void clickOn(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void moveToElement(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void jsClick(WebElement element, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    //common method to select dd value
    public void selectDropdownOption(WebDriver driver, WebElement element, int timeout, String valueToBeSelected) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        Select os = new Select(element);
        try {
            os.selectByVisibleText(valueToBeSelected);
        } catch(Exception e) {
            System.out.println("Value is not present in dropdown for WebElement: "+element + "Value to be selected is: "+valueToBeSelected);
            e.printStackTrace();
            e.getMessage();
        }
    }

    //get dropdown options as list of string for compare
    public List<String> getDropDownOptionsAsList(WebElement element) {
        Select os = new Select(element);
        List<WebElement> list_webElement_model = os.getOptions();
        List<String> actualContents = new ArrayList<String>();

        for (WebElement ref : list_webElement_model) {
            actualContents.add(ref.getText());
        }
        return actualContents;
    }

    public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
        for (WebElement ref : element) {
            if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
                ref.click();
                break;
            }

        }
    }

    //selecting check boxes
    public void selectCheckBoxes(List<WebElement> element, String checks) {
        String[] checksArray = checks.split(",");
        for (String str : checksArray) {   //speeding, Other
            for (WebElement ele : element) {
                if(ele.getText().equalsIgnoreCase(str)) {
                    ele.click();
                    break;
                }
            }
        }

    }


    public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {

        FluentWait<WebDriver> fWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timoutSec))
                .pollingEvery(Duration.ofSeconds(pollingSec))
                .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

        for (int i = 0; i < 2; i++) {
            try {
                fWait.until(ExpectedConditions.visibilityOf(element));
                fWait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {

                System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();

            }
        }
        return element;

    }

    public void hardWait(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

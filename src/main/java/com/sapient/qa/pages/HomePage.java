package com.sapient.qa.pages;

import com.sapient.qa.base.TestBase;
import com.sapient.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    ElementFetch action = new ElementFetch();

    @FindBy(id = "nav_automobile")
    WebElement link_automobile;

    @FindBy(id = "nav_truck")
    WebElement link_truck;

    @FindBy(id = "nav_camper")
    WebElement link_camper;

    @FindBy(id = "nav_motorcycle")
    WebElement link_motorcycle;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {

        action.fluientWaitforElement(link_automobile, 10, 2);
        return driver.getTitle();

    }


}

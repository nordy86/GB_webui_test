package com.geekbrains.Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://practice.automationtesting.in/my-account/']")
    private WebElement myAccButton;

    public LoginPage clickMyAccButton() {
        myAccButton.click();
        return new LoginPage(driver);
    }

}

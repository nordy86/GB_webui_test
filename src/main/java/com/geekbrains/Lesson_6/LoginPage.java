package com.geekbrains.Lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("radugalocus@gmail.com");
//        loginInput.sendKeys(login);
        return this;
    }
    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password) {
        driver.findElement(By.id("password")).sendKeys("098123Qq_!$");
//        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажатие но кнопку логина")
    public MainPage loginButtonClick() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.name("login")))
                .click()
                .build()
                .perform();
//        loginButton.click();
        Thread.sleep(5000);
        return new MainPage(driver);
    }

}


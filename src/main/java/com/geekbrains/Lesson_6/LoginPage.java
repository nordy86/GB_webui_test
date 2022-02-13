package com.geekbrains.Lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;


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

    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage loginButtonClick() throws InterruptedException {
        loginButton.click();
        Thread.sleep(5000);
        return new MainPage(driver);
    }

    public LoginPage checkLogin() {
        assertThat(driver.findElement
                (By.xpath("//div[@class='woocommerce-MyAccount-content']")), hasText("Hello radugalocus (not radugalocus? Sign out)\nFrom your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details."));
        return this;
    }

}

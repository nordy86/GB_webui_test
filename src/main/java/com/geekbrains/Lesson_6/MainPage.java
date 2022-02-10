package com.geekbrains.Lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://practice.automationtesting.in/my-account/']")
    private WebElement myAccButton;

    @Step("Нажатие на кнопку перехода на страницу аккаунта")
    public LoginPage clickMyAccButton() {
        driver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/my-account/']")).click();
        return new LoginPage(driver);
    }

    @Step("Проверка успешной авторизации")
    public MainPage checkLogin() {
        assertThat(driver.findElement
                (By.xpath("//div[@class='woocommerce-MyAccount-content']")), hasText("Hello radugalocus (not radugalocus? Sign out)\nFrom your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details."));
        return this;
    }
}

package lesson6;

import com.geekbrains.Lesson_6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Story("Проверка авторизации")
public class PageObjectSiteHw6AndHw7Test {
    WebDriver driver;
    private final static String TheSite_URL = "http://practice.automationtesting.in/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.get(TheSite_URL);
    }

    @Test
    @Description("Проверка авторизации ранее зарегистрированного пользователя")
    void theSiteAuthTest() throws InterruptedException {
//        new LoginPage(driver).loginInput.sendKeys("radugalocus@gmail.com");
//        new LoginPage(driver).passwordInput.sendKeys("098123Qq_!$");
        new MainPage(driver)
                .clickMyAccButton()
                .fillLogin("radugalocus@gmail.com")
                .fillPassword("098123Qq_!$")
                .loginButtonClick()
                .checkLogin();


    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}

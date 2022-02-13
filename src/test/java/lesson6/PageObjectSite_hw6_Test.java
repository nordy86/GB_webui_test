package lesson6;

import com.geekbrains.Lesson_6.LoginPage;
import com.geekbrains.Lesson_6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PageObjectSite_hw6_Test {
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
    void theSiteAuthTest() throws InterruptedException {
//        new LoginPage(driver).loginInput.sendKeys("radugalocus@gmail.com");
//        new LoginPage(driver).passwordInput.sendKeys("098123Qq_!$");
        new MainPage(driver)
                .clickMyAccButton()
                .fillLogin("radugalocus@gmail.com")
                .fillPassword("098123Qq_!$")
                .loginButtonClick();


    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}

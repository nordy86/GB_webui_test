package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import static org.hamcrest.MatcherAssert.assertThat;

public class justAsiteTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String TheSite_URL = "http://practice.automationtesting.in/";

    @BeforeAll
    static  void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(TheSite_URL);
    }
    @Test
    public void SuccessfulAuthorisation() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/my-account/']")))
                .click()
                .build()
                .perform();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("radugalocus@gmail.com");
        driver.findElement(By.id("password")).sendKeys("098123Qq_!$");
        actions.moveToElement(driver.findElement(By.name("login")))
                .click()
                .build()
                .perform();
        assertThat(driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")), hasText )
                ( ,driver.findElement(By.xpath("//*[contains(text(),'radugalocus')]")));
        Thread.sleep(5000);



    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;



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
    public void SuccessfulAuthorisation() {
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
        assertThat(driver.findElement
                (By.xpath("//div[@class='woocommerce-MyAccount-content']")), hasText("Hello radugalocus (not radugalocus? Sign out)\nFrom your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details."));
    }

    @Test
    public void moveFromAccountToBasket() {
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
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='wpmenucart-icon-shopping-cart-0']")))
                .click()
                .build()
                .perform();
        Assertions.assertTrue(driver.getCurrentUrl().contains("basket"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

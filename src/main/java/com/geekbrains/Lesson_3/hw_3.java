package com.geekbrains.Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hw_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.automationtesting.in/");
//        WebElement myAccButton = driver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/my-account/']"));
//        myAccButton.click();
        driver.findElement(By.xpath("//a[@href='http://practice.automationtesting.in/my-account/']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("radugalocus@gmail.com");
        driver.findElement(By.id("password")).sendKeys("098123Qq_!$");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//li[@id='menu-item-40']//a[@href='http://practice.automationtesting.in/shop/']")).click();
        driver.findElement(By.xpath("//a[@href='/shop/?add-to-cart=169']")).click();
        driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();
        driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}

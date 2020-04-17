package com.lolivares.Test;

import com.lolivares.Page.AmazonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
    private WebDriver driver;
    AmazonPage amazon;

    @BeforeTest
    public void conectionBrowser(){
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        amazon = new AmazonPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void doBuyTest() throws InterruptedException {
        amazon.doBuy();
        Assert.assertEquals(amazon.message(),"Do buy.");
    }

    @AfterTest
    public void close(){
       // driver.quit();
    }
}

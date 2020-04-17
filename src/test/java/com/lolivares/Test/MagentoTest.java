package com.lolivares.Test;

import com.lolivares.Page.MagentoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoTest {
    private WebDriver driver;
     MagentoPage mage;

    @BeforeTest
    public void connection(){
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver= new FirefoxDriver();
        mage= new MagentoPage(driver);
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");
    }

    @Test(priority=1, description = "Buy TV")
    public void testTV(){
        mage.buyTV();
        Assert.assertEquals(mage.value(), "$19,680.00");
    }

    @Test(priority=2, description = "Buy Mobile")
    public void testMbl() throws InterruptedException {
        mage.buyMobile();
        Assert.assertEquals(mage.valuembl(), "$100.00");
    }

    @AfterTest
    public void quit(){
        //driver.quit();
    }

}

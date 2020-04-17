package com.lolivares.Test;

import com.lolivares.Page.TravelsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@Listeners(com.titanium.pdfemail.JyperionListener.class)
public class TravelsTest {
    private WebDriver driver;
    private TravelsPage travel;

    @BeforeTest
    public void conection(){
        driver = new FirefoxDriver();
        travel = new TravelsPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.espanol.skyscanner.com/");
    }

    @Test
    public void test() throws InterruptedException {
        travel.searchFlight();
        Assert.assertTrue(travel.result());
    }
}

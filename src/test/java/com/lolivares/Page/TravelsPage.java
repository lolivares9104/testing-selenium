package com.lolivares.Page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class TravelsPage {
    static WebDriver driver;
    By from = By.xpath("//*[@id=\"fsc-origin-search\"]");
    By opt_from = By.id("react-autowhatever-fsc-origin-search--item-0");
    By to = By.xpath("//*[@id=\"fsc-destination-search\"]");
    By opt_to = By.id("react-autowhatever-fsc-destination-search--item-8");
    By depart = By.id("depart-fsc-datepicker-button");
    By select_depart = By.xpath("//*[@id=\"depart-fsc-datepicker-popover\"]/div/div/div[2]/div/table/tbody/tr[2]/td[1]");
    By come_back = By.id("return-fsc-datepicker-button");
    By select_comeback = By.xpath("//*[@id=\"return-fsc-datepicker-popover\"]/div/div/div[2]/div/table/tbody/tr[2]/td[6]");
    By cant_travels = By.id("CabinClassTravellersSelector_fsc-class-travellers-trigger__1qSiF");
    By btn_adults= By.xpath("//*[@id=\"cabin-class-travellers-popover\"]/div/div/div[1]/div/button[2]");
    By btn_children = By.xpath("//*[@id=\"cabin-class-travellers-popover\"]/div/div/div[2]/div/button[2]");
    By btn_search = By.xpath("//*[@id=\"flights-search-controls-root\"]/div/div/form/div[3]/button");
    By btn_ready = By.xpath("//*[@id=\"cabin-class-travellers-popover\"]/footer/button");
    By age_children = By.id("children-age-dropdown-0");
    By result = By.xpath("//*[@id=\"app-root\"]/div/div[2]/div[2]/div[1]/section/div");


    public TravelsPage(WebDriver driver){
        this.driver=driver;
    }

    public void searchFlight() throws InterruptedException {
        /*driver.findElement(from).sendKeys("Montevideo");
        Thread.sleep(2000);
        driver.findElement(opt_from).click();
        Thread.sleep(2000);*/
        driver.findElement(to).sendKeys("Cuba");
        Thread.sleep(2000);
        driver.findElement(opt_to).click();
        Thread.sleep(2000);
        driver.findElement(depart).click();
        Thread.sleep(2000);
        driver.findElement(select_depart).click();
        Thread.sleep(2000);
        driver.findElement(come_back).click();
        Thread.sleep(2000);
        driver.findElement(select_comeback).click();
        Thread.sleep(2000);
        driver.findElement(cant_travels).click();
        driver.findElement(btn_adults).click();
        Thread.sleep(2000);
        driver.findElement(btn_children).click();
        Thread.sleep(2000);
        selectAgeChildren();
        Thread.sleep(2000);
        driver.findElement(btn_ready).click();
        Thread.sleep(2000);
        driver.findElement(btn_search).click();

    }

    public static WebDriver getDriver(){
        if(driver ==null){
            System.setProperty("webdriver.gecko.driver","geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public String selectAgeChildren(){
        Select select = new Select(driver.findElement(age_children));
        select.selectByVisibleText("12");
        return select.getFirstSelectedOption().getText();
    }

    public boolean result(){
        if(driver.findElement(result).isDisplayed()){
            return false;
        }
        return true;
    }

    public static void takeScreenshot(WebDriver driver, String fileWithPath) throws IOException {
        TakesScreenshot schshot= (TakesScreenshot)driver;
        File srcFile=schshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File(fileWithPath);
        FileUtils.copyFile(srcFile,destFile);
    }





}

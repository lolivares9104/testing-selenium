package com.lolivares.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MagentoPage {
    private WebDriver driver;

    //Buy TV
    //By link = By.xpath("//*[@id=\"nav\"]/ol/li[2]/a");
    By link = By.linkText("TV");
    By addcartbtn = By.cssSelector(".products-grid > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");
    By confirm= By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/span/span");
    By select_country= By.xpath("//*[@id=\"country\"]");
    By state = By.cssSelector("#region");
    By editQTY= By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input");
    By update_btn = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span");

    //Buy Mobile
    By linkmbl = By.xpath("//*[@id=\"nav\"]/ol/li[1]/a");
    By sort = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select");
    By addcartbtnmbl=By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button");
    By confirmmbl = By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr[2]/td[5]/span/span");




    public MagentoPage(WebDriver driver){
        this.driver=driver;
    }


    //TV
    public void buyTV(){
        driver.findElement(link).click();
        driver.findElement(addcartbtn).click();
        driver.findElement(editQTY).clear();
        driver.findElement(editQTY).sendKeys("32");
        driver.findElement(update_btn).click();
    }

    public String selectCountry(){
        Select select = new Select(driver.findElement(select_country));
        select.selectByVisibleText("Uruguay");
        return select.getFirstSelectedOption().getText();
    }

    public String value(){
        if(driver.findElement(confirm).isDisplayed()){
            return driver.findElement(confirm).getText();
        }
        else
            return "No coincide";
    }

    //Mobile
    public void buyMobile(){
        driver.findElement(linkmbl).click();
        driver.findElement(addcartbtnmbl).click();
        selectCountry();
        driver.findElement(state).sendKeys("Montevideo");

    }

    public String sortMobile(){
        Select select = new Select(driver.findElement(sort));
        select.selectByVisibleText("Name");
        return select.getFirstSelectedOption().getText();
    }

    public String valuembl(){
        if (driver.findElement(confirmmbl).isDisplayed()){
            return driver.findElement(confirmmbl).getText();
        }
        else
            return "No se encontro";
    }



}

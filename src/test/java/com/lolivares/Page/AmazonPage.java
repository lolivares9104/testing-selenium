package com.lolivares.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonPage {
        private WebDriver driver;
        By linkToday = By.xpath("//*[@id=\"nav-xshop\"]/a[1]");
        By checkBaby = By.xpath("//*[@id=\"widgetFilters\"]/div[1]/div[2]/span[3]/div/label/span");
        By linkClick = By.xpath("//*[@id=\"dealTitle\"]/span");
        By text = By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[1]/b");
        By buy = By.xpath("//*[@id=\"usedAccordionRow\"]/div/div[1]/a/h5/div/div[1]");
        By carBuy = By.id("add-to-cart-button-ubb");
        By postBuy = By.id("huc-v2-order-row-inner");

        public AmazonPage(WebDriver driver){
            this.driver=driver;
        }

        public void doBuy() throws InterruptedException {
            driver.findElement(linkToday).click();
            Thread.sleep(2000);
            driver.findElement(checkBaby).click();
            Thread.sleep(3000);
            clickProduct();
            Thread.sleep(2000);
            driver.findElement(buy).click();
            driver.findElement(carBuy).click();

        }

        public void clickProduct(){
            List<WebElement> product = driver.findElements(linkClick);
            product.get(1).click();
        }
        public String message(){
            if(driver.findElement(text).isDisplayed()){
                return "Do buy.";
            }
            else
                return "Don't buy.";
        }
        public boolean imgTrue(){
            if(driver.findElement(postBuy).isDisplayed()){
                return true;
            }
            return false;
        }

    }



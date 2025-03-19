package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Actions {
   private WebDriver driver;
    Actions(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    //goto specific page
    public void goto_page(String url)
    {
        driver.get(url);
    }

    public void quit()
    {
        driver.quit();
    }
    public boolean checkpage( String uniquelocator[])
    {
        //search abiut the web element if it is present  send true and if it throws any exception send false
        try {
            driver.findElement(By.cssSelector(uniquelocator[0]));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

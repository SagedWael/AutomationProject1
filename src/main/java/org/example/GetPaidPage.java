package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class GetPaidPage {
    private WebDriver driver;
    private String GetPaidPage_url="https://app.levelset.com/wizard/SelectDocument";
    String free_documents_locator_xpath="//span[@class='price-amount' and text()='Free']";
    String documents_price30to60_locator_xpath="//span[contains(@class,'price-amount') and number(substring(text(),2))>30 and number(substring(text(),2))<60]";
    String documents_price30to60_name_locator_xpath="//span[contains(@class,'price-amount') and number(substring(text(),2))>30 and number(substring(text(),2))<60]/../../div";
    String unique_locator_cssselector[]={".js-request-document","Request a Document"};
    Actions action;


    public GetPaidPage(WebDriver driver) {
        this.driver = driver;
        this.action=new Actions(driver);
    }

    public void visit_GetPaidPage() {
        action.goto_page(GetPaidPage_url);
       boolean state= action.checkpage(unique_locator_cssselector);
       if (!state)
       {
           quit();
           action.goto_page(GetPaidPage_url);
       }
    }

    public int get_no_free_documents()
    {
        List<WebElement> element =  driver.findElements(By.xpath(free_documents_locator_xpath));
        return element.size();
    }

    public List<String> get_free_documents_text()
    {
        List<String> free_documents_text = new java.util.ArrayList<String>();
        List<WebElement> element =  driver.findElements(By.xpath(free_documents_locator_xpath));
        for (int i = 0; i < element.size(); i++) {
            free_documents_text.add(i,element.get(i).getText());
        }
       return free_documents_text;
    }
    public void quit()
    {
        action.quit();
    }
    public int documentPriceFilter_30To60()
    {
        List<WebElement> element =  driver.findElements(By.xpath(documents_price30to60_locator_xpath));
        return element.size();
    }
    public String get_documents_price30to60_text()
    {
        return driver.findElement(By.xpath(documents_price30to60_name_locator_xpath)).getText();

    }


}

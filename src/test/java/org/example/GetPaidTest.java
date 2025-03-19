package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetPaidTest {
    GetPaidPage getpaidpage;
    @BeforeClass
    public void setup()
    {
        WebDriver driver=new ChromeDriver();
         getpaidpage = new GetPaidPage(driver);
        getpaidpage.visit_GetPaidPage();
    }
    @AfterClass
    public void teardown()
    {
        getpaidpage.quit();
    }
    @Test
    public void TC1_Validate_Free_Documents_Number()
    {
        Assert.assertEquals(getpaidpage.get_no_free_documents(), 2);
    }
    @Test(dependsOnMethods = "TC1_Validate_Free_Documents_Number")
    public void TC1_1_Validate_Free_Documents_Text()
    {
        Assert.assertEquals(getpaidpage.get_free_documents_text().get(0), "Free");
        Assert.assertEquals(getpaidpage.get_free_documents_text().get(1), "Free");
    }
    @Test
    public void TC2_Validate_Document_Price_Filter_30to60()
    {
        Assert.assertEquals(getpaidpage.documentPriceFilter_30To60(), 1);
    }
    @Test(dependsOnMethods = "TC2_Validate_Document_Price_Filter_30to60")
    public void TC2_2_Validate_Document_Price_Filter_60to90_Text()
    {
        Assert.assertEquals(getpaidpage.get_documents_price30to60_text(), "Send a Warning");
    }



}

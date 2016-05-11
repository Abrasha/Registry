package edu.kpi;

import junit.framework.TestCase;
import junit.framework.Assert;
import junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SimpleTest{

    @Test
    public void setUp() throws Exception {
       WebDriver driver = new  FirefoxDriver();
        driver.navigate().to("http://seleniumsimplified.com");
        Assert.assertTrue("title should start differently",
                            driver.getTitle().StartsWith("Selenium Simplified"));
        driver.close();
    }


}


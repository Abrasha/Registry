package edu.kpi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import junit.Test;

public class SeleniumTest{
    @Test
    public void setUp() throws Exception {
        WebDriver driver = new  FirefoxDriver();
        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());

    }


}


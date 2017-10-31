package com.codingmechanic.webapp.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSWebAutomationTest {
    // Instance of Appium Driver
    AppiumDriver<WebElement> driver;

    @BeforeClass
    public void setUp () {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        caps.setCapability(CapabilityType.BROWSER_NAME, "safari");

        try {
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleTest() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("masihur's blog");
        driver.findElement(By.name("btnG")).click();
        System.out.println("TITLE: " + driver.getTitle());
    }
}

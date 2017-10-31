package com.codingmechanic.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAppiumTest {
    // Instance of Appium Driver
    AppiumDriver<WebElement> driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.masihur.calculatorapp");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.masihur.calculatorapp.MainActivity");
        caps.setCapability("avd", "Test");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleTest() {
        WebElement slot1 = driver.findElement(By.id("edtno1"));
        WebElement slot2 = driver.findElement(By.id("edtno2"));
        slot1.clear();
        slot1.sendKeys("20");
        slot2.clear();
        slot2.sendKeys("20");
        WebElement radioAdd = driver.findElement(By.id("rdAdd"));
        radioAdd.click();

        WebElement result = driver.findElement(By.id("txtResult"));
        Assert.assertEquals(result.getText(), "40");
    }
}

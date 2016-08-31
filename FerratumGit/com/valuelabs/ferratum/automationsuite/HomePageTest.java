package com.valuelabs.ferratum.automationsuite;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
  MethodListener.class })
public class HomePageTest {

		static
       //Set Property for ATU Reporter Configuration
       {
			System.out.println(System.getProperty("user.dir"));
         System.setProperty("atu.reporter.config", System.getProperty("user.dir") + "/atu.properties");

       }


       public WebDriver driver;

       @BeforeTest
       public void init() {
    	   System.out.println("chrome");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
              driver = new HtmlUnitDriver();
              System.out.println("Driver Initilalized................!");
              ATUReports.setWebDriver(driver);
              setIndexPageDescription();
       }



       private void setIndexPageDescription() {
              ATUReports.indexPageDescription = "Ferratum Demo <br/> <b>Demo Results</b>";
       }

            //Deprecated Methods

       //New Way of Logging

       @Test
       public void testNewLogs() throws AWTException, IOException {
    	   System.out.println("Inside test");
    	   driver.get("https://www.ebay.in");
              try {
				ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(
				               ScreenshotOf.BROWSER_PAGE));
				  ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				               ScreenshotOf.DESKTOP));
				  WebElement element = driver
				               .findElement(By.xpath("/html/body/div/h1/a"));
				  ATUReports.add("Warning Step", LogAs.WARNING,
				               new CaptureScreen(element));
				  ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
				               ScreenshotOf.DESKTOP));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				  ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
			               ScreenshotOf.BROWSER_PAGE));
			}
       }

}

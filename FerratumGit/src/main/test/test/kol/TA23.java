package test.kol;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TA23 {

	WebDriver driver;
	@BeforeTest
								
	public void beforeTest(){
		
		driver=new FirefoxDriver();
	}										
	
	@Test
											
	public void test(){
		
		driver.get("https://www.google.com");
	}
	
																		
}

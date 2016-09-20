
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TA23test {
	WebDriver driver;

	@Test
	public void verifySearch() {
		System.out.println("Inside verifySearch");
		driver = new FirefoxDriver();
		driver.get("http://only-testing-blog.blogspot.in/");
		driver.quit();
	}
}
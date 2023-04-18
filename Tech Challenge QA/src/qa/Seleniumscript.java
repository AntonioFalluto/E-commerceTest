package qa;

import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Seleniumscript {

	public static void main(String[] args) throws Exception {

	
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.manage().window();

	driver.manage().deleteAllCookies();
	driver.manage().timeouts().getImplicitWaitTimeout();

	// Precondition
	driver.get("https://www.saucedemo.com/");
	
	//LOGIN Standard User --> user lands on Home Page
    WebElement username = driver.findElement(By.id("user-name"));
    username.sendKeys("standard_user");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    
    // Verify Web Elements in HP
    String titolo = "Products1";       
    String t = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText() ;
    if ( titolo.equals(t))  { 	
    	System.out.println("\n***** Title in HP = "+t);
    }  
    else { throw new Exception("Wrong Title in HP"); }
	
	
	System.out.println(driver.getTitle());
	driver.quit();	


	}

}

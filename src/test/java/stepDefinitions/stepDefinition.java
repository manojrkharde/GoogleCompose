package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {

	String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
	 
    WebDriver driver;
       
    @Before
    public void setup() {
 
        //Initialize the webdriver and open the browser
    	System.setProperty("webdriver.chrome.driver", driverPath);
    	
    	//Driver will not give the logs about launch state
    	System.setProperty("webdriver.chrome.silentOutput", "true");
    	  
    	driver = new ChromeDriver();   	  
    	driver.manage().window().maximize();
    }
    
	
	@Given("User is on Gmail page")
	public void user_is_on_gmail_page() {
	    //navigate to GMail
		driver.navigate().to("https://mail.google.com/");
	}
	
	@When("User logs in using username {string}")
	public void user_logs_in_using_username(String string) {
	   	//enter email id as "mrkautomation25@gmail.com"
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mrkautomation25@gmail.com");
		
		//click on "Next" button
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qfvgSe qIypjc TrZEUc lw1w4b']")).click();
	}
	
	@When("password as {string}")
	public void password_as(String string) {
	    
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
		ele.sendKeys("Tester@12345"); */
		
		//enter password as "Tester@12345"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement elePassword=driver.findElement(By.xpath("//input[@name='password']"));
		elePassword.sendKeys("Tester@12345");
		  
		elePassword.sendKeys(Keys.TAB); 
		elePassword.sendKeys(Keys.TAB); 
		   
		//click on Next button 
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); 
	}

	
	@When("User sends an email to {string} with body {string} and subject {string}")
	public void user_sends_an_email_to_with_body_and_subject(String string, String string2, String string3) {
	    //click on Compose button
	    driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	    
	    //enter To as "mrkautomation25@gmail.com"
	    driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("mrkautomation25@gmail.com");
	    
	    //enter subject as "Incubyte"
	    driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Incubyte");
	    
	    //enter body as "Automation QA test for Incubyte"
	    driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Automation QA test for Incubyte");
	    
	    //click on the send button
	    driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
	}
	
	@After
    public void close() {
 
        //close the browser
        driver.close();
    } 
}

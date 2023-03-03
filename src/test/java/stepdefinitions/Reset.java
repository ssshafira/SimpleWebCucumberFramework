package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Reset {

	public static WebDriver driver;
	
    @Given("I open browser Chrome")
    public void iOpenBrowserChrome() {     
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
    
    @When("I navigate to url {string}")
    public void iNavigateToUrl(String url) {
    	driver.manage().window().maximize();
    	driver.get(url);
    }
    
    @And("I delay 3 Second")
    public void iDelay3Second() throws InterruptedException {
    	Thread.sleep(3000);
    }
    
    @And("I set text {string} in UserID Text Box")
    public void iSetTextInUserIDTextBox(String username) {
    	driver.findElement(By.name("uid")).sendKeys(username);
    }
    
    @And("I set text {string} in Password Text Box")
    public void iSetTextInPassword(String password) {
    	driver.findElement(By.name("password")).sendKeys(password);
    }
    
    @And("I click Reset button")
    public void iClickResetButton() {
    	driver.findElement(By.name("btnReset")).click();
    }
    
    @Then("UserID Text Box is empty")
    public void userIDTextBoxIsEmpty() {
    	String userId = driver.findElement(By.name("uid")).getText();
    	Assert.assertEquals(userId, ""); 
    }      
    
    @And("Password Text Box is empty")
    public void passwordTextBoxIsEmpty() {
    	String password = driver.findElement(By.name("password")).getText();
    	Assert.assertEquals(password, ""); 
    }      
    
    @And("I close browser")
    public void i_close_browsers() {
        driver.quit();  
    }      
    
}

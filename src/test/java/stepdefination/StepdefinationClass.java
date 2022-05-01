package stepdefination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.HooksClass;
import junit.framework.Assert;

public class StepdefinationClass {
		public static WebDriver driver;
@Given("User navigate to the login page")
public void user_navigate_to_the_login_page() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\003E5F744\\Downloads\\chromedriver.exe");
	driver= new ChromeDriver();	
	driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
	driver.manage().window().maximize();
}

@When("User submit username and password")
public void user_submit_username_and_password() {
	driver.findElement(By.id("input-username")).sendKeys("admin");
	driver.findElement(By.id("input-password")).sendKeys("Admin@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}

@Then("User should be logged in")
public void user_should_be_logged_in() throws InterruptedException {
	Assert.assertEquals("Dashboard", driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText());
	Thread.sleep(2000);
}

@Given("User navigates to the coupon page")
public void user_navigates_to_the_coupon_page() {

	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-share-alt fw'])")));
	a.build().perform();
	WebElement c=driver.findElement(By.xpath("(//a[text()='Coupons'])[1]"));
	c.click();
}

@When("User creates a coupon")
public void user_creates_a_coupon() {
	driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();

	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Coupen name");
	driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Code12");
	WebElement c=driver.findElement(By.xpath("//button[@data-original-title='Save']"));
	c.click();
}

@Then("User verify that the coupon is created")
public void user_verify_that_the_coupon_is_created() {
	String Coupenxpath="//td[text()='Coupen name']";
    Assert.assertTrue(driver.findElement(By.xpath(Coupenxpath)).isDisplayed());   
    driver.quit();
}

@When("User updating the coupon details")
public void user_updating_the_coupon_details() {
	driver.findElement(By.xpath("(//a[@data-original-title='Edit'])[1]")).click();
	driver.findElement(By.id("input-name")).clear();
	driver.findElement(By.id("input-code")).clear();
	driver.findElement(By.id("input-name")).sendKeys("Coupen name1");
	driver.findElement(By.id("input-code")).sendKeys("see");
	driver.findElement(By.xpath("//button[@data-original-title='Save']")).click();
}

@Then("User verify that the coupon is updated")
public void user_verify_that_the_coupon_is_updated() {
	String  Coupenxpath="//td[text()='Coupen name1']";
	Assert.assertTrue(driver.findElement(By.xpath(Coupenxpath)).isDisplayed());
	driver.quit();
}

@When("User deleting the coupon details")
public void user_deleting_the_coupon_details() {
	driver.findElement(By.xpath("(//input[@name='selected[]'])[1]")).click();
	driver.findElement(By.xpath("//button[@type='button']")).click();	
    driver.switchTo().alert().accept();;
	
}

@Then("User verify that the coupon is deleted")
public void user_verify_that_the_coupon_is_deleted() {
	String CoupenXpath="//div[contains(text(),'Success: ')]";
	Assert.assertTrue(driver.findElement(By.xpath(CoupenXpath)).isDisplayed());
	driver.quit();
}
}

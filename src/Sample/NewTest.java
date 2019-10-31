package Sample;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public static WebDriver driver;
	
	public static Logger LOG=Logger.getLogger("NewTest");
  @Test
  public void NewTest() {
	  
	  PropertyConfigurator.configure("C:\\Users\\lenin.a\\workspace\\IDIQ\\Log4j.properties");
	  
	  //WebElement PASS=driver.findElement(By.xpath("//*[@name='password_protected_pwd']"));
	  //PASS.sendKeys("IdentityIQ1");
	  //WebElement BUTT=driver.findElement(By.xpath("//*[@name='wp-submit']"));
	  //BUTT.click();
	  //WebElement terms=driver.findElement(By.xpath("//*[@id='menu-item-837']"));
	  //terms.click();
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  WebElement USER= driver.findElement(By.xpath("//input[@maxlength='50' and @class='login-input' and @readonly='readonly']"));   
	  Actions User = new Actions(driver);
      User.moveToElement(USER).click().sendKeys("matthewplanz@gmail.com").perform();
      
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  WebElement Password=driver.findElement(By.xpath("//input[@class='login-input' and @readonly='readonly']//following::input[2]"));
	  Actions Pass = new Actions(driver);
      Pass.moveToElement(Password).click().sendKeys("Harshi2010").perform();
	  
	  WebElement Button=driver.findElement(By.xpath("//input[@class='login-btn']"));
	  Button.click();
	  
	  WebElement SSN=driver.findElement(By.xpath("//input[@name='FBfbforcechangesecurityanswer$txtSecurityAnswer']"));
	  SSN.sendKeys("0013");
	
	  WebElement Submit=driver.findElement(By.xpath("//input[@name='FBfbforcechangesecurityanswer$ibtSubmit']"));
	  Submit.click();
	  
	  //LOG.info("Member Login successfully");
	  //Reporter.log("Member Login successfully");
	  
	  WebElement MenuBT=driver.findElement(By.xpath("//*[@href='javascript:void(0);']"));
	  MenuBT.click();
		
		
	  String MemberName="//*[@id='leftpanel_lblUsername']";
      String Actual=MemberName;
	  String Member=driver.findElement(By.xpath(Actual)).getText();
	  System.out.println(Member);   
      Reporter.log("User Name--->"+Member);
	  
	  
	  
	  
	    String MemberNo="//*[@id='leftpanel_lblAccountID']";
		String Actual1=MemberNo;
		String Membershipno=driver.findElement(By.xpath(Actual1)).getText();
		System.out.println(Membershipno);
		
		//LOG.info("Member Login successfully--->"+Membershipno);
		Reporter.log("Membership Number--->"+Membershipno);
		
		
		//String Actual=driver.getCurrentUrl();
		//String expected="http://tst.identityiq.com/Dashboard.aspx";
	  
	  //WebElement ContinueTo=driver.findElement(By.xpath("//*[@id='lbtContinueToDashboard']"));
	  //ContinueTo.click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\lenin.a\\Downloads\\JAR FILES\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tst.identityiq.com/login.aspx");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  Sendmail.email();
  }

}

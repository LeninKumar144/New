package Sample;

 import org.openqa.selenium.*;
 import org.openqa.selenium.remote.DesiredCapabilities;
 import java.net.MalformedURLException;
 import java.net.URL;
 import org.openqa.selenium.remote.RemoteWebDriver;
 import org.testng.annotations.*;

 public class Grid_2 {

     WebDriver driver;
     String baseURL, nodeURL;

     @BeforeTest
     public void setUp() throws MalformedURLException {
         baseURL = "http://tst.identityiq.com";
         nodeURL = "http://192.168.1.224:4446/wd/hub";
         
          /*
          DesiredCapabilities capability = DesiredCapabilities.firefox();
         capability.setBrowserName("firefox");
         capability.setPlatform(Platform.WIN10);
           */
        
         DesiredCapabilities caps = new DesiredCapabilities().firefox();
         caps.setCapability("os", "Windows");
         caps.setCapability("os_version", "10");
         caps.setCapability("browser", "Firefox");
         caps.setCapability("browser_version", "70.0 beta");
         caps.setCapability("project", "test URL");
         caps.setCapability("build", "4.6");
         caps.setCapability("browserstack.selenium_version", "3.141.59");
         caps.setCapability("browserstack.firefox.driver", "0.23.0");
       

         
         driver = new RemoteWebDriver(new URL(nodeURL), caps);
     }

     @AfterTest
     public void afterTest() {
         driver.quit();
     }
     @Test
     public void sampleTest() {
         driver.get(baseURL);
         System.out.println(baseURL);
        
     }

 }
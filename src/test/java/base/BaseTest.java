package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    @Parameters({"URL","browser"})
    public void setUp(String URL, String browser){
  
        if (browser.equalsIgnoreCase("chrome")){
            //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        	WebDriverManager.chromedriver().setup(); // automatically downloads & sets path
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            //System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            WebDriverManager.chromedriver().setup(); // automatically downloads & sets path
            driver = new FirefoxDriver();
        }
        else {
            throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

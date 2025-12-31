package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    
    //The class follows the page object model design pattern
   
    private WebDriver driver;
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[text()=' Login ']");

    private By loginErrorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    private By forgotPasswordLink = By.linkText("Forgot your password?");
    private By loginPanelHeader = By.id("logInPanelHeading");

    
    //Calls the constructor and passes WebDriver
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    
    //Making the locators private and providing public methods to interact with them is the right method 
    //If the xpath changes later you only update it in one place - inside the page object class 
    
    public void setUsername(String userName){
    	
        // driver.findElement(usernameInput).sendKeys(userName);
        // Create a WebDriverWait (dynamic wait) for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the username input is visible and enabled
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(usernameInput) );

        usernameElement.sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public DashBoardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashBoardPage(driver);
    }

    public String getLoginErrorWarning() throws InterruptedException{
    	Thread.sleep(3000);
        return driver.findElement(loginErrorMessage).getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public ForgotPasswordPage clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }

    public String getLoginPanelHeading(){
        return driver.findElement(loginPanelHeader).getText();
    }




}

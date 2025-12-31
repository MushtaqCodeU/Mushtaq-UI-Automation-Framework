package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestDataProvider.TestData;
import base.BaseTest;
import constant.LoginMessages;
import pages.DashBoardPage;


public class LoginTests extends BaseTest implements LoginMessages {
	
	@Test(dataProvider = "loginVaildData", dataProviderClass = TestData.class)
    public void testLoginInsertCorrectUsernameAndPassword(String username, String password)throws InterruptedException {
		homePage.setUsername(username);
        homePage.setPassword(password);
        DashBoardPage dashboard = homePage.clickLoginButton(); //The object created inside clickLoginButton() is returned and assigned to the variable dashboard of DashboadPage.
        Assert.assertTrue(dashboard.getWelcomeUser().contains(LoginMessages.WELCOMEUSER),"User Not found");     
    }
       
    @Test(dataProvider = "loginInvalidData", dataProviderClass = TestData.class)
    public void testLoginInsertInvalidUsernameAndPassword(String username, String password) throws InterruptedException{
		homePage.setUsername(username);
        homePage.setPassword(password);
        homePage.clickLoginButton();
        Assert.assertEquals(homePage.getLoginErrorWarning(), LoginMessages.INVALIDCREDMSG, "Wrong login error warning.");
    }

}

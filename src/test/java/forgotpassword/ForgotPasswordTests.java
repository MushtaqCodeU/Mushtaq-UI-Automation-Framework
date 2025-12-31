package forgotpassword;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.SuccessForgotPasswordPage;
import constant.ForgotPasswordMessages;

public class ForgotPasswordTests extends BaseTest implements ForgotPasswordMessages {

    
    @Test 
    public void testForgotPasswordWithCorrectUsername(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Admin");
        
        SuccessForgotPasswordPage successForgotPasswordPage = forgotPasswordPage.clickResetButton();
        Assert.assertEquals(successForgotPasswordPage.getSuccessHeader(),ForgotPasswordMessages.INSTRUCTIONSENTSUCCESSMSG,"Incorrect Success Header's content");
        Assert.assertTrue(successForgotPasswordPage.getSuccessMessage().contains(ForgotPasswordMessages.INSTRUCTIONSENTDETAILMSG),"Incorrect Success message's content ");
    }

    @Test
    public void testForgotPasswordWithWrongUsername(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setUsername("Aaaaaaaaaa");
        forgotPasswordPage.clickResetButton();
        
        Assert.assertTrue(forgotPasswordPage.isMessageWarningDisplayed(),"Warning Message is not displayed");
        Assert.assertTrue(forgotPasswordPage.getWarningMessage().contains(ForgotPasswordMessages.CONTACTHRMSG),"Incorrect warning message's content");
    }

}

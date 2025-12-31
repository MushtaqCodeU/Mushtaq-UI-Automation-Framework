package TestDataProvider;
import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "loginVaildData")
    public static Object[][] getLoginData() {
        return new Object[][] {
            {"Admin", "admin123"}
        };
    }
	
	@DataProvider(name = "loginInvalidData")
    public static Object[][] getLoginDataInvalid() {
        return new Object[][] {
            {"User1", "password1"},
            {"User2", "password2"}
        };
    }
	
	

}

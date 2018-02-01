//Info: When you write your code IntelliJ automatically adds required classes
//Also you can select and add required classes by pressing ALT+Enter then select related class
//import org.JUnit.Assert;
//import org.JUnit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ONUR BASKIRT on 26.08.2015.
 */
public class LoginTest {
    private WebDriver driver;
    public LoginPage loginPage ;

    String returnedUrl = " ";
    String correctUrl = "http://localhost:4200/dashboard";


    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void noEmailOrPasswordLoginTest(){

        loginPage = new LoginPage(driver);
        returnedUrl = loginPage.noParamsLogin();
        assertNotEquals( correctUrl, returnedUrl);

    }
    /**
     * Check login with correct password no email
     */
    @Test
    public void wrongEmailAndPasswordLoginTest(){

        loginPage = new LoginPage(driver);
        returnedUrl = loginPage.wrongEmailAndPasswordLogin();
        assertNotEquals( correctUrl, returnedUrl);

    }

    /**
     * Check login with correct password no email
     */

    @Test
    public void missingEmailLoginTest(){

        loginPage = new LoginPage(driver);
        returnedUrl = loginPage.missingEmailLogin();
        assertNotEquals( correctUrl, returnedUrl);

    }

    /**
     * Check login with correct email no password
     */

    @Test
    public void missingPasswordLoginTest(){

        loginPage = new LoginPage(driver);
        returnedUrl = loginPage.missingPasswordLogin();
        assertNotEquals( correctUrl, returnedUrl);

    }

    /**
     * check login with correct params
     */
    @Test
    public void correctLoginTest(){

        loginPage = new LoginPage(driver);
        returnedUrl = loginPage.correctLogin();
        assertEquals( correctUrl, returnedUrl);

    }

}

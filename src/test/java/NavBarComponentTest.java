import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NavBarComponentTest {
    private WebDriver driver;
    public NavBarComponent navBarComponent;
    String chatUrl = "http://localhost:4200/chat";
    String shotUrl = "http://localhost:4200/dashboard";
    String statUrl = "http://localhost:4200/avglist";
    String baseURL = "http://localhost:4200/login";



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
    public void messageButtonTest() {
        navBarComponent = new NavBarComponent(driver);
        String returnedUrl = navBarComponent.messageButton();
        assertEquals(chatUrl, returnedUrl);
        //navBarComponent.logoutButton();
    }

    @Test
    public void shotButtonTest() {
        navBarComponent = new NavBarComponent(driver);
        String returnedUrl = navBarComponent.shotButton();
        assertEquals(shotUrl, returnedUrl);
        // navBarComponent.logoutButton();
    }
    @Test
    public void statButtonTest() {
        navBarComponent = new NavBarComponent(driver);
        String returnedUrl = navBarComponent.statButton();
        assertEquals(statUrl, returnedUrl);
       // navBarComponent.logoutButton();
    }

    @Test
    public void LogOutButtonTest() {
        navBarComponent = new NavBarComponent(driver);
        String returnedUrl = navBarComponent.logoutButton();
        assertEquals(baseURL, returnedUrl);

    }





}

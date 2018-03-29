import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ShotsTest {
   private WebDriver driver;
    public ShotsComponent shotsComponent;
    private String expectedClubValue;
    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        expectedClubValue = "Club and swing length: 6I & Full";
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * check shots componet is displayed on screen with correct club value
     */
    @Test
    public void clubValueTest() {
        String returnedClubValue;
        shotsComponent = new ShotsComponent(driver);
        returnedClubValue = shotsComponent.searchShots();
        assertEquals(expectedClubValue, returnedClubValue);
    }

}

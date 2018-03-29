import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatsTest {

    private WebDriver driver;
    public StatsComponent statsComponent;
    private String expectedFUll, expectedAverage;
    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        expectedAverage = "4.43";
        expectedFUll    = "5.83";
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();}

    /**
     * Check for correct value displayed for average shots
     */

    @Test
    public void averageShotsTest() {
         statsComponent = new StatsComponent(driver);
        String returnedClubValue = statsComponent.averageShots();
        assertEquals(expectedAverage, returnedClubValue);
    }

    /**
     * Check for correct value displayed for max shots
     */

    @Test
    public void longestShotsTest() {

         statsComponent = new StatsComponent(driver);
        String returnedClubValue = statsComponent.longestShots();
        assertEquals(expectedFUll, returnedClubValue);
    }

    /**
     * Check for graphs displayed
     */
    @Test
    public void graphsTest() {
         statsComponent = new StatsComponent(driver);
        assertTrue(statsComponent.graphs());
    }
}

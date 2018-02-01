import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageTest {

    private WebDriver driver;
    public MessageComponent messageComponent;
    private  List<WebElement> messageCount ;

    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @After
    public void tearDown() throws Exception {
        driver.quit();}

    /**
     * check shots componet is displayed on screen wit correct club value
     */
    @Test
    public void clubValueTest() {

        messageComponent = new MessageComponent(driver);
        int messages= messageComponent.countMesages();
        assertTrue(messages > 0);
    }
}

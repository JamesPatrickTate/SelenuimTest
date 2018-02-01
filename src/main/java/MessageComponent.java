import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessageComponent {
    public NavBarComponent navBarComponent;
    private WebDriver driver;
    private List<WebElement> messageCount ;

    public MessageComponent(WebDriver driver) {
        this.driver = driver;
        //navigate to message page
        navBarComponent = new NavBarComponent(driver);
        navBarComponent.messageButton();

    }

    /**
     * checks that there are messages are on the page
     * @return
     */

    public int countMesages() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("messageContent")));
        messageCount = driver.findElements(By.className("messageContent"));
        System.out.println("message count: " + messageCount.size());
        return messageCount.size();
    }

    //TODO test adding a message
}

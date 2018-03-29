import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageComponent {
    public NavBarComponent navBarComponent;
    private WebDriver driver;
    private List<WebElement> messageCount, messageTimeStamp;
    private WebElement chatButton, chatInput;
    private List<String> timeStamps = new ArrayList<String>();
    private String currentTimeStamp;

    public MessageComponent(WebDriver driver) {
        this.driver = driver;
        //navigate to message page
        navBarComponent = new NavBarComponent(driver);
        navBarComponent.messageButton();
        waitOnPage();
        chatButton = driver.findElement(By.id("chatB"));
        chatInput = driver.findElement(By.className("chatInput"));


    }

    /**
     * checks that there are messages are on the page
     * @return
     */

    public int countMesages() {
        waitOnPage();
        messageCount = driver.findElements(By.className("messageContent"));
        System.out.println("message count: " + messageCount.size());
        return messageCount.size();
    }

    /**
     * check if message our new message appears on screen
     */

    public boolean newMessage() {
        // send message
        chatInput.sendKeys("Selenuim Message");
        chatButton.click();
        currentTimeStamp = todaysDate();
        //check hour and minutes match
        messageTimeStamp = driver.findElements(By.className("timestamp"));
        timeStamps = getTextFromList(messageTimeStamp);
        String newMessageTimeandDate = timeStamps.get(timeStamps.size() - 1).substring(5);
        return currentTimeStamp.contains(newMessageTimeandDate);
    }

    /**
     * uitility method to wait on page to load
     */

    public void waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("messageContent")));
    }

    /**
     * return todays date as yyyy/MM/dd
     * @return
     *
     */

    public String todaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("h:mm:ss a");
        Date date = new Date();
        System.out.println("Date: "+ dateFormat.format(date));
        return dateFormat.format(date);
    }

    /**
     * get the string values from a list of web elements
     * @param webElements
     * @return
     */
    public List<String> getTextFromList(List<WebElement> webElements) {
        List<String> texts = new ArrayList<String>();
        for (WebElement w:
             webElements) {
            texts.add(w.getText().substring(12).trim());
            //System.out.println("timesstamp: " + w.getText().substring(12).trim());
        }
        return texts;
    }
}

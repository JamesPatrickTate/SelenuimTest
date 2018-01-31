import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShotsComponent {
    private WebDriver driver;
    public LoginPage loginPage;
    private WebElement clubInput, shotInfoClub;
    String inputValue, clubValue;

    public ShotsComponent(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        loginPage.correctLogin();
        clubInput.findElement(By.className("input"));
        shotInfoClub.findElement(By.className("clubName"));
        inputValue = "6";
    }

    public String searchShots() {
        clubInput.sendKeys("6");
        driver.findElement(By.id("elementid")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("clubName")));
        clubValue = shotInfoClub.getText();
        System.out.println("club value "+ clubValue);
        return clubValue;
    }
}

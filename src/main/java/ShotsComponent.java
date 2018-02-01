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
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("input")));
        clubInput = driver.findElement(By.className("input"));



    }

    public String searchShots() {
        clubInput.sendKeys("6");
        driver.findElement(By.className("input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("clubName")));
        shotInfoClub = driver.findElement(By.className("clubName"));
        clubValue = shotInfoClub.getText();
        System.out.println("club value "+ clubValue);
        return clubValue;
    }
}

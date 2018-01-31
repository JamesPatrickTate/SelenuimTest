import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class NavBarComponent {
    public LoginPage loginPage;
    private WebDriver driver;
    private String baseURL;
    WebElement messageBoardButton, statsButton, shotsButton, logoutButton, loginButtonNav,signUpButton;


    public NavBarComponent(WebDriver driver) {
        baseURL = "http://localhost:4200/login";
        this.driver = driver;
        loginPage = new LoginPage(driver);
        loginPage.correctLogin();
        messageBoardButton =driver.findElement(By.name("messageBoard"));
        statsButton =driver.findElement(By.name("stats"));
        shotsButton =driver.findElement(By.name("shots"));
        logoutButton =driver.findElement(By.id("lob"));
       // loginButtonNav =driver.findElement(By.id("loginBut"));
       // signUpButton = driver.findElement(By.name("signUp"));

    }

    public String messageButton() {
        messageBoardButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("chatB")));
        return  driver.getCurrentUrl();
    }
    public String shotButton() {
        shotsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("dir")));
        return  driver.getCurrentUrl();
    }

    public String statButton() {
        statsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("MD")));
        return  driver.getCurrentUrl();
    }



    public String logoutButton() {
        logoutButton.click();
       // WebDriverWait wait = new WebDriverWait(driver, 5);
       //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginBut")));
        return driver.getCurrentUrl();
    }
}

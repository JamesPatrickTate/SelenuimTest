import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a page object model of the login component
 * All functionality of the login compnent will be included.
 */

public class LoginPage {
    private WebDriver driver;
    private String baseURL;
    private WebElement email, password, loginButton;
    private final String EMAIL = "jamestate11@gmail.com";
    private final String PASSWORD = "Keelagh46=";

    public LoginPage(WebDriver driver) {

        //go to login page
        this.driver = driver;
        baseURL = "http://localhost:4200/login";
        driver.get(baseURL);



        WebDriverWait wait = new WebDriverWait(driver, 15);

//        //confirm login page
//        System.out.println("Current page title: "+ driver.getTitle());
//        if (!driver.getTitle().equals("AgularWebApp")){
//            throw new WrongPageException("Incorrect page for AgularWebApp Home page");
//        }

        email =driver.findElement(By.name("email"));
        password =driver.findElement(By.name("password"));
        loginButton =driver.findElement(By.id("btn-login"));

    }

    public String correctLogin(){

        String urlOfpage = " ";
        email.sendKeys(EMAIL);
        password.sendKeys(PASSWORD);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("userEmail"), "Hello, jamestate11@gmail.com"));
        urlOfpage = driver.getCurrentUrl();
        System.out.println("current URL: " + driver.getCurrentUrl());


        return urlOfpage;
    }

    public String noParamsLogin(){

        String urlOfpage = " ";
        loginButton.click();
        urlOfpage = driver.getCurrentUrl();


        return urlOfpage;
    }

    public String missingEmailLogin(){

        String urlOfpage = " ";
        email.sendKeys(" ");
        password.sendKeys(PASSWORD);
        loginButton.click();
        urlOfpage = driver.getCurrentUrl();
        return urlOfpage;
    }

    public String missingPasswordLogin(){

        String urlOfpage = " ";
        email.sendKeys(EMAIL);
        password.sendKeys(" ");

        loginButton.click();
        urlOfpage = driver.getCurrentUrl();
        System.out.println("current URL: " + driver.getCurrentUrl());
        return urlOfpage;
    }

    public String wrongEmailAndPasswordLogin(){

        String urlOfpage = " ";
        email.sendKeys("xxxxxx");
        password.sendKeys("xxxxxx ");
        loginButton.click();
        urlOfpage = driver.getCurrentUrl();
        return urlOfpage;
    }



}

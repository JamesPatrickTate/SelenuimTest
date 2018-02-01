import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StatsComponent {
    public LoginPage loginPage;
    public NavBarComponent navBarComponent;
    private WebDriver driver;
    private WebElement longestFiveShot, averageFiveFullShot, graph;

    public StatsComponent(WebDriver driver) {
        this.driver = driver;
        //navigate to stats page
        navBarComponent = new NavBarComponent(driver);
        navBarComponent.statButton();

    }

    public String longestShots() {
        longestFiveShot= driver.findElement(By.name("longFive"));
        System.out.println("Longest five: "+ longestFiveShot.getText());
        return longestFiveShot.getText();

    }

    public String averageShots() {
        averageFiveFullShot = driver.findElement(By.name("fiveAverge"));
        System.out.println("full shot dist: " +averageFiveFullShot.getText() );
        return averageFiveFullShot.getText();

    }

    public boolean graphs() {
        graph = driver.findElement(By.className("chartjs-render-monitor"));
       //System.out.println("full shot dist: " +averageFiveFullShot.getText() );
        return graph.isDisplayed();

    }
}

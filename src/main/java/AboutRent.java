import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AboutRent {
    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private By whereToBring = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By dayOfRent = By.xpath(".//div[contains(@class,'today')]");
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private By chooseOneDayRent = By.xpath(".//div[@class='Dropdown-menu']/*[text()='сутки']");
    private By colourCheckbox = By.id("black");
    private By commentaryInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By order = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By acceptOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    public void chooseRentDay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(whereToBring))).click();
        driver.findElement(dayOfRent).click();
    }
    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(chooseOneDayRent).click();
    }
    public void chooseColourCheckbox() {
        driver.findElement(colourCheckbox).click();
    }
    public void addCommentary(String commentary) {
        driver.findElement(commentaryInput).sendKeys(commentary);
    }
    public void createOrder() {
        driver.findElement(order).click();
        driver.findElement(acceptOrder).click();
    }
    public void checkCompletedOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Заказ оформлен']"))));
    }
}

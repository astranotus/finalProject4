import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.junit.Assert.assertTrue;

public class ForWhom {
    public ForWhom(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By station = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public void sendKeyToNameInput(String key) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(key);
    }
    public void sendKeyToLastnameInput(String key) {
        driver.findElement(lastNameInput).sendKeys(key);
    }
    public void sendKeysAddress(String key) {
        driver.findElement(address).sendKeys(key);
    }
    public void chooseStation(String metro) {
        driver.findElement(station).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='" + metro + "']"))).click();
    }
    public void sendKeysForPhone(String phone) {
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void checkForWhomInputs(String name, String lastname, String address, String station, String phone) {
        Assertions.assertAll(
                () -> assertTrue("Заданное значение имени не сохранилось",
                        driver.findElement(By.xpath("//input[@value='" + name + "']")).isDisplayed()),
                () -> assertTrue("Заданное значение фамилии не сохранилось",
                        driver.findElement(By.xpath("//input[@value='" + lastname + "']")).isDisplayed()),
                () -> assertTrue("Заданное значение адреса не сохранилось",
                        driver.findElement(By.xpath("//input[@value='" + address + "']")).isDisplayed()),
                () -> assertTrue("Заданное значение станции не сохранилось",
                        driver.findElement(By.xpath("//input[@value='" + station + "']")).isDisplayed()),
                () -> assertTrue("Заданное значение телефона не сохранилось",
                        driver.findElement(By.xpath("//input[@value='" + phone + "']")).isDisplayed())
        );
    }
}

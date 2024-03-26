import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    private By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");
    private By questionMoney = By.xpath(".//div[@id='accordion__heading-0']");
    private By questionHowMany = By.xpath(".//div[@id='accordion__heading-1']");
    private By questionRentTime = By.xpath(".//div[@id='accordion__heading-2']");
    private By questionOrderToday = By.xpath(".//div[@id='accordion__heading-3']");
    private By questionExtend = By.xpath(".//div[@id='accordion__heading-4']");
    private By questionCharging = By.xpath(".//div[@id='accordion__heading-5']");
    private By questionRentCanceled = By.xpath(".//div[@id='accordion__heading-6']");
    private By questionMKAD = By.id("accordion__heading-7");
    private By valueOfOpenedMoney =  By.id("accordion__panel-0");
    private By valueOfOpenedHowMany =  By.id("accordion__panel-1");
    private By valueOfOpenedRentTime =  By.id("accordion__panel-2");
    private By valueOfOpenedOrderToday =  By.id("accordion__panel-3");
    private By valueOfOpenedExtend =  By.id("accordion__panel-4");
    private By valueOfOpenedCharging =  By.id("accordion__panel-5");
    private By valueOfOpenedRentCanceled =  By.id("accordion__panel-6");
    private By valueOfOpenedMKAD =  By.id("accordion__panel-7");
    private By firstQuestionAnswer = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    private By secondQuestionAnswer = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }
    public String getAnswerText(By question,By answer) {
        WebElement questionElement = driver.findElement(question);
        new Actions(driver)
                .scrollToElement(questionElement)
                .perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(question));
        driver.findElement(question).click();
        WebElement answerElement = driver.findElement(answer);
        wait.until(ExpectedConditions.visibilityOf(answerElement));
        new Actions(driver)
                .scrollToElement(answerElement)
                .perform();
        return driver.findElement(answer).getText();
    }
    public String getMoneyAnswerText() {
       return getAnswerText(questionMoney, valueOfOpenedMoney);
    }
    public String getHowManyAnswerText() {
        return getAnswerText(questionHowMany, valueOfOpenedHowMany);
    }
    public String getRentTime0Text() {
        return getAnswerText(questionRentTime, valueOfOpenedRentTime);
    }
    public String getOrderRentTodayAnswerText() {
        return getAnswerText(questionOrderToday, valueOfOpenedOrderToday);
    }
    public String getExtendAnswerText() {
        return getAnswerText(questionExtend, valueOfOpenedExtend);
    }
    public String getChargingAnswerText() {
        return getAnswerText(questionCharging, valueOfOpenedCharging);
    }
    public String getRentCanceledAnswerText() {
        return getAnswerText(questionRentCanceled, valueOfOpenedRentCanceled);
    }
    public String getMKADAnswerText() {
        return getAnswerText(questionMKAD, valueOfOpenedMKAD);
    }
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}

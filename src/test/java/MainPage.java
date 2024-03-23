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
    private By firstElementOfDropdownInQuestionsAboutImportant = By.xpath(".//div[@id='accordion__heading-0']");
    private By secondElementOfDropdownInQuestionsAboutImportant = By.id("accordion__heading-7");
    private By valueOfOpenedFirstDropdown =  By.id("accordion__panel-0");
    private By valueOfOpenedSecondDropdown =  By.id("accordion__panel-7");
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
    public String getFirstAnswerText() {
       return getAnswerText(firstElementOfDropdownInQuestionsAboutImportant, valueOfOpenedFirstDropdown);
    }
    public String getSecondAnswerText() {
        return getAnswerText(secondElementOfDropdownInQuestionsAboutImportant, secondQuestionAnswer);
    }
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}

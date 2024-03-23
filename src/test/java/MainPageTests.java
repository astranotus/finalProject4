import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAcceptCookieButton();
    }

    @Test
    public void checkFirstQuestionsAnswer() {
        MainPage mainPage = new MainPage(driver);
        Assertions.assertEquals(Constants.ANSWER_QUESTION_ABOUT_MONEY, mainPage.getFirstAnswerText());
    }

    @Test
    public void checkSecondQuestionsAnswer() {
        MainPage mainPage = new MainPage(driver);
        Assertions.assertEquals(Constants.ANSWER_QUESTION_ABOUT_MKAD, mainPage.getSecondAnswerText());
    }

    @AfterEach
    public void everyTestEnding() {
        driver.quit();
    }
}

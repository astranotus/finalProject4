import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MainPageTests {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        mainPage.clickAcceptCookieButton();
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of((Supplier<String>) () -> mainPage.getMoneyAnswerText(), Constants.ANSWER_QUESTION_MONEY),
                Arguments.of((Supplier<String>) () -> mainPage.getHowManyAnswerText(), Constants.ANSWER_QUESTION_HOW_MANY),
                Arguments.of((Supplier<String>) () -> mainPage.getRentTime0Text(), Constants.ANSWER_QUESTION_RENT_TIME),
                Arguments.of((Supplier<String>) () -> mainPage.getOrderRentTodayAnswerText(), Constants.ANSWER_QUESTION_ORDER_TODAY),
                Arguments.of((Supplier<String>) () -> mainPage.getExtendAnswerText(), Constants.ANSWER_QUESTION_EXTEND),
                Arguments.of((Supplier<String>) () -> mainPage.getChargingAnswerText(), Constants.ANSWER_QUESTION_CHARGING),
                Arguments.of((Supplier<String>) () -> mainPage.getRentCanceledAnswerText(), Constants.ANSWER_QUESTION_RENT_CANCELED),
                Arguments.of((Supplier<String>) () -> mainPage.getMKADAnswerText(), Constants.ANSWER_QUESTION_ABOUT_MKAD)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void checkQuestions(Supplier<String> answerSupplier, String expectedResult) {
        MainPage mainPage = new MainPage(driver);


        String answer = answerSupplier.get();

        Assertions.assertEquals(expectedResult, answer,  "Ожидаемый текст ответа отличается от полученного");
    }

    @Test
    @DisplayName("Проверяем работоспособность нжиней кнопки оформления на главной странице, путем открытия последующей и " +
            "нахождения на ней существующего элемента")
    public void checkBottomOrderButtonText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBottomOrderButton();
        ForWhom forWhom = new ForWhom(driver);
        forWhom.chooseStation(Constants.SOKOLNIKI);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderCreateTests {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Constants.NAME, Constants.LASTNAME, Constants.ADDRESS, Constants.CHERKIZOVSKAIA, Constants.FIRST_PHONE,
                        Constants.FIRST_COMMENT},
                {Constants.SECOND_NAME, Constants.SECOND_LASTNAME,Constants.SECOND_ADDRESS, Constants.SOKOLNIKI,
                        Constants.SECOND_PHONE, Constants.SECOND_COMMENT}
        });
    }
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAcceptCookieButton();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void orderCreateTest(String name, String lastname, String address, String metro, String phone,
                                String comment) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderOrderButton();

        ForWhom forWhom = new ForWhom(driver);
        forWhom.sendKeyToNameInput(name);
        forWhom.sendKeyToLastnameInput(lastname);
        forWhom.sendKeysAddress(address);
        forWhom.chooseStation(metro);
        forWhom.sendKeysForPhone(phone);
        forWhom.checkForWhomInputs(name, lastname, address, metro, phone);
        forWhom.clickNextButton();

        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.chooseRentDay();
        aboutRent.chooseRentalPeriod();
        aboutRent.chooseColourCheckbox();
        aboutRent.addCommentary(comment);
    }
    @AfterEach
    public void everyTestEnding() {
        driver.quit();
    }
}

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MainPage;
import java.time.Duration;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Проверка переходов к разделам:«Булки», «Соусы», «Начинки».")
    public void navigationThroughMenu() {

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.PasswordRecoveryPage;
import pageobjects.RegistrationPage;
import java.time.Duration;

public class LoginTest {
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
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton(){
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void loginThroughSignInButton(){
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля.")
    public void LoginThroughTheButtonInThePasswordRecoveryForm(){
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        passwordRecoveryPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginThroughTheButtonInTheRegistrationForm(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRegisterButton();
        registrationPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

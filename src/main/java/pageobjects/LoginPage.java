package pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }
    private final String urlPage = "https://stellarburgers.nomoreparties.site/login";
    //кнопка зарегистрироваться внизу страницы
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //кнопка восстановить пароль
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    //кнопка войти
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    //поле ввода почты в окне входа
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //поле ввода пароля в окне входа
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void checkRegistrationIsSuccessfully(){
        String textOfRestorePasswordButton = driver.findElement(restorePasswordButton).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Восстановить пароль"));
    }
    public void enterEmailAndPassword(){
        driver.findElement(emailField).sendKeys("test@test.ts");
        driver.findElement(passwordField).sendKeys("12345678");
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
    public void clickRestorePasswordButton(){
        driver.findElement(restorePasswordButton).click();
    }
}

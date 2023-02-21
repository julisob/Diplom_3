package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }
    public WebElement wait(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    //страница
    private final String urlPage = "https://stellarburgers.nomoreparties.site/register";
    //поле ввода имя
    private final By nameField = By.xpath("//fieldset[1]/div/div/input");
    //поле ввода email
    private final By emailField = By.xpath("//fieldset[2]/div/div/input");
    //поле ввода пароль
    private final By passwordField = By.xpath("//fieldset[3]/div/div/input");
    //кнопка зарегистрироваться
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");

    //кнопка войти внизу страницы
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    public void inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
    public void register(String name, String email, String password){
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegister();
    }

    public String waitForResultVisibility(String result) {
        By someButton = By.xpath((String.format("//*[text()='%s']", result)));
        return wait(someButton).getText();
    }

    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}

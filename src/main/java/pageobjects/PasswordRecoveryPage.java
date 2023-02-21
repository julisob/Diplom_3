package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }
    //страница
    private final String urlPage = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}

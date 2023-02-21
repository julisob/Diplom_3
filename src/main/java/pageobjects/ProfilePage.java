package pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class ProfilePage {
    private final WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }
    private final String urlPage = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By logoutButton = //кнопка Выход
            By.xpath(".//button[text() = 'Выход']");

    private final By constructorButton = //кнопка Конструктор наверху слева
            By.xpath(".//p[text()='Конструктор']");

    private final By logoButton = //лого
            By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public void checkLogoutButton(){
        String textOfLogoutButton = driver.findElement(logoutButton).getText();
        MatcherAssert.assertThat(textOfLogoutButton, startsWith("Выход"));
    }
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }
}

package pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }

    //страница
    private final String urlPage = "https://stellarburgers.nomoreparties.site/";

    //кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    //кнопка войти в аккаунт
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //кнопка оформить заказ
    private final By makeOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");

    //кнопка булки
    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");

    //кнопка соусы
    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");

    //кнопка начинки
    private final By fillingsButton = By.xpath(".//*[text()='Начинки']");

    public void clickAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public void checkOrderButton() {
        String textOrderButton = driver.findElement(makeOrderButton).getText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }
    public void checkGoToTheBunsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[1]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    public void checkGoToTheSaucesSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[2]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    public void checkGoToTheFillingsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[3]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
}

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.RegistrationPage;

import java.time.Duration;

import static org.apache.http.HttpStatus.SC_OK;

@RunWith(Parameterized.class)
public class RegisterTest {
    private final String name;
    private final String email;
    private final String password;
    private final String expected;
    private WebDriver driver;
    private RegistrationPage objRegisterPage;
    private static UserHelper userHelper;
    private static User user;
    private static User userPwd;
    private static String accessToken;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objRegisterPage = new RegistrationPage(driver);
        objRegisterPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public RegisterTest(String name, String email, String password, String expected) {
        driver = new ChromeDriver();
        this.name = name;
        this.email = email;
        this.password = password;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        userHelper = new UserHelper();
        user = Random.getRandomUser();
        userPwd = Random.getRandomUserNotValidPwd();
        return new Object[][]{
                {user.getName(),user.getEmail(),user.getPassword(), "Вход"},
                {userPwd.getName(),userPwd.getEmail(),userPwd.getPassword(), "Некорректный пароль"},
        };
    }
    @Test
    @Description("Проверка регистрации")
    public void testRegister() {
        objRegisterPage.register(name, email, password);
        Credentials credentials = new Credentials(user);
        Response response = userHelper.postLoginUser(credentials);
        int statusCode = response.then().extract().statusCode();
        if(statusCode == SC_OK){
            accessToken = response.then().extract().path("accessToken").toString().substring(6).trim();
        }
        Assert.assertEquals(objRegisterPage.waitForResultVisibility(expected), expected);
    }
    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        userHelper.deleteUser(accessToken);
        Thread.sleep(300);
    }
}

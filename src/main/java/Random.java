import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class Random {
    @Step("Random user")
    public static User getRandomUser() {
        Faker faker = new Faker();
        return new User(faker.internet().emailAddress(), faker.regexify("[a-z1-9]{10}"), faker.name().firstName());
    }

    @Step("Random user with not valid password")
    public static User getRandomUserNotValidPwd() {
        Faker faker = new Faker();
        return new User(faker.internet().emailAddress(), faker.regexify("[a-z1-9]{5}"), faker.name().firstName());
    }
}

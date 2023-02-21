import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserHelper extends Helper {
    public static Response postCreateUser(User user) {
        RestAssured.baseURI = BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(POST_CREATE_USER);
    }

    public static void deleteUser(String accessToken) {
        RestAssured.baseURI = BASE_URL;
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER);
    }

    public static Response postLoginUser(Credentials userCredentials) {
        RestAssured.baseURI = BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userCredentials)
                .when()
                .post(POST_LOGIN_USER);
    }

    public static Response postLogoutUser(String refreshToken) {
        RestAssured.baseURI = BASE_URL;
        return given()
                .header("Authorization", refreshToken)
                .when()
                .post(POST_LOGOUT_USER);
    }
}

package day16;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.UUID;
import static io.restassured.RestAssured.given;

public class TrelloCRUD {
    private static final String url="https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
    private static final String name="username-co";
    private static final String key="f037495712ba064a957e97dad510b26b";
    private static final String token="f02f1be70c984f4535604d200aa9d074e0fa2eb12f1f937a9ed8076d6fd31816";
    private String boardId;

    @Test
    public void createBoard() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Response response = given().when()
                .contentType("application/json")
                .log().all()
                .post(String.format(url, name, key, token));
        response.then()
                .assertThat()
                .statusCode(200);
        boardId = response.getBody().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "createBoard")
    public void getBoard(){
        given().when()
                .contentType("application/json")
                .log().all()
                .get(String.format(url, name, key, token))
                .then()
                .assertThat()
                .statusCode(200);
    }
}

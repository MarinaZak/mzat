package day16;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssuredCRUD {
    private String key="b230e1878c2f2fb724b7786fe2484d9e";
    private String token="5245ef3beacd0905a61969f9064fa74e7babdf2f23f96c52d000f3a6408e1bc1";
    private String url="https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
    private String url2="https://api.trello.com/1/boards/%s?name=%s&key=%s&token=%s";
    private String url3="https://api.trello.com/1/boards/%s?key=%s&token=%s";
    private String id;

    @Test
    public void createBoard() {
        Response response = given().when()
                .contentType("application/json")
                .post(String.format(url, "My board", key, token));
        response.then()
                .assertThat()
                .statusCode(200);

        id = response.getBody().jsonPath().get("id");
    }

    @Test(dependsOnMethods="createBoard")
    public void updateBoard() {
        Response response = given().when()
                .contentType("application/json")
                .put(String.format(url2, id, "New name", key, token));
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods="updateBoard")
    public void getBoard() {
        Response response = given().when()
                .contentType("application/json")
                .get(String.format(url3, id, key, token));
        response.then()
                .assertThat()
                .statusCode(200);

        System.out.println(response.getBody().jsonPath().get("name").toString());
    }

    @Test(dependsOnMethods="getBoard")
    public void deleteBoard() {
        Response response = given().when()
                .contentType("application/json")
                .delete(String.format(url3, id, key, token));
        response.then()
                .assertThat()
                .statusCode(200);
    }
}

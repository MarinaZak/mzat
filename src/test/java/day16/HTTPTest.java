package day16;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.hc.client5.http.impl.async.H2AsyncClientBuilder;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Flow;

import static io.restassured.RestAssured.given;

public class HTTPTest {
    private static final String url="https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
    private static final String name="username-co";
    private static final String key="f037495712ba064a957e97dad510b26b";
    private static final String token="f02f1be70c984f4535604d200aa9d074e0fa2eb12f1f937a9ed8076d6fd31816";
    private String boardId;

    @Test
    public void createBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url,name,key,token)))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Invalid status code");
        boardId=new JSONObject(response.body()).getString("id");
    }

    @Test(dependsOnMethods = "createBoard")
    public void getBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url,name,key,token)))
                .GET()
                .build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Invalid status code");
    }
}

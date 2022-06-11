package day16;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientCRUD {
    private String key="b230e1878c2f2fb724b7786fe2484d9e";
    private String token="5245ef3beacd0905a61969f9064fa74e7babdf2f23f96c52d000f3a6408e1bc1";
    private String url="https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
    private String url2="https://api.trello.com/1/boards/%s?name=%s&key=%s&token=%s";
    private String url3="https://api.trello.com/1/boards/%s?key=%s&token=%s";
    private String id;

    @Test
    public void createBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url, "MyBoard", key, token)))
                .POST(HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Creation failed");

        id = new JSONObject(response.body()).get("id").toString();
    }

    @Test(dependsOnMethods = "createBoard")
    public void updateBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url2, id, "NewName", key, token)))
                .PUT(HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Updating failed");
    }

    @Test(dependsOnMethods = "updateBoard")
    public void getBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url3, id, key, token)))
                .GET().build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Reading failed");

        System.out.println(new JSONObject(response.body()).get("name"));
    }

    @Test(dependsOnMethods = "getBoard")
    public void deleteBoard() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(String.format(url3, id, key, token)))
                .DELETE().build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(),200,"Deleting failed");
    }
}

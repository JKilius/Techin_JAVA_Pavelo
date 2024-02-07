import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.*;

public class ApichallengesTempTest {

    @Test
    public void createAndDeleteChallenges() {
        // Base URLs
        String baseUrl = "https://apichallenges.herokuapp.com";
        String todosEndPoint = "/todos";

        // Header settings
        String headerKey = "X-CHALLENGER";
        String headerValue = "06c5165e-5316-49c4-89b6-c5a07279da95";

        // Post new todos
        System.out.println("---Posting 25 new todos---");

        IntStream.rangeClosed(1, 25).forEach(i -> {
            String myJson = "{\"title\":\"Title " + i + "\"}";
            Response responsePost = RestAssured.given()
                    .baseUri(baseUrl)
                    .header(headerKey, headerValue)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(myJson)
                    .post(todosEndPoint);

            // Print the response
            System.out.println("Response for POST " + i + ": " + responsePost.asString());
            System.out.println("Status Code: " + responsePost.getStatusCode());
        });
        System.out.println();

        // Get the response
        System.out.println("---Looking up available todos---");

        Response responseGet = given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(todosEndPoint);

        // Print status code and response body
        System.out.println("Status code: " + responseGet.getStatusCode());
        System.out.println("Response body: " + responseGet.getBody().asString());
        System.out.println();

        // Extract 'id' values from the response
        System.out.println("---Looking up extracted id values---");

        JsonPath jsonPath = responseGet.jsonPath();
        List<Integer> ids = jsonPath.getList("todos.id");
        System.out.println("All 'id' values: " + ids);
        System.out.println();

        // Delete each 'id'
        System.out.println("---Deleting all available todos using extracted ids---");

        ids.forEach(id -> {
            Response responseDelete = RestAssured.given()
                    .baseUri(baseUrl)
                    .header(headerKey, headerValue)
                    .delete(todosEndPoint + "/" + id);
            System.out.println("Status Code for DELETE " + id + ": " + responseDelete.getStatusCode());
        });
        System.out.println();

        // Get the response
        System.out.println("---Looking up available todos---");
        responseGet = given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(todosEndPoint);

        // Print status code and response body
        System.out.println("Status code: " + responseGet.getStatusCode());
        System.out.println("Response body: " + responseGet.getBody().asString());
    }
}

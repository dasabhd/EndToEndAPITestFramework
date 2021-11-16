package stepDefinitions;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class stepDefinition {

    RequestSpecification res;

    Response response;

    String response1;

    TestDataBuild tb = new TestDataBuild();

    Utils utility = new Utils();

    /*
         AddBook API Requests
     */

    @Given("AddBook Payload with {string},{string},{string},{string}")
    public void add_book_payload(String String1,String String2,String String3,String String4)
            throws IOException {
        // Write code here that turns the phrase above into concrete actions

        res = given().spec(utility.headers()).body(tb.addPlaceBuild(String1, String2, String3, String4));

    }
    @When("User places AddBook request through POST method")
    public void user_places_add_book_request_through_post_method() {
        // Write code here that turns the phrase above into concrete actions

        APIResources resource = APIResources.valueOf("AddBook");

          response = res.when().post(resource.getResource()).then().assertThat()
                  .statusCode(200).extract().response();
    }

    @Then("Msg of response is successfull")
    public void msg_of_response_is_successfull() {
        // Write code here that turns the phrase above into concrete actions

        response1 = response.asString();

        JsonPath js = new JsonPath(response1);

        Assert.assertEquals(js.getString("Msg"),"successfully added");


    }

    /*
         GetBook API Requests
     */
    @Given("Query Parameters Given {string}")
    public void query_parameters_given(String string1) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(utility.headers()).contentType(ContentType.JSON)
                .queryParam("AuthorName",string1);

    }
    @When("User places GetBook request through GET method")
    public void user_places_get_book_request_through_get_method() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        response = res.when().get(utility.GetGlobalProperties("GetBook")).then()
                .assertThat().statusCode(200).extract().response();
    }
    @Then("Book Name is {string}")
    public void book_name_is(String string1) {
        // Write code here that turns the phrase above into concrete actions

        response1 = response.asString();

        JsonPath js = new JsonPath(response1);

        Assert.assertEquals(string1, js.getString("book_name"));

    }


}

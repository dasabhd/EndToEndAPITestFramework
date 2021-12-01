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

/**
 * The type Step definition.
 */
public class stepDefinition {

    /**
     * The Res.
     */
    RequestSpecification res;

    /**
     * The Response.
     */
    Response response;

    /**
     * The Response 1.
     */
    String response1;

    /**
     * The Tb.
     */
    TestDataBuild tb = new TestDataBuild();

    /**
     * The Utility.
     */
    Utils utility = new Utils();

    /*
         AddBook API Requests
     */

    /**
     * Add book payload.
     *
     * @param String1 the string 1
     * @param String2 the string 2
     * @param String3 the string 3
     * @param String4 the string 4
     * @throws IOException the io exception
     */
    @Given("AddBook Payload with {string},{string},{string},{string}")
    public void add_book_payload(String String1,String String2,String String3,String String4)
            throws IOException {
        // Write code here that turns the phrase above into concrete actions

        res = given().spec(utility.headers()).body(tb.addPlaceBuild(String1, String2, String3, String4));

    }

    /**
     * User places add book request through post method.
     */
    @When("User places AddBook request through POST method")
    public void user_places_add_book_request_through_post_method() {
        // Write code here that turns the phrase above into concrete actions

        APIResources resource = APIResources.valueOf("AddBook");

          response = res.when().post(resource.getResource()).then().assertThat()
                  .statusCode(200).extract().response();
    }

    /**
     * Msg of response is successfull.
     */
    @Then("Msg of response is successfull")
    public void msg_of_response_is_successfull() {
        // Write code here that turns the phrase above into concrete actions

        response1 = response.asString();

        JsonPath js = new JsonPath(response1);

        Assert.assertEquals(js.getString("Msg"),"successfully added");


    }

    /**
     * Query parameters given.
     *
     * @param string1 the string 1
     * @throws IOException the io exception
     */
/*
         GetBook API Requests
     */
    @Given("Query Parameters Given {string}")
    public void query_parameters_given(String string1) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(utility.headers()).contentType(ContentType.JSON)
                .queryParam("AuthorName",string1);

    }

    /**
     * User places get book request through get method.
     *
     * @throws IOException the io exception
     */
    @When("User places GetBook request through GET method")
    public void user_places_get_book_request_through_get_method() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        response = res.when().get(utility.GetGlobalProperties("GetBook")).then()
                .assertThat().statusCode(200).extract().response();
    }

    /**
     * Book name is.
     *
     * @param string1 the string 1
     */
    @Then("Book Name is {string}")
    public void book_name_is(String string1) {
        // Write code here that turns the phrase above into concrete actions

        response1 = response.asString();

        JsonPath js = new JsonPath(response1);

        Assert.assertEquals(string1, js.getString("book_name"));

    }


}

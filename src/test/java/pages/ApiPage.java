package pages;

import helper.EndPoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareURL(String url){

        switch (url){
            case "GET_LIST_USERS":
                setURL = EndPoint.GET_LIST_USERS;
                break;
            case "POST_NEW_USER":
                setURL = EndPoint.POST_NEW_USER;
                break;
            case "DELETE_USER":
                setURL = EndPoint.DELETE_USER;
                break;
            default:
                System.out.println("Input a valid URL");
        }

    }

    public void hitTheGetAPI(){
        res = getListUsers(setURL);
    }

    public void validateStatusCode(int statusCode){
        assertThat(res.statusCode()).isEqualTo(statusCode);

    }

    public void validateResponseBody(){

        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");

    }

    public void validateJsonShcema(String fileName){
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));

    }

    public void hitThePOSTAPI(){
        res = postNewUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validatePOSTResponseBody(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);


    }

    public void hitTheDELETEAPI(){
        res = deleteUser(setURL, global_id);

    }

    public void hitTheUPDATEAPI(){
        res = updateUser(setURL, global_id);

    }

    public void validateUPDATEResponseBody(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }


}

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Configuration;
import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GooglePOSTAPI extends Configuration {
	
	public GooglePOSTAPI() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI=prop.getProperty("BASEURI");
	}
	
	@Test
	public void postData() {
		//RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
		    queryParam("key",prop.getProperty("KEY")).
		    body(PayLoad.getPostRequestData()).
		when().
		   post(Resources.placePostData()).
	    then().
	       assertThat().statusCode(200).
	    and().
           contentType(ContentType.JSON).
        and().
           body("scope",equalTo("APP")).
           extract().response();  //it will extract the whole response in raw format
		
		String response=res.asString(); // changing the raw format response in string
		System.out.println(response);
		
		JsonPath js=new JsonPath(response); // it will change the String response into json response
		
		String placeId=js.get("place_id");
		System.out.println(placeId);
		
// Delete the place id created above
		given().
		queryParam("key",prop.getProperty("KEY")).
		body("{"+
				  "\"place_id\": \""+placeId+"\""+
				"}").
		when().
		delete(Resources.placeDeleteData()).
		then().
	       assertThat().statusCode(200).
	    and().
        contentType(ContentType.JSON).
        and().
        body("status",equalTo("OK"));
		
		
// Verifying the place id is deleted successfully if deleting the same place id which is already deleted	
		given().
		queryParam("key",prop.getProperty("KEY")).
		body("{"+
				  "\"place_id\": \""+placeId+"\""+
				"}").
		when().
		post(Resources.placeDeleteData()).
		then().
	       assertThat().statusCode(404).
	    and().
        contentType(ContentType.JSON).
        and().
        body("msg",equalTo("Delete operation failed, looks like the data doesn't exists"));
		
		
	}

}

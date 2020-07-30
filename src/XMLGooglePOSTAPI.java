import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Configuration;
import files.XMLPayLoad;
import files.XMLResources;
import files.XmlToStringConversion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class XMLGooglePOSTAPI extends Configuration {
	
	String path=System.getProperty("user.dir")+"\\src\\xmlfiles\\postData.xml";
	
	public XMLGooglePOSTAPI() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws IOException {
		RestAssured.baseURI=prop.getProperty("BASEURI");
	}
	
	@Test
	public void postXMLData() throws IOException {
		//RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
		    queryParam("key",prop.getProperty("KEY")).
		    body(XMLPayLoad.getPostRequestXMLData()).
		when().
		   post(XMLResources.placePostData()).
	    then().
	       assertThat().statusCode(200).
        and().
           extract().response();  //it will extract the whole response in raw format
		
		String response=res.asString(); // changing the raw format response in string
		System.out.println(response);
}
}
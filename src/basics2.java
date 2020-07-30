
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class basics2 {

	
	@Test
	public void createPlaceAPI()
	{
		RestAssured.baseURI="http://216.10.245.166";
		given().
		
		queryParam("key","qaclick123").
		body("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
				"<root>\r\n" + 
				"    <location>\r\n" + 
				"        <lat>-38.383494</lat>\r\n" + 
				"        <lng>33.427362</lng>\r\n" + 
				"    </location>\r\n" + 
				"    <accuracy>50</accuracy>\r\n" + 
				"    <name>The Mens store</name>\r\n" + 
				"    <phone_number>(+91) 983 893 3937</phone_number>\r\n" + 
				"    <address>Anna Salai, Chennai</address>\r\n" + 
				"    <types>shoe park</types>\r\n" + 
				"    <types>kadai</types>\r\n" + 
				"    <website>http://google.com</website>\r\n" + 
				"    <language>tamil-IN</language>\r\n" + 
				"</root>").
		when().
		post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().contentType(ContentType.XML);
		
	// Create a place =response (place id)
		
		// delete Place = (Request - Place id)	
		

	}
}


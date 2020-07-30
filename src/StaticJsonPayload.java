import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StaticJsonPayload {
	
	@Test
    public void addBookPostAPI() throws IOException {
     RestAssured.baseURI="http://216.10.245.166";
     String currentUserHomeDir=System.getProperty("user.dir");
		String staticJsonpath = currentUserHomeDir + File.separator + "src" + File.separator + "files" + File.separator
				+ "staticjson.json";

		 given()
		.log().all()
		.header("Content-Type","application/json")
		.body(GenerateStringFromResource(staticJsonpath))
		.when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat()
		.statusCode(200).extract().response();
	}
	
	
	public static String GenerateStringFromResource(String path) throws IOException{
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}

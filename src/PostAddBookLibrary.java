import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUsableMethods;

public class PostAddBookLibrary {
	

	       @Test(dataProvider="BookData")
	       public void addBookPostAPI(String isbn,String aisle) {
	        RestAssured.baseURI="http://216.10.245.166";

			String response = given()
			.log().all()
			.header("Content-Type","application/json")
			.body(PayLoad.AddBook("sant1123","sant1123"))
			.when()
			.post("/Library/Addbook.php")
			.then().log().all().assertThat()
			.statusCode(200).extract().response().asString();
			JsonPath js = ReUsableMethods.rawToJson(response);
			String ID=js.getString("ID");
			System.out.println("ID is: "+ID);
	//Delete API		
			given()
			.log().all()
			.header("Content-Type","application/json")
			.body("{&quot;ID&quot;:&quot;"+ID+"&quot;}")
			.when()
			.delete("/Library/DeleteBook.php")
			.then().log().all().assertThat()
			.statusCode(200).extract().response();
					
			}	
	       
	       @DataProvider(name="BookData")
	       public Object[][] getData(){
	    	   
	    	   return new Object[][]{{"sant3","sant3"},{"san5","san5"},{"san6","san6"}};
	    	   
	       }
				
		
	
	}


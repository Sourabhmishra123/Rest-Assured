package REQRES;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Day02_Trello {
String dummy;
	
	@Test(enabled = true, priority = 0)
	public void createTrello() {
		 Response demo = given().queryParam("name" , "Sourabh").queryParam("key", "d4fa51993a64f3632dcf43b4fd339bf7")
		.queryParam("token", "ATTA33f578290865df212d7d7bceac15413766c20da1ae40175c0a8b159de50e41189E8CE7DC")
		.header("Content-Type","application/JSON")
		.when().post("https://api.trello.com/1/boards/").then().contentType(ContentType.JSON).statusCode(200)
		.extract().response();
	 
		String demo2 = demo.asString();	
		JsonPath jp = new JsonPath(demo2);
		dummy = jp.get("id");
		System.out.println(dummy);
		
		
						
	}
	//https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken
	
	@Test(enabled = false)
	public void delete() {
		given().queryParam("key", "d4fa51993a64f3632dcf43b4fd339bf7")
		.queryParam("token", "ATTA33f578290865df212d7d7bceac15413766c20da1ae40175c0a8b159de50e41189E8CE7DC")
		.header("Content-Type","application/JSON").when().delete("https://api.trello.com/1/boards/66275368e17cddc8b79a2dad")
		.then().contentType(ContentType.JSON).statusCode(200).log().all();
}
	
	//https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken
	
	@Test(enabled = true, priority = 1)
	public void GetaBoard() {	
		given().queryParam("key", "d4fa51993a64f3632dcf43b4fd339bf7")
		.queryParam("token", "ATTA33f578290865df212d7d7bceac15413766c20da1ae40175c0a8b159de50e41189E8CE7DC")
		.header("Content-Type","application/JSON").when().get("https://api.trello.com/1/boards/"+dummy)
		.then().log().all();
}
}

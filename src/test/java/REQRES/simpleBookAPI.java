package REQRES;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class simpleBookAPI {
	
	String accessToken = "95de0879c4d3d4ff7e31c69643bf61f8250063759b7c9403f7061aba42b8505a";
	
	@Test(enabled = false)
	public void getStatus() {
		given().get("https://simple-books-api.glitch.me/status").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void listOfBooks() {
		given().get("https://simple-books-api.glitch.me/books").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void singleBook() {
		given().get("https://simple-books-api.glitch.me/books/3").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void authenticationAPI() {
		JSONObject jo = new JSONObject();
		jo.put("clientName", "Postman");
		jo.put("clientEmail", "valentin122@example.com");
		given().body(jo.toJSONString()).header("Content-Type", "application/JSON").when().post("https://simple-books-api.glitch.me/api-clients/").then().log().all();       
	}
	
	@Test(enabled = false)
	public void submitOrder() {
		JSONObject js = new JSONObject();
		js.put("bookId", 1);
		js.put("customerName", "John");
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(js.toJSONString()).when()
		.post("https://simple-books-api.glitch.me/orders/").then().log().all();
	}
	
	@Test(enabled = false)
	public void getAllOrder() {
		given().header("Authorization", "Bearer " + accessToken).get("https://simple-books-api.glitch.me/orders").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void getAnOrder() {
		given().header("Authorization", "Bearer " + accessToken).get("https://simple-books-api.glitch.me/orders/CmKCX0OEMZKu0IJ9q0gY1").then().statusCode(404).log().all();
	}
	
	@Test(enabled = false)
	public void updateOrder() {
		JSONObject obj = new JSONObject();
		obj.put("customerName", "Sourabh");
		given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(obj.toJSONString()).when().patch("https://simple-books-api.glitch.me/orders/CmKCX0OEMZKu0IJ9q0gY1")
		.then().statusCode(204).log().all();
	}
	
	@Test(enabled = false)
	public void delete() {
		given().header("Authorization", "Bearer " + accessToken).delete("https://simple-books-api.glitch.me/orders/CmKCX0OEMZKu0IJ9q0gY1").then().log().all();
	}
	
}




















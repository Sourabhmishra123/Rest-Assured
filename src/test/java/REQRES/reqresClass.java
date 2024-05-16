package REQRES;

import org.testng.Assert;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class reqresClass {
	
	@Test(enabled = false)
	public void listUsers() {
		 Response rep = given().get("https://reqres.in/api/users?page=2");
		 int statusCode = rep.getStatusCode();
		 Assert.assertEquals(statusCode, 200);
	}
	
	@Test(enabled = false)
	public void singleUser() {
		given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void singleUserNotFound() {
		given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
	}
	@Test(enabled = false)
	public void listResource() {
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void singleResource() {
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void singleResourceNotFound() {
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
	}
	@Test(enabled = false)
	public void createUser() {
		JSONObject js = new JSONObject();
		js.put("name", "morpheus");
		js.put("job", "leader");
		
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	@Test(enabled = false)
	public void updateUser() {
		JSONObject js = new JSONObject();
		js.put("name", "Sourabh");
		js.put("job", "SDET");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();       
	}
	@Test(enabled = false)
	public void update2User() {
		JSONObject js = new JSONObject();
		js.put("name", "Sourabh");
		js.put("job", "SDET");
		given().body(js.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();       
	}
	@Test(enabled = false)
	public void deleteUser() {
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	@Test(enabled = false)
	public void createNewUser() {
		JSONObject js = new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void createNewUserUnsuccess() {
		JSONObject js = new JSONObject();
		js.put( "email", "sydney@fife");
		
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
	}
	@Test(enabled = false)
	public void loginUser1() {
		JSONObject js = new JSONObject();
		js.put("email", "abcde123@gm");
		js.put("password", "abcdef");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void loginUnsucess1(){
		JSONObject js = new JSONObject();
		js.put(  "email", "peter@klaven");
	
		given().body(js.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
	}
	@Test(enabled = true)
	public void delayedDetails() {
		given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
	}
}








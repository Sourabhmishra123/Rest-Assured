package Dummy_Rest_API;

import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class restAPI {
	@Test(enabled = false)
	public void Get_all_employee_data() {
		given().get("https://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void Get_single_employee_data() {
		given().get("https://dummy.restapiexample.com/api/v1/employee/1").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void create_new_record() {
		JSONObject js = new JSONObject();
		js.put("name", "test");
		js.put("salary", "123");
		js.put("age", "23");
		given().body(js.toJSONString()).when().post("https://dummy.restapiexample.com/api/v1/create").then().log().all();
	}
	
	@Test(enabled = false)
	public void updateEmployeeRecord() {
		JSONObject js = new JSONObject();
		js.put("name", "Sourabh");
		js.put("salary", "12453");
		js.put("age", "22");
		given().body(js.toJSONString()).when().put("https://dummy.restapiexample.com/api/v1/update/21/").then().log().all();
	}
	
	@Test(enabled = true)
	public void delete() {
		given().delete("https://dummy.restapiexample.com/api/v1/delete/2/").then().log().all();
	}
}

package github;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class github {
	
	@Test
	public void createRepo() {
		JSONObject js = new JSONObject();
		js.put("name", "Rest-Assured");
		js.put("description", "This is your first repo!");
		js.put("homepage", "https://github.com");
		js.put("private" , false);
		js.put("is_template", true);
		given().auth().oauth2("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").header("Content-Type" , "application/JSON")
		.body(js.toJSONString()).post("https://api.github.com/user/repos").then().statusCode(201).log().all();
	}
}

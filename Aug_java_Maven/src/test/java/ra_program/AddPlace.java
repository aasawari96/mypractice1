package ra_program;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Payload;
import io.restassured.RestAssured;

public class AddPlace {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").body(Payload.addPlace()).when()
				.post("maps/api/place/add/json").then().log().all().statusCode(200).body("status", equalTo("OK"))
				.body("scope", equalTo("APP"));

	}

}

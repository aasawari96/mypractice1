package ra_program;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class AddPlace1 {

	public static void main(String[] args) {
		/**
		 * Given : All the input details. When : Submit the API (include resources and
		 * methods). Then : Validate the response/use for validation
		 */
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123")
				.body("{\r\n" + "    \"location\": {\r\n" + "        \"lat\": -20.383494,\r\n"
						+ "        \"lng\": 40.427362\r\n" + "    },\r\n" + "    \"accuracy\": 100,\r\n"
						+ "    \"name\": \"GSIT Office\",\r\n" + "    \"phone_number\": \"(+91) 983 893 3333\",\r\n"
						+ "    \"address\": \"GrowSkillIT, Pune\",\r\n" + "    \"types\": [\r\n"
						+ "        \"Office\"\r\n" + "    ],\r\n" + "    \"website\": \"http://www.gsit.com\",\r\n"
						+ "    \"language\": \"English-IN\"\r\n" + "}")
				.when().post("maps/api/place/add/json").then().log().all().statusCode(200);

	}

}

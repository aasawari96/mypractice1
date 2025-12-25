package ra_program;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddAndUpdate {

	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		System.out.println("**********Add Palce*******");
		String response = given().log().all().queryParam("key", "qaclick123").body(Payload.addPlace()).when()
				.post("maps/api/place/add/json").then().log().all().statusCode(200).body("status", equalTo("OK"))
				.body("scope", equalTo("APP")).extract().asString();

		JsonPath js = new JsonPath(response); // Parse into JSON

//		String scp = js.getString("scope");
//		System.out.println(scp);

		String pid = js.getString("place_id");
		System.out.println(pid);

		System.out.println("**********Update Palce*******");
		// Update API

		String newAdd = "GrowskillIT Mumbai";
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", pid)
				.body("{\r\n" + "\"place_id\":\"" + pid + "\",\r\n" + "\"address\":\"" + newAdd + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		System.out.println("**********GET Palce*******");
		// Get Place
		String getPlaceAPIResponse = given().log().all().queryParam("place_id", pid).queryParam("key", "qaclick123")
				.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract()
				.asString();

		// JsonPath js1 = ResusableMethod.rawToJson(getPlaceAPIResponse);
		JsonPath js1 = ReusableMethod.rawToJson(getPlaceAPIResponse);
		// String actualAdd = js1.getString("address");
		String actualAdd = js1.getString("address");
		System.out.println(actualAdd);
		String actAccuracy = js1.getString("accuracy");
		String actName = js1.getString("name");

		Assert.assertEquals(actualAdd, newAdd);
		Assert.assertEquals(actAccuracy, "100");
		Assert.assertEquals(actName, "GSIT Office");

	}

}

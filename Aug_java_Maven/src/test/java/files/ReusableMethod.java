package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static JsonPath rawToJson(String res) {
		JsonPath js = new JsonPath(res);
		return js;
	}
}

package RequestMethods;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PutMethod {

	public static void main(String[] args) {

		// Step 1 : Declare base URL.
				RestAssured.baseURI="https://reqres.in/";
				
				// Step 2: Configure request body.
				String requestBody="{\r\n"
						+ "    \"addressline\": \"west10thstreet\",\r\n"
						+ "    \"state\": \"PA\"\r\n"
						+ "}";

				// Step 3 : Fetch the status code
				int Statuscode=given().header("Content-Type","application/json").body(requestBody).when().put("/api/users/2").then().extract().response().statusCode();
				System.out.println(Statuscode);
				
				// Step 4 : Configure response body.
				String responseBody=given().header("Content-Type","application/json").body(requestBody).when().put("/api/users/2").then().extract().response().asString();
				System.out.println(responseBody);
				
				// Step 5 : Configure request body params.
				JsonPath jspreq=new JsonPath(requestBody);
				String req_addressline=jspreq.getString("addressline");
				String req_state=jspreq.getString("state");
				
				// Step 6: Extract date in expected format.
				String expDate=LocalDateTime.now().toString().substring(0,10);
				
				//Step 6 : Configure response body params.
				JsonPath jspres=new JsonPath(responseBody);
				String res_addressline=jspres.getString("addressline");
				String res_state=jspres.getString("state");
				String res_updatedAt=jspres.getString("updatedAt").substring(0,10);
				
				// Step 7 : Validate response body.
				Assert.assertEquals(res_addressline, req_addressline);
				Assert.assertEquals(res_state, req_state);
				Assert.assertEquals(res_updatedAt, expDate);
				
				System.out.println("Put request validated successfully");
		
	}

}

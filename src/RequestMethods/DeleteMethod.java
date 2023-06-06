package RequestMethods;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.RestAssured;


public class DeleteMethod {

	public static void main(String[] args) {
		
		// Step 1 : Declare base URL.
				RestAssured.baseURI="https://reqres.in/";
				
				// Step 2 : Fetch the status code
				int Statuscode=given().header("Content-Type","application/json").when().delete("/api/users/2").then().extract().response().statusCode();
				System.out.println(Statuscode);
				
				Assert.assertEquals(Statuscode, 204);
				
				System.out.println("Delete request validated successfully");

	}

}

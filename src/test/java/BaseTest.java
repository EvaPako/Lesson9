import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class BaseTest {

    public static RequestSpecification baseSpecificationBefore(){
        RequestSpecification requestSpecification = given()
            .baseUri("https://postman-echo.com/")
                .header("cookie", "sails.sid=s%3APXHN5mD2WkbF25Okv-Nc5g7j58Cm_3Rh.xQLAzKbrjotaVT1c%2FgP9nmCgvsA0Zg4AbjQo38ZofXQ");
            return requestSpecification;
    }

    public static ResponseSpecification baseSpecificationAfter200 () {
        ResponseSpecification responseSpecification = expect().statusCode (200);
        return responseSpecification;
    }

    public static ResponseSpecification baseSpecificationAfter201 () {
        ResponseSpecification responseSpecification = expect().statusCode (201);
        return responseSpecification;
    }
}

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class EchoTest {

    @Test
    public void GetRequest () {
        // Ожидаемые значения
        HashMap <String,String> headers = new HashMap<>();
        headers.put ("host","postman-echo.com");
        headers.put ("x_request_start", "t1744653162.807");
        headers.put ("connection", "close");
        headers.put ("x_forwarded_proto", "https");
        headers.put ("user_agent","Apache-HttpClient/4.5.13 (Java/11.0.2)");
        headers.put ("accept","*/*");
        headers.put ("cookie","sails.sid=s%3APXHN5mD2WkbF25Okv-Nc5g7j58Cm_3Rh.xQLAzKbrjotaVT1c%2FgP9nmCgvsA0Zg4AbjQo38ZofXQ");

        given()
                .spec(BaseTest.baseSpecificationBefore())
                .when().get("get") // Замените на ваш эндпоинт
                .then()
                //.log().body()
                .body("headers.host", equalTo(headers.get("host")))
                .body("headers.connection", equalTo(headers.get("connection")))
                .body("headers.x_forwarded_port", equalTo(headers.get("x_forwarded_port")))
                .body("headers.x_amzn_trace_id", equalTo(headers.get("x_amzn_trace_id")))
                .body("headers.accept", equalTo(headers.get("accept")))
                //.log().all()
                .spec(BaseTest.baseSpecificationAfter200());

        }
        @Test
        public void postRawText() {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("test", "value");
            String jsonString = jsonObject.toString();

            given()
                    .spec(BaseTest.baseSpecificationBefore())
                    .body(jsonString)
                    .when().post("post")
                    .then()
                    //.log().body()
                    .body("data", equalTo(jsonString))
                    .body("url", equalTo("https://postman-echo.com/post"))
                    .spec(BaseTest.baseSpecificationAfter200());
    }

    @Test
    public void postFormData() {
        HashMap <String,String> testData = new HashMap<>();
        testData.put ("foo1","bar1");
        testData.put ("foo2","bar2");
        String testDataString = testData.toString();

        given()
                .spec(BaseTest.baseSpecificationBefore())
                .body(testDataString)
                .when().post("post")
                .then()
                //.log().body()
                .body("data", equalTo(testDataString))
                .body("url", equalTo("https://postman-echo.com/post"))
                .spec(BaseTest.baseSpecificationAfter200());
    }

    @Test
    public void putRequest () {
        given()
                .spec(BaseTest.baseSpecificationBefore())
                .expect()
                .spec(BaseTest.baseSpecificationAfter200()).log().all();
    }


    @Test
    public void patchRequest () {
        given()
                .spec(BaseTest.baseSpecificationBefore())
                .expect()
                .spec(BaseTest.baseSpecificationAfter200()).log().all();
    }
    @Test
    public void deleteRequest () {
        given()
                .spec(BaseTest.baseSpecificationBefore())
                .expect()
                .spec(BaseTest.baseSpecificationAfter200()).log().all();
    }

    }


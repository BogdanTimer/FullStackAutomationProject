package Extentions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps {
    @Step("Get JSON info from server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Get specific info about specific student")
    public static String getSpecificValue(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Get whole info about one student")
    public static String printOneStudentWholeData(String id) {
        response = httpRequest.get("/student/" + id);
        return response.prettyPrint();
    }

    @Step("Send data to server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        System.out.println(response.prettyPrint());
    }

    @Step("Update full data in server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        System.out.println(response.prettyPrint());
    }

    @Step("Delete data from server")
    public static void delete(String id) {
        response = httpRequest.delete("student/" + id);
        System.out.println(response.getBody().asString());
    }

}

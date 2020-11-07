package WorkFlows;

import Extentions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps {


    @Step("Get student data")
    public static String getStudentData(String jpath) {

        Response response = apiActions.get("/student/list");
        return apiActions.getSpecificValue(response, jpath);
    }

    @Step("Create student")
    public static void createStudent(String name, String lastname, String email, String programme) {

        requestParams.put("firstName", name);
        requestParams.put("lastName", lastname);
        requestParams.put("email", email);
        requestParams.put("programme", programme);
        apiActions.post(requestParams, "/student");
    }

    @Step("Update student full info")
    public static void updateStudent(String name, String lastname, String email, String programme, String id) {

        requestParams.put("firstName", name);
        requestParams.put("lastName", lastname);
        requestParams.put("email", email);
        requestParams.put("programme", programme);
        apiActions.put(requestParams, "/student/" + id);
    }
}
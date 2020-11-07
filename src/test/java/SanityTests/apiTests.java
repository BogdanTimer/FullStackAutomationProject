package SanityTests;

import Extentions.apiActions;
import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class apiTests extends commonOps {
    @Test(description = "Test 01: Get Specific Info About One Student")
    @Description("Test Description: Get Specific Info About One Student")
    public void test01_getSpecificInfoOneStudent() {
        verifications.verifyText(apiFlows.getStudentData("[0].firstName"), "Vernon");
    }

    @Test(description = "Test 02: Get Full Info About One Student")
    @Description("Test Description: Get Full Info About One Student")
    public void test02_getFullInfoOneStudent() {
        apiActions.printOneStudentWholeData("1");
    }

    @Test(description = "Test 03: Create student")
    @Description("Test Description: Create student")
    public void test03_createStudent() {
        apiFlows.createStudent("kaka", "koko", "kuku@keke.com", "kiki");
        verifications.verifyText(apiFlows.getStudentData("[92].firstName"), "kaka");
    }

    @Test(description = "Test 04: Update student")
    @Description("Test Description: Update student")
    public void test04_updateStudent() {
        apiFlows.updateStudent("ABC", "ABC", "ABC@ABC.com", "ABC","111");
        verifications.verifyText(apiFlows.getStudentData("[92].firstName"), "ABC");
    }

    @Test(description = "Test 05: Delete student")
    @Description("Test Description: Delete student")
    public void test05_deleteStudent() {
        apiActions.delete("111");
        verifications.verifyDeletedStudent();
    }
}

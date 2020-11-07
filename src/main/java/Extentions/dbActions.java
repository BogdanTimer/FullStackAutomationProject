package Extentions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;


public class dbActions extends commonOps {
    @Step("Retrieve credential from database")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("Error occurred while retrieving data from DB, see details: " + e);
        }
        return credentials;
    }
}

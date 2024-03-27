package sprint.project.crm.db;

import sprint.project.crm.model.Requests;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:2003/crm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static Requests getRequest(String courseName) {
//        courseName.equals("amdska");
//    }
}

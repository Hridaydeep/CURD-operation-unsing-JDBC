package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations {
    public static void fetchData(ResultSet resultSet) throws SQLException {
        System.out.println("***********STUDENTS DETAILS****************");
        while(resultSet.next()){
            System.out.println("Student");
            System.out.println("Student id: "+resultSet.getInt("idStudent"));
            System.out.println("Student name: "+resultSet.getString("StdName"));
            System.out.println("Student email: "+resultSet.getString("Email"));
            System.out.println("Student phone: "+resultSet.getString("Phone"));
            System.out.println("-----------------------------------------------");
        }
    }
}

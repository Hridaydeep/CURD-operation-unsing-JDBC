package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApplication {
    public static void main(String args[]){
      String url="jdbc:mysql://localhost:3306/db1_student";
      String username="root";
      String password="DC2017bte@0059";
      try{ //use try catch for db interaction
          //load and register
          //Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection= DriverManager.getConnection(url,username,password);
          Statement statement=connection.createStatement();
          Scanner sc= new Scanner(System.in);
          System.out.println("Enter 1 for insert(Create) data: \n" +
                  "Enter 2 for bulk insert(Create) data: \n" +
                  "Enter 3 for fetch(READ) data: \n" +
                  "Enter 4 to modify(UPDATE) data: \n" +
                  "Enter 5 for delete data");

          //execute,executeQuery,executeUpdate
          int choice=sc.nextInt();
          switch(choice){
              case 1: // C-CREATE operation
                  ResultSet fetchMaxID=statement.executeQuery("Select Max(idStudent) from student");
                  Create.Insert(fetchMaxID, statement);
                  break;
              case 2: // Bulk create operation
                  ResultSet ID=statement.executeQuery("Select Max(idStudent) from student");
                  Create.InsertBulk(ID, statement);
                  break;
              case 3: // R-READ operation
                 /* ResultSet fetchData=statement.executeQuery("SELECT * from student");
                  Operations.fetchData(fetchData);*/
                  break;

              case 4: //U- UPDATE operation
                  break;
              case 5: //D- Delete operation
                  /*System.out.println("Enter the student id:");
                  int del_id=sc.nextInt();
                  int RowCnt=statement.executeUpdate("delete from student where idStudent="+del_id);
                  if(RowCnt>0){
                      System.out.println("Student with id["+del_id+"] has been deleted");
                  }
                  else{
                      System.out.println("Invalid Student id");
                  }*/
                  break;
              default:
                  System.out.println("Enter valid input");
                  break;
          }

      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
//lets run the code
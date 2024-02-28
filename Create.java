package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
    public static void Insert(ResultSet fetchMaxID, Statement statement) throws SQLException {
        //single data insertion
        int id=-1;
        if(fetchMaxID.next()){
            id=fetchMaxID.getInt("Max(idStudent)");
            System.out.println("Max Student id: "+id);
            id++;
        }
        Scanner sc= new Scanner(System.in);
        //user input 51:48
        System.out.println("Enter student's name");
        //sc.nextLine();
        String name=sc.next();
        sc.nextLine();
        System.out.println("Enter Student's email ID:");
        String email=sc.next();
        sc.nextLine();
        System.out.println("Enter Student's phone Number: ");
        String number= sc.next();

        int rowCnt = statement.executeUpdate("insert into student value("+id+",'"+name+"','"+email+"','"+number+"')");
        if(rowCnt>0){
            System.out.println("Data inserted Successfully with id as: "+id);
        }
        else{
            System.out.println("Failed to insert data");
        }
    }

    public static void InsertBulk(ResultSet fetchMaxID, Statement statement) throws SQLException {
        //bulk insertion of data at a time
        int id=-1;
        if(fetchMaxID.next()){
            id=fetchMaxID.getInt("Max(idStudent)");
            System.out.println("Max Student id: "+id);
            id++;
        }
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of data you want to enter");
        int rows=sc.nextInt();
        Object obj[][]= new Object[rows][4];
        for(int i=0;i<rows;i++){
            //user input 51:48
            System.out.println("You are entering the data number: "+(i+1));
            obj[i][0]=id++;
            System.out.println("Enter student's name");
            //sc.nextLine();
            obj[i][1]=sc.next();
            sc.nextLine();
            System.out.println("Enter Student's email ID:");
            obj[i][2]=sc.next();
            sc.nextLine();
            System.out.println("Enter Student's phone Number: ");
            obj[i][3]= sc.next();
        }
        int fail=0;
        for(int i=0;i<rows;i++) {
            int rowCnt = statement.executeUpdate("insert into student value(" + obj[i][0] + ",'" + obj[i][1] + "','" + obj[i][2] + "','" + obj[i][3] + "')");
            if (rowCnt == 0) {
                System.out.println("Failed to insert data of the sudent name: " + obj[i][1]);
                fail++;
            }
        }
        System.out.println((rows-fail)+" numbers of Student data have uploaded  Successfully"); //print the number of successful updates

    }
}

package com.stackroute;

import com.stackroute.model.Salesrep;
import com.stackroute.service.SalesrepService;
import com.stackroute.service.SalesrepServiceImpl;

import java.sql.*;
import java.util.Scanner;

/*

+register the mysql driver class
+create connection (session w database)
+create statement object with the sql query to execute
+actually execute query and handle result
+close the resources (statement and connection)

 */

public class SalesrepApp
{
    public static void main( String[] args ) {
        System.out.println("JDBC Demo -- Salesrep App");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");

        Scanner scanner = new Scanner(System.in);
        //salesrepimpl reference
        SalesrepService salesrepService = new SalesrepServiceImpl();
        int option;

        do {
            System.out.println("1. Print Salesrep Count");
            System.out.println("2. Show Salesreps");
            System.out.println("3. Show Salesrep By Rep_Id");
            System.out.println("4. Add New Salesrep");

            System.out.println("Enter the option:");

            option = scanner.nextInt();
        switch (option){
            case 1:
                try {
                    System.out.println(salesrepService.findSalesrepCount());
                } catch (SQLException e) {
                    System.out.println("Database Operation Fails");
                }
                break;
            case 2:
                try {
                    for(Salesrep salesrep:salesrepService.findAllSalesreps()){
                        System.out.println(salesrep);
                    }
                } catch (SQLException e) {
                    System.out.println("Database Operation Fails");
                }
                break;
            case 3:
                System.out.println("Enter Rep_Id");
                int repId = scanner.nextInt();
                try {
                    System.out.println(salesrepService.findSalesrepById(repId));
                } catch (SQLException e) {
                    System.out.println("Salesrep Not Found");
                }
                break;
            case 4:
                System.out.println("Enter Salesrep Details");
                int id = scanner.nextInt();
                String name = scanner.next();
                String city = scanner.next();
                double comm = scanner.nextDouble();
                Salesrep salesrep = new Salesrep(id, name, city, comm);
                try {
                    salesrepService.addNewSalesrep(salesrep);
                    System.out.println(name + " was added successfully");
                } catch (SQLException e) {
                    System.out.println("Unable to Add Salesrep");
                }
                break;
            default:
                System.out.println("Enter Valid Option");
                break;
        }
            System.out.println("Do you want to continue? Press 0 or 1");;
        }while(scanner.nextInt() == 1);
        scanner.close();
    }

}

 /*

    +execute --> generic, can technically execute both, but returns boolean corresponding to whether the query is returning data or not
    +executeQuery --> used for select queries that return data from db
    +executeUpdate --> used for query that updates/inserts/deletes, does not return any data

    +executeBatch/largeBatch --> more complex

*/

//INITIAL WALK-THROUGH PROCESS (not separating db logic from core logic)
/*
package com.stackroute;

import java.sql.*;



+register the mysql driver class
+create connection (session w database)
+create statement object with the sql query to execute
+actually execute query and handle result
+close the resources (statement and connection)


public class App
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        System.out.println( "JDBC Demo" );
        System.out.println("^^^^^^^^^^^");

        //what is corresponding driver class?
        //found in external lib -> mysql connector -> com.sql -> cj -> jdbc -> driver -> copy reference
        Class.forName("com.mysql.cj.jdbc.Driver");

        String databaseUrl = "jdbc:mysql://localhost:3306/cgiusdb";
        String userName = "roger";
        String password = "00Opye60";

        //create connection object (between db app) (hover over errors to throw two exceptions)
        Connection connection = DriverManager.getConnection(databaseUrl, userName, password);

        //create statement object, only select query returns data
        //insert, update, delete do not return data, returns rows effected/changes
        String query = "select * from sales_rep";
        //execute statement
        Statement statement = connection.createStatement();
        ResultSet recordsInReturnedSet = statement.executeQuery(query); //return resultSet, each record as item in set
        //while there are still records present, (t/f),
        while(recordsInReturnedSet.next()){
            System.out.println(recordsInReturnedSet.getInt("rep_id"));
        }

        //close all resources
        recordsInReturnedSet.close();
        statement.close(); //cl
        connection.close(); //closing driver and connection

    }
 */

//----------------------------------------------------------------------------------

//SEPARATE DB LOGIC FROM CORE LOGIC --> moved to external class/package
//Need to map relation to object, in this case sales_rep <--> Sales Rep Object
    //sales_rep <--> Sales Rep Object
    //name (varchar) <--> name (String)

//Hibernate takes care of object relational mapping

/*
create driver manager using url, user, pass
two statements preparedStatement or createStatement

LOW LEVEL OVERVIEW
--> Driver, DriverManager, Connection, Statement, PreparedStatement
--> execute(), executeQuery(), executeUpdate()
 */


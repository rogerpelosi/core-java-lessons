package com.stackroute.repository;

import com.stackroute.model.Salesrep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesrepRepositoryImpl implements SalesrepRepository{

    //create connection and close connection in addition to interface methods
    private String url;
    private String username;
    private String password;
    private Connection connection;

    //we get the values in the service when we implement the sales repo
    public SalesrepRepositoryImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private void connect() throws SQLException{
        try{Class.forName("com.mysql.cj.jdbc.Driver");}
        catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        this.connection = DriverManager.getConnection(url, username, password);

    }
    private void disconnect() throws SQLException {
        this.connection.close();
    }

    @Override
    public List<Salesrep> getAllSalesreps() throws SQLException{
        connect();
        //specifies table to pull from
        String query = "select * from salesrep";
        //execute statement
        Statement statement = connection.createStatement();
        ResultSet recordsInReturnedSet = statement.executeQuery(query); //return resultSet, each record as item in set
        List<Salesrep> salesreps = new ArrayList<>();
        //while there are still records present, (t/f),
        while(recordsInReturnedSet.next()){
            int rep_id = recordsInReturnedSet.getInt("rep_id");
            String name = recordsInReturnedSet.getString("name");
            String city = recordsInReturnedSet.getString("city");
            double commission = recordsInReturnedSet.getDouble("commission");
            Salesrep salesrep = new Salesrep(rep_id, name, city, commission);
            salesreps.add(salesrep);
        }

        //close all resources
        recordsInReturnedSet.close();
        statement.close();
        disconnect();
        return salesreps;
    }

    @Override
    public Salesrep getSalesrepById(int rep_id) throws SQLException {
        connect();
        //specifies table to pull from with ? as var placeholder
        String query = "select * from salesrep where rep_id=?";
        //prepared statement, before executing, must give parameter to query
        PreparedStatement statement = connection.prepareStatement(query);
        //index one refers to 1st ? parameter, if multiple ?then many indexes
        statement.setInt(1,rep_id);
        //boolean status = statement.execute();

        ResultSet recordsInReturnedSet = statement.executeQuery(); //return resultSet, each record as item in set
        //while there are still records present, (t/f),
        recordsInReturnedSet.next();
        int rep_idO = recordsInReturnedSet.getInt("rep_id");
        String name = recordsInReturnedSet.getString("name");
        String city = recordsInReturnedSet.getString("city");
        double commission = recordsInReturnedSet.getDouble("commission");
        Salesrep salesrep = new Salesrep(rep_idO, name, city, commission);


        //close all resources
        recordsInReturnedSet.close();
        statement.close();
        disconnect();
        return salesrep;
    }

    @Override
    public boolean addNewSalesrep(Salesrep salesrep) throws SQLException {
        connect();
        String query = "insert into salesrep values(?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, salesrep.getRep_id());
        statement.setString(2, salesrep.getName());
        statement.setString(3, salesrep.getCity());
        statement.setDouble(4, salesrep.getCommission());
        int rowsAffected = statement.executeUpdate();

        statement.close();
        disconnect();

        if(rowsAffected > 0){return true;}
        return false;
    }

    @Override
    public boolean updateSalesrep(Salesrep salesrep) {
        return false;
    }

    @Override
    public boolean deleteSalesrep(int id) {
        return false;
    }
}

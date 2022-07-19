package com.stackroute.service;

import com.stackroute.model.Salesrep;
import com.stackroute.repository.SalesrepRepository;
import com.stackroute.repository.SalesrepRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class SalesrepServiceImpl implements SalesrepService{

    private SalesrepRepository salesrepRepository;

    //uses repo to read db and perform operations
    public SalesrepServiceImpl(){
        //specifies which database and user, etc. which is taken by repo impl
        String url = "jdbc:mysql://localhost:3306/cgiusdb";
        String username = "roger";
        String password = "00Opye60";
        this.salesrepRepository = new SalesrepRepositoryImpl(url, username, password);
    }
    @Override
    public int findSalesrepCount() throws SQLException {
        List<Salesrep> salesreps = salesrepRepository.getAllSalesreps();
        return salesreps.size();
    }

    @Override
    public List<Salesrep> findAllSalesreps() throws SQLException {
        return salesrepRepository.getAllSalesreps();
    }

    @Override
    public Salesrep findSalesrepById(int rep_id) throws SQLException {
        return salesrepRepository.getSalesrepById(rep_id);
    }

    @Override
    public boolean addNewSalesrep(Salesrep salesrep) throws SQLException {
        return salesrepRepository.addNewSalesrep(salesrep);
    }
}

package com.stackroute.service;

import com.stackroute.model.Salesrep;

import java.sql.SQLException;
import java.util.List;

public interface SalesrepService {

    int findSalesrepCount() throws SQLException;
    List<Salesrep> findAllSalesreps() throws SQLException;

    Salesrep findSalesrepById(int rep_id) throws SQLException;

    boolean addNewSalesrep(Salesrep salesrep) throws SQLException;
}

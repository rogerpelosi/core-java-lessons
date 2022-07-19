package com.stackroute.repository;

import com.stackroute.model.Salesrep;

import java.sql.SQLException;
import java.util.List;

//specify operations for impl
public interface SalesrepRepository {

    List<Salesrep> getAllSalesreps() throws SQLException;
    Salesrep getSalesrepById(int rep_id) throws SQLException;
    boolean addNewSalesrep(Salesrep salesrep) throws SQLException;
    boolean updateSalesrep(Salesrep salesrep) throws SQLException;
    boolean deleteSalesrep(int id) throws SQLException;

}

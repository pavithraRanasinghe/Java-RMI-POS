/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Customer;

/**
 *
 * @author PAVITHRA
 */
public class CustomerDAOImpl implements CustomerDAO{
    
    private Connection connection;
    
    public boolean add(Customer customer) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",connection, customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());
    }
    public boolean update(Customer customer) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("UPDATE customer SET cid=?,name=?,address=?,salary=? where cid=?",connection, customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());
    }
    public boolean delete(String id) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("DELETE FROM customer WHERE cid=?",connection, id);
    }
    public Customer search(String id) throws ClassNotFoundException, SQLException{
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE cid=?",connection, id); 
        if (rst.next()) {            
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
        }
        return null;
    }
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException{
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer",connection);
        ArrayList<Customer> arrayList = new ArrayList<>();
        while (rst.next()) {            
            arrayList.add(new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
        }
        return arrayList;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }
}

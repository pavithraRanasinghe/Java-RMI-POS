/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public class QueryDAOImpl implements QueryDAO{

    private Connection connection;
    
    @Override
    public ArrayList<CustomEntity> getAllCustomerItemDetails() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer,item",connection);
        ArrayList<CustomEntity> arrayList = new ArrayList<>();
        while (rst.next()) {            
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            double salary = rst.getDouble(4);
            String code = rst.getString(5);
            String description = rst.getString(6);
            int qty = rst.getInt(7);
            double price = rst.getDouble(8);
            
            arrayList.add(new CustomEntity(id, name, address, salary, code, description, qty, price));
        }
        return arrayList;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }
    
}

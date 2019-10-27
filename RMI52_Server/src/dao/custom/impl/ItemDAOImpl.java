/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Item;
import java.sql.Connection;

/**
 *
 * @author PAVITHRA
 */
public class ItemDAOImpl implements ItemDAO{
    
    private Connection connection;
    
    public boolean add(Item item) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("INSERT INTO item VALUES(?,?,?,?)",connection, item.getCode(),item.getDescription(),item.getQty(),item.getPrice());
    }
    public boolean delete(String code) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("DELETE FROM item WHERE cid=?",connection, code);
    }
    public boolean update(Item item) throws ClassNotFoundException, SQLException{
        return CrudUtil.execute("UPDATE item SET code=?,name=?,qty=?,price=? where code=?",connection, item.getCode(),item.getDescription(),item.getQty(),item.getPrice(),item.getCode());
    }
    public Item search(String code) throws ClassNotFoundException, SQLException{
        ResultSet rst = CrudUtil.execute("SELECT * FROM item WHERE code=?",connection, code); 
        if (rst.next()) {            
            return new Item(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4));
        }
        return null;
    }
    public ArrayList getAll() throws ClassNotFoundException, SQLException{
        ResultSet rst = CrudUtil.execute("SELECT * FROM item",connection);
        ArrayList<Item> arrayList = new ArrayList<>();
        while (rst.next()) {            
            arrayList.add(new Item(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
        }
        return arrayList;
    }    

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author PAVITHRA
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private BasicDataSource bds;
    
    public DBConnection() throws ClassNotFoundException, SQLException{
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/rmi");
        bds.setUsername("root");
        bds.setPassword("1234");
        bds.setInitialSize(2);
        bds.setMaxTotal(2);
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    public Connection getConnection() throws SQLException{
        return bds.getConnection();
    }
}

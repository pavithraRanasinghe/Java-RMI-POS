/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public interface CustomerBO extends SuperBO{

    public boolean addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException,Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException,Exception;

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException,Exception;

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException,Exception;

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException,Exception;
}

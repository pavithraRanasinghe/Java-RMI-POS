/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import service.custom.CustomerService;

/**
 *
 * @author PAVITHRA
 */
public class CustomerController {

   CustomerService customerService = ProxyHandler.getInstance().getCustomer();
   
    public boolean addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        return customerService.addCustomer(customerDTO);
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException,Exception {
        return customerService.updateCustomer(customerDTO);
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return customerService.deleteCustomer(id);
    }

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return customerService.searchCustomer(id);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        return customerService.getAllCustomer();
    }
}

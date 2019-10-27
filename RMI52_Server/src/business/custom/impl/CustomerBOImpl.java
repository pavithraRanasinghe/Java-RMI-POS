/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.CustomerDAO;
import db.DBConnection;
import dto.CustomerDTO;
import entity.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    public CustomerBOImpl() {

    }

    public boolean addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            customerDAO.setConnection(connection);
            return customerDAO.add(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getSalary()));
        }
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            customerDAO.setConnection(connection);
            return customerDAO.update(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getSalary()));
        }
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            customerDAO.setConnection(connection);
            return customerDAO.delete(id);
        }
    }

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            customerDAO.setConnection(connection);
            Customer customer = customerDAO.search(id);
            return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
        }
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            customerDAO.setConnection(connection);
            ArrayList<Customer> allList = customerDAO.getAll();
            ArrayList<CustomerDTO> list = new ArrayList<>();
            for (Customer customer : allList) {
                list.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
            }
            return list;
        }
    }
}

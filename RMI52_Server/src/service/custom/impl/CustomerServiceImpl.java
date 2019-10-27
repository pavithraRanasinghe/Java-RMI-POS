/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import service.custom.CustomerService;
import business.BOFactory;
import business.BOTypes;
import business.custom.CustomerBO;
import dto.CustomerDTO;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import reserve.impl.ReservationImpl;

/**
 *
 * @author PAVITHRA
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    private static ArrayList<Observer> allCustomers = new ArrayList<>();
    private static ReservationImpl<CustomerService> customerReservation = new ReservationImpl<CustomerService>();

    public CustomerServiceImpl() throws Exception {

    }

    public boolean addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        boolean addCustomer = customerBO.addCustomer(customerDTO);
        if (addCustomer) {
            notifyAllObeser(customerDTO.getId() + " was added..!");
            return true;
        }
        return false;
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException, Exception {
        boolean updateCustomer = customerBO.updateCustomer(customerDTO);
        if (updateCustomer) {
            notifyAllObeser(customerDTO.getId() + " was updated..!");
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        boolean deleteCustomer = customerBO.deleteCustomer(id);
        if (deleteCustomer) {
            notifyAllObeser(id + " was deleted..!");
            return true;
        }
        return false;
    }

    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return customerBO.searchCustomer(id);
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException, Exception {
        return customerBO.getAllCustomer();
    }

    @Override
    public void registerObeser(Observer ob) throws Exception {
        allCustomers.add(ob);
    }

    @Override
    public void removeObeser(Observer ob) throws Exception {
        allCustomers.remove(ob);
    }

    @Override
    public void notifyAllObeser(String message) throws Exception {
        for (Observer ob : allCustomers) {
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        ob.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ).start();
        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
        return customerReservation.reserve(key, this);
    }

    @Override
    public boolean release(Object key) throws Exception {
        return customerReservation.release(key, this);
    }
}

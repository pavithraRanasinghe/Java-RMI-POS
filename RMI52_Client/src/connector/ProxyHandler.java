/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.RemoteServiceFactory;
import service.RemoteServiceFactory.ServiceType;
import service.custom.CustomerService;
import service.custom.ItemService;

/**
 *
 * @author PAVITHRA
 */
public class ProxyHandler{
    
    private static ProxyHandler proxyHandler;
    private CustomerService customerService;
    private ItemService itemService;

    public ProxyHandler() {
        try {
            RemoteServiceFactory lookup = (RemoteServiceFactory) Naming.lookup("rmi://localhost:5050/POS");
            customerService = (CustomerService) lookup.getService(ServiceType.CSUTOMER);
            itemService = (ItemService) lookup.getService(ServiceType.ITEM);
            
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance(){
        return (proxyHandler == null)?(proxyHandler = new ProxyHandler()):proxyHandler;
    }
    
    public CustomerService getCustomer(){
        return customerService;
    }
    public ItemService getItem(){
        return itemService;
    }
}

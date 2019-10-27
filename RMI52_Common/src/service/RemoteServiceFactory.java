/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;

/**
 *
 * @author PAVITHRA
 */
public interface RemoteServiceFactory extends Remote{
    
    public enum ServiceType {
        CSUTOMER, ITEM;
    }
        public SuperService getService(ServiceType serviceType)throws Exception;
}

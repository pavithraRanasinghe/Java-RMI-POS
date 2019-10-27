/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import business.BOFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.impl.ServiceFactoryImpl;

/**
 *
 * @author PAVITHRA
 */
public class StartServer {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(5050);
            reg.rebind("POS", ServiceFactoryImpl.getInstance());
            System.out.println("Server started");
        } catch (RemoteException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

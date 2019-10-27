/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.rmi.Remote;

/**
 *
 * @author PAVITHRA
 */
public interface RemoteBOFactory extends Remote{
        public SuperBO getBO(BOTypes boTypes)throws Exception;
}

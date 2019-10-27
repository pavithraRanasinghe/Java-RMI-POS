/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.Remote;

/**
 *
 * @author Sam
 */
public interface Subject extends Remote{
    public void registerObeser(Observer ob)throws Exception;
    public void removeObeser(Observer ob)throws Exception;
    public void notifyAllObeser(String message)throws Exception;
}

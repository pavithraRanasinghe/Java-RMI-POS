/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import observer.Subject;
import reservation.Reserve;

/**
 *
 * @author Sam
 */
public interface SuperService extends Remote,Subject,Reserve{
    
}

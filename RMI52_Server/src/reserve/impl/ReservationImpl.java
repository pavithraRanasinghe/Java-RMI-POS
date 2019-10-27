/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserve.impl;

import java.util.HashMap;

/**
 *
 * @author Sam
 */
public class ReservationImpl<T> {
    private HashMap<Object,T> reservationMap = new HashMap<>();
    
    public boolean reserve(Object key,T service){
        if (reservationMap.containsKey(key)) {
            return reservationMap.get(key)==service;
        }else{
            reservationMap.put(key, service);
            return true;
        }
    }
    public boolean release(Object key ,T service){
        if (reservationMap.containsKey(key)&& reservationMap.get(key)==service) {
            reservationMap.remove(key);
            return true;
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.custom.impl.CustomerBOImpl;
import business.custom.impl.ItemBOImpl;

/**
 *
 * @author PAVITHRA
 */
public class BOFactory{

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance(){
        return (boFactory == null) ? (boFactory = new BOFactory()) : boFactory;
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }
    }
}

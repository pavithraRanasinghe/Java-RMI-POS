/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import service.custom.ItemService;
import business.BOFactory;
import business.BOTypes;
import business.custom.ItemBO;
import dto.ItemDTO;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import observer.Observer;

/**
 *
 * @author PAVITHRA
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{

    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOTypes.ITEM);

    private static ArrayList<Observer> allItem = new ArrayList<>();
    
    public ItemServiceImpl()throws Exception{
    
    }
    
    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception {
        return itemBO.addItem(itemDTO);
    }

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception {
        return itemBO.deleteItem(code);
    }

    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception{
        return itemBO.updateItem(itemDTO);
    }

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception{
        return itemBO.searchItem(code);
    }

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception {
        return itemBO.getAllItem();
    }

    @Override
    public void registerObeser(Observer ob) throws Exception {
        allItem.add(ob);
    }

    @Override
    public void removeObeser(Observer ob) throws Exception {
        allItem.remove(ob);
    }

    @Override
    public void notifyAllObeser(String message) throws Exception {
        for (Observer ob : allItem) {
            ob.update(message);
        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

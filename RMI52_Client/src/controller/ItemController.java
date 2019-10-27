/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.ItemDTO;
import service.custom.ItemService;

/**
 *
 * @author PAVITHRA
 */
public class ItemController {

    ItemService itemService = ProxyHandler.getInstance().getItem();    
    
    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception {
        return itemService.addItem(itemDTO);
    }
    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception{
        return itemService.deleteItem(code);
    }
    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception{
        return itemService.updateItem(itemDTO);
    }
    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception{
        return itemService.searchItem(code);
    }
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception{
        return itemService.getAllItem();
    }
}

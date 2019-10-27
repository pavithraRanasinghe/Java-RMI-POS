/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author PAVITHRA
 */
public interface ItemService extends SuperService{

    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception;

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception;
}

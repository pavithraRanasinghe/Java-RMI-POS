/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public interface ItemBO extends SuperBO {

    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException,Exception;

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException,Exception;

    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException,Exception;

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException,Exception;

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException,Exception;
}

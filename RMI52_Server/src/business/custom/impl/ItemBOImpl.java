/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.ItemDAO;
import db.DBConnection;
import dto.ItemDTO;
import entity.Item;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public class ItemBOImpl implements ItemBO {

    ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    public ItemBOImpl() {
    }

    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.add(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getQty(), itemDTO.getPrice()));
        }
    }

    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.delete(code);
        }
    }

    public boolean updateItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.update(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getQty(), itemDTO.getPrice()));
        }
    }

    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            Item item = dao.search(code);
            return new ItemDTO(item.getCode(), item.getDescription(), item.getQty(), item.getPrice());
        }
    }

    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            ArrayList<Item> all = dao.getAll();
            ArrayList<ItemDTO> list = new ArrayList<>();
            for (Item item : all) {
                list.add(new ItemDTO(item.getCode(), item.getDescription(), item.getQty(), item.getPrice()));
            }
            return list;
        }
    }
}

package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.jdbc.ItemsDAO;
import system.model.Item;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private ItemsDAO itemsDAO;

    public List<Item> getAllItems(){
        return itemsDAO.getAllItems();
    }

    public List<Item> searchItems(HttpServletRequest request){
        return  itemsDAO.searchItems(request);
    }

    public void addItem(Item item){
        itemsDAO.addItem(item);
    }
}
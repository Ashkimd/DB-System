package system.dao;

import system.model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;

public interface ItemsDaoInterface {
    public void setDataSource(DataSource dataSource);
    public void addItem(Item item);
    public List<Item> getAllItems();
    public List<Item> searchItems(HttpServletRequest request);
}

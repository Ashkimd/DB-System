package system.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import system.dao.ItemsDaoInterface;
import system.model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemsDAO implements ItemsDaoInterface {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dSource) {
        this.jdbcTemplate = new JdbcTemplate(dSource);
    }

    @Override
    public void addItem(Item item){
        String sql = "INSERT INTO item_table (name) VALUES (?)";
        setDataSource(dataSource);
        jdbcTemplate.update(sql, item.getName());
    }

    @Override
    public List<Item> getAllItems(){
        String sql = "SELECT * FROM item_table";
        setDataSource(dataSource);
        List<Item> itemList = getItems(sql);

        return itemList;
    }

    @Override
    public List<Item> searchItems(HttpServletRequest request){
        String req = request.getParameter("search_request");
        req = "\'%" + req + "%\'";
        String sql = "SELECT * FROM item_table WHERE id LIKE " + req +
                " OR name LIKE " + req;
        setDataSource(dataSource);
        List<Item> itemList = getItems(sql);

        return itemList;
    }

    private List<Item> getItems(String sql) {
        return jdbcTemplate.query(sql, new RowMapper<Item>() {
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                return item;
            }
        });
    }
}
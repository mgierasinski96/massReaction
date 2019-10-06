package mgierasinski.service;


import mgierasinski.dao.ItemRepository;
import mgierasinski.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Blob;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    private JdbcTemplate jdbcTemp;

    public ItemServiceImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }


    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void removeItem(long itemId) {
        itemRepository.delete(itemId);
    }

    @Override
    public Item getItem(long itemId) {
        return itemRepository.findByItemId(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(String itemName) {
        return itemRepository.findByItemName(itemName);
    }

    @Transactional
    public Blob getPhotoById(long id) {

        String query = "select i.itemPicture from item i where i.itemId=?";

        Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

        return photo;
    }
}

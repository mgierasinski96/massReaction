package mgierasinski.service;

import mgierasinski.domain.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.List;


public interface ItemService {

    void addItem(Item item);
    void removeItem(long itemId);
    Item getItem(long itemId);
    List<Item> getAllItems();
    Item getItem(String itemName);
    Blob getPhotoById(long id);

}

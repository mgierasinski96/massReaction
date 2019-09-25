package mgierasinski.dao;


import mgierasinski.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findByItemId(long id);
    Item findByItemName(String itemName);
}

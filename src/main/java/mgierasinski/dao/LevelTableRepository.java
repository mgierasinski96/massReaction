package mgierasinski.dao;

import mgierasinski.domain.LevelTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LevelTableRepository extends JpaRepository<LevelTable,Long> {

    LevelTable findByLevel(long level);


}

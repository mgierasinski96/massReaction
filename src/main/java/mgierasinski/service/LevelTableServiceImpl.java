package mgierasinski.service;

import mgierasinski.dao.LevelTableRepository;
import mgierasinski.domain.LevelTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LevelTableServiceImpl implements LevelTableService{
    @Autowired
    LevelTableRepository levelTableRepository;
    @Override
    public LevelTable getLevel(long level) {
        return levelTableRepository.findByLevel(level);
    }
}

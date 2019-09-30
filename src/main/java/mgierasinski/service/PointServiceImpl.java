package mgierasinski.service;

import mgierasinski.dao.PointRepository;
import mgierasinski.domain.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Override
    public Point getPointById(long id) {
        return pointRepository.findByPoint(id);
    }

    @Override
    public Point getPointByCost(long pointCost) {
        return pointRepository.findByPointCost(pointCost);
    }
}

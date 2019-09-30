package mgierasinski.service;

import mgierasinski.domain.Point;

public interface PointService {

    Point getPointById(long id);
    Point getPointByCost(long pointCost);

}

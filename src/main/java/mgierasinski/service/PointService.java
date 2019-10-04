package mgierasinski.service;

import mgierasinski.domain.Point;

import java.util.List;

public interface PointService {

    Point getPointById(long id);
    Point getPointByCost(long pointCost);
    List<Point> getAll();

}

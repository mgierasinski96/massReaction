package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table(name="point")
public class Point {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="point")
    private long point;

    @Column(name="pointCost")
    private long pointCost;

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public long getPointCost() {
        return pointCost;
    }

    public void setPointCost(long pointCost) {
        this.pointCost = pointCost;
    }
}

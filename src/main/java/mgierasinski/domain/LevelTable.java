package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table(name="levelTable")
public class LevelTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="level")
    private long level;

    @Column(name="exp")
    private long exp;

    @Column(name="totalExp")
    private long totalExp;

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(long totalExp) {
        this.totalExp = totalExp;
    }
}

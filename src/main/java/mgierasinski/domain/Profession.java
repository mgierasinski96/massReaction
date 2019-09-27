package mgierasinski.domain;

import javax.persistence.*;

@Entity
@Table (name="profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="professionId")
    private long professionId;

    @Lob
    @Column(name="professionPicture")
    private byte[] professionPicture;

    @Column(name="professionName")
    private String professionName;

    @Column(name="dmgCalculation")
    private  double dmgCalculation;

    @Column(name="hpCalculation")
    private double hpCalculation;

    @Column(name="dodgeCalculation")
    private double dodgeCalculation;


    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public byte[] getProfessionPicture() {
        return professionPicture;
    }

    public void setProfessionPicture(byte[] professionPicture) {
        this.professionPicture = professionPicture;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public double getDmgCalculation() {
        return dmgCalculation;
    }

    public void setDmgCalculation(double dmgCalculation) {
        this.dmgCalculation = dmgCalculation;
    }

    public double getHpCalculation() {
        return hpCalculation;
    }

    public void setHpCalculation(double hpCalculation) {
        this.hpCalculation = hpCalculation;
    }

    public double getDodgeCalculation() {
        return dodgeCalculation;
    }

    public void setDodgeCalculation(double dodgeCalculation) {
        this.dodgeCalculation = dodgeCalculation;
    }
}

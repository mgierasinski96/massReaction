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
    private  String dmgCalculation;

    @Column(name="hpCalculation")
    private String hpCalculation;

    @Column(name="dodgeCalculation")
    private String dodgeCalculation;


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

    public String getDmgCalculation() {
        return dmgCalculation;
    }

    public void setDmgCalculation(String dmgCalculation) {
        this.dmgCalculation = dmgCalculation;
    }

    public String getHpCalculation() {
        return hpCalculation;
    }

    public void setHpCalculation(String hpCalculation) {
        this.hpCalculation = hpCalculation;
    }

    public String getDodgeCalculation() {
        return dodgeCalculation;
    }

    public void setDodgeCalculation(String dodgeCalculation) {
        this.dodgeCalculation = dodgeCalculation;
    }
}

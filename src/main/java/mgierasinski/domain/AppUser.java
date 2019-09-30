package mgierasinski.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "userCharacter")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "userLvl")
    private long userLvl;

    @Column(name = "userGold")
    private long userGold;

    @Column(name = "userWisdom")
    private long userWisdom;

    @Column(name = "userStrength")
    private long userStrength;

    @Column(name = "userHP")
    private long userHP;

    @Column(name = "userTotalHP")
    private double userTotalHP;

    @Column(name = "userTotalDmg")
    private double userTotalDmg;

    @Column(name = "userTotalDodge")
    private double userTotalDodge;

    @ManyToOne
    @JoinColumn(name = "userProfession")
    private Profession userProfession;

    @Column(name="userTotalExp")
    private long userTotalExp;




    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    @Column(name = "email")
    private String email;


    @NotNull
    @Column(name = "login", unique = true)
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    public AppUser() {
        this.userLvl = 1;
        this.userGold = 10;
        this.userTotalExp=0;
    }




    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> userItems = new ArrayList<>(0);

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserLvl() {
        return userLvl;
    }

    public void setUserLvl(long userLvl) {
        this.userLvl = userLvl;
    }

    public long getUserGold() {
        return userGold;
    }

    public void setUserGold(long userGold) {
        this.userGold = userGold;
    }

    public long getUserWisdom() {
        return userWisdom;
    }

    public void setUserWisdom(long userWisdom) {
        this.userWisdom = userWisdom;
    }

    public long getUserStrength() {
        return userStrength;
    }

    public void setUserStrength(long userStrength) {
        this.userStrength = userStrength;
    }

    public long getUserHP() {
        return userHP;
    }

    public void setUserHP(long userHP) {
        this.userHP = userHP;
    }

    public double getUserTotalHP() {
        return userTotalHP;
    }

    public void setUserTotalHP(double userTotalHP) {
        this.userTotalHP = userTotalHP;
    }

    public double getUserTotalDmg() {
        return userTotalDmg;
    }

    public void setUserTotalDmg(double userTotalDmg) {
        this.userTotalDmg = userTotalDmg;
    }

    public double getUserTotalDodge() {
        return userTotalDodge;
    }

    public void setUserTotalDodge(double userTotalDodge) {
        this.userTotalDodge = userTotalDodge;
    }

    public long getUserTotalExp() {
        return userTotalExp;
    }

    public void setUserTotalExp(long userTotalExp) {
        this.userTotalExp = userTotalExp;
    }

    public Profession getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(Profession userProfession) {
        this.userProfession = userProfession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<Item> userItems) {
        this.userItems = userItems;
    }

}

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
    private String userLvl;

    @Column(name = "userGold")
    private String userGold;

    @Column(name = "userWisdom")
    private String userWisdom;

    @Column(name = "userStrength")
    private String userStrength;

    @Column(name = "userHP")
    private String userHP;

    @Column(name = "userTotalHP")
    private String userTotalHP;

    @Column(name = "userTotalDmg")
    private String userTotalDmg;

    @Column(name = "userTotalDodge")
    private String userTotalDodge;

    @ManyToOne
    @JoinColumn(name = "userProfession")
    private Profession userProfession;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public AppUser() {
        this.userLvl = "1";
        this.userGold = "10";
    }

    @Column(name = "email")
    private String email;


    @NotNull
    @Column(name = "login", unique = true)
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> userItems = new ArrayList<>(0);

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserLvl() {
        return userLvl;
    }

    public void setUserLvl(String userLvl) {
        this.userLvl = userLvl;
    }

    public String getUserGold() {
        return userGold;
    }

    public void setUserGold(String userGold) {
        this.userGold = userGold;
    }

    public String getUserWisdom() {
        return userWisdom;
    }

    public void setUserWisdom(String userWisdom) {
        this.userWisdom = userWisdom;
    }

    public String getUserStrength() {
        return userStrength;
    }

    public void setUserStrength(String userStrength) {
        this.userStrength = userStrength;
    }

    public String getUserHP() {
        return userHP;
    }

    public void setUserHP(String userHP) {
        this.userHP = userHP;
    }

    public String getUserTotalHP() {
        return userTotalHP;
    }

    public void setUserTotalHP(String userTotalHP) {
        this.userTotalHP = userTotalHP;
    }

    public String getUserTotalDmg() {
        return userTotalDmg;
    }

    public void setUserTotalDmg(String userTotalDmg) {
        this.userTotalDmg = userTotalDmg;
    }

    public String getUserTotalDodge() {
        return userTotalDodge;
    }

    public void setUserTotalDodge(String userTotalDodge) {
        this.userTotalDodge = userTotalDodge;
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

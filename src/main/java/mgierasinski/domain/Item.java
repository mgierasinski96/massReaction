package mgierasinski.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="item")
public class Item  implements Serializable {

    @Id
    @Column(name="itemId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    @Column(name="itemName")
    String itemName;

    @Lob
    @Column(name="itemPicture")
    private byte[] itemPicture;

    @Column(name="itemDmg")
    private long itemDmg;

    @Column(name="itemHealth")
    private long itemHealth;

    @Column(name="itemDodge")
    private long itemDodge;

    @Column(name="itemCost")
    private long itemCost;

    @Column(name="itemValue")
    private long itemValue;

    @Column(name="itemStrength")
    private  long itemStrength;

    @Column(name="itemWisdom")
    private long itemWisdom;

    @Column(name="itemHP")
    private long itemHP;

    @Column(name="itemClass")
    private  String itemClass;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AppUserItems> appUserItems;

    public List<AppUserItems> getAppUserItems() {
        return appUserItems;
    }

    public void setAppUserItems(List<AppUserItems> appUserItems) {
        this.appUserItems = appUserItems;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public byte[] getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(byte[] itemPicture) {
        this.itemPicture = itemPicture;
    }

    public long getItemDmg() {
        return itemDmg;
    }

    public void setItemDmg(long itemDmg) {
        this.itemDmg = itemDmg;
    }

    public long getItemHealth() {
        return itemHealth;
    }

    public void setItemHealth(long itemHealth) {
        this.itemHealth = itemHealth;
    }

    public long getItemDodge() {
        return itemDodge;
    }

    public void setItemDodge(long itemDodge) {
        this.itemDodge = itemDodge;
    }

    public long getItemCost() {
        return itemCost;
    }

    public void setItemCost(long itemCost) {
        this.itemCost = itemCost;
    }

    public long getItemValue() {
        return itemValue;
    }

    public void setItemValue(long itemValue) {
        this.itemValue = itemValue;
    }

    public long getItemStrength() {
        return itemStrength;
    }

    public void setItemStrength(long itemStrength) {
        this.itemStrength = itemStrength;
    }

    public long getItemWisdom() {
        return itemWisdom;
    }

    public void setItemWisdom(long itemWisdom) {
        this.itemWisdom = itemWisdom;
    }

    public long getItemHP() {
        return itemHP;
    }

    public void setItemHP(long itemHP) {
        this.itemHP = itemHP;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }
}
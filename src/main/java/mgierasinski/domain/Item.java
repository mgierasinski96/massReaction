package mgierasinski.domain;


import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {

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
    private String itemDmg;

    @Column(name="itemHealth")
    private String itemHealth;

    @Column(name="itemDodge")
    private String itemDodge;

    @Column(name="itemCost")
    private String itemCost;

    @Column(name="itemValue")
    private String itemValue;

    @Column(name="itemStrength")
    private  String itemStrength;

    @Column(name="itemWisdom")
    private String itemWisdom;

    @Column(name="itemHP")
    private String itemHP;

    @Column(name="itemClass")
    private  String itemClass;



    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemDmg() {
        return itemDmg;
    }

    public void setItemDmg(String itemDmg) {
        this.itemDmg = itemDmg;
    }

    public String getItemHealth() {
        return itemHealth;
    }

    public void setItemHealth(String itemHealth) {
        this.itemHealth = itemHealth;
    }

    public String getItemDodge() {
        return itemDodge;
    }

    public void setItemDodge(String itemDodge) {
        this.itemDodge = itemDodge;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemStrength() {
        return itemStrength;
    }

    public void setItemStrength(String itemStrength) {
        this.itemStrength = itemStrength;
    }

    public String getItemWisdom() {
        return itemWisdom;
    }

    public void setItemWisdom(String itemWisdom) {
        this.itemWisdom = itemWisdom;
    }

    public String getItemHP() {
        return itemHP;
    }

    public void setItemHP(String itemHP) {
        this.itemHP = itemHP;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
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
}


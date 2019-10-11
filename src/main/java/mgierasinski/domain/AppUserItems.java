package mgierasinski.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="usercharacter_items")
public class AppUserItems implements Serializable {



    //TODO dodac repozytorium tego szajsu, zmienic pobierane nazwy w jsp
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private AppUser appUser;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Item item;

    public AppUserItems(AppUser appUser, Item item, Boolean equipped) {
        this.appUser = appUser;
        this.item = item;
        this.equipped = equipped;
    }

    public AppUserItems() {
    }

    private Boolean equipped;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Boolean getEquipped() {
        return equipped;
    }

    public void setEquipped(Boolean equipped) {
        this.equipped = equipped;
    }
}

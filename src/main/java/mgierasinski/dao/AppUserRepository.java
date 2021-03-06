package mgierasinski.dao;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
    AppUser findByUserId(long id);
    AppUser findByLogin(String login);

    @Transactional
    @Modifying
    @Query(value = "update usercharacter_items uci set uci.equipped=:equipped where uci.appUser_UserId=:userId and uci.item_itemId=:itemId ",nativeQuery = true)
    void equipUnequipItem(@Param("userId") long userId, @Param("itemId") long itemId,@Param("equipped") Boolean equipped);

    @Transactional
    @Modifying
    @Query(value = "update usercharacter uc set uc.userLvl=:newLevel where uc.userId=:userId ",nativeQuery = true)
    void lvlAdvanced(@Param("newLevel") long newLevel, @Param("userId") long userId);

    @Transactional
    @Modifying
    @Query(value = "update usercharacter uc set uc.userTotalDmg=:userDmg,uc.userTotalDodge=:userDodge,uc.userTotalHP=:userHP where uc.userId=:userId ",nativeQuery = true)
    void updateDmgDodgeHealth(@Param("userDmg") float userDmg,@Param("userDodge") float userDodge,@Param("userHP") float userHP, @Param("userId") long userId);

    @Transactional
    @Modifying
    @Query(value="update usercharacter uc set uc.userHp=:newUserHp,uc.userTotalHp=:newUserTotalHp,uc.userGold=:newUserGold where uc.userId=:userId ",nativeQuery = true)
    void trainHp(@Param("newUserHp") int newUserHp,@Param("newUserTotalHp") double newUserTotalHp,@Param("newUserGold") long newUserGold,@Param("userId") long userId);

    @Transactional
    @Modifying
    @Query(value="update usercharacter uc set uc.userStrength=:newUserStrength,uc.userTotalDmg=:newUserTotalDmg,uc.userGold=:newUserGold where uc.userId=:userId ",nativeQuery = true)
    void trainDmgWarrior(@Param("newUserStrength") int newUserStrength,@Param("newUserTotalDmg") double newUserTotalDmg,@Param("newUserGold") long newUserGold,@Param("userId") long userId);

    @Transactional
    @Modifying
    @Query(value="update usercharacter uc set uc.userWisdom=:newUserWisdom,uc.userTotalDmg=:newUserTotalDmg,uc.userGold=:newUserGold where uc.userId=:userId ",nativeQuery = true)
    void trainDmgWizard(@Param("newUserWisdom") int newUserWisdom,@Param("newUserTotalDmg") double newUserTotalDmg,@Param("newUserGold") long newUserGold,@Param("userId") long userId);

    @Transactional
    @Modifying
    @Query(value="update usercharacter uc set uc.userStrength=:newUserStrength,uc.userTotalDodge=:newUserTotalDodge,uc.userGold=:newUserGold where uc.userId=:userId ",nativeQuery = true)
    void trainDodgeWizard(@Param("newUserStrength") int newUserStrength,@Param("newUserTotalDodge") double newUserTotalDodge,@Param("newUserGold") long newUserGold,@Param("userId") long userId);



    @Transactional
    @Modifying
    @Query(value="update usercharacter uc set uc.userWisdom=:newUserWisdom,uc.userTotalDodge=:newUserTotalDodge,uc.userGold=:newUserGold where uc.userId=:userId ",nativeQuery = true)
    void trainDodgeWarrior(@Param("newUserWisdom") int newUserWisdom,@Param("newUserTotalDodge") double newUserTotalDodge,@Param("newUserGold") long newUserGold,@Param("userId") long userId);


}



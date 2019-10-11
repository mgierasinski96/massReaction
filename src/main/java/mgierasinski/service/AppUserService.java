package mgierasinski.service;

import mgierasinski.dao.AppUserRepository;
import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppUserService {

    void addAppUser(AppUser appUser);

    List<AppUser> listAppUser();
    void editAppUser(AppUser appUser);
   void removeAppUser(long id);

    AppUser getAppUser(long id);
    AppUser findByLogin(String login);
    AppUser findByEmail(String email);
//    List<AppUserItems> getUserItems(long userId);

    void lvlAdvanced(long newLevel,long userId);
    void trainHp(int newUserHp,double newUserTotalHp,int newUserGold,long userId);
    void trainDmgWarrior(int newUserStrength,double newUserTotalDmg,int newUserGold,long userId);
    void trainDmgWizard(int newUserWisdom,double newUserTotalDmg,int newUserGold,long userId);
    void trainDodgeWarrior(int newUserWisdom,double newUserTotalDodge,int newUserGold,long userId);
    void trainDodgeWizard(int newUserStrength,double newUserTotalDodge,int newUserGold,long userId);

    AppUser findLoggedAppUser();
  //  void activateAppUser(mgierasinski.domain.AppUser appUser);

}

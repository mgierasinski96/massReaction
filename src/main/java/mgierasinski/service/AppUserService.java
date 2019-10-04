package mgierasinski.service;

import mgierasinski.dao.AppUserRepository;
import mgierasinski.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppUserService {

    void addAppUser(AppUser appUser);
    void editAppUser(AppUser appUser);
    List<AppUser> listAppUser();

   void removeAppUser(long id);

    AppUser getAppUser(long id);
    AppUser findByLogin(String login);
    AppUser findByEmail(String email);

    void lvlAdvanced(long newLevel,long userId);

    AppUser findLoggedAppUser();
  //  void activateAppUser(mgierasinski.domain.AppUser appUser);

}

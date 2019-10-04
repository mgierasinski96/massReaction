package mgierasinski.service;

import mgierasinski.dao.AppUserRepository;
import mgierasinski.dao.AppUserRoleRepository;
import mgierasinski.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserRoleRepository appUserRoleRepository;



    @Override
    public void addAppUser(AppUser appUser) {
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));//przypisz role user
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public void editAppUser(AppUser appUser) {

        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    @Override
    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    @Override
    public AppUser getAppUser(long id) {
        return appUserRepository.findByUserId(id);
    }

    @Override
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public void lvlAdvanced(long newLevel, long userId) {
        appUserRepository.lvlAdvanced(newLevel,userId);

    }

    @Override
    public AppUser findLoggedAppUser() {
            HttpServletRequest request;
            try {
                String username;
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserDetails) {
                    username = ((UserDetails) principal).getUsername();
                } else {
                    username = principal.toString();
                }

                if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("gm") || username.equals("user"))) {
                    AppUser appUser = this.findByLogin(username);
                    return appUser;
                }
            } catch (Exception ex) {
                System.out.println("Niezalogowany lub nieistniejący użytkownik");
            }

            return null;
        }


    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


//    @Transactional
//    @Modifying
//    public void activateAppUser(AppUser appUser) {
//        appUser.setActivated(true);
//        appUserRepository.save(appUser);
//    }
}

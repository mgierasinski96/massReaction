package mgierasinski.service;

import mgierasinski.dao.AppUserRepository;
import mgierasinski.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;


    @Override
    public void addAppUser(AppUser appUser) {
        //appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));//przypisz role user
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
        return appUserRepository.findById(id);
    }

    @Override
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
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

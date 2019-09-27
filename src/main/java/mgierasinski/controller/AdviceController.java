package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.LevelTable;
import mgierasinski.service.AppUserService;
import mgierasinski.service.LevelTableService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class AdviceController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    LevelTableService levelTableService;

    boolean lvlUp=false;

    AppUser findAppUser() {
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
                AppUser appUser = appUserService.findByLogin(username);
                return appUser;
            }
        } catch (Exception ex) {
            System.out.println("Niezalogowany lub nieistniejący użytkownik");
        }

        return null;
    }

    @ModelAttribute("userGold")
    long userGold() {

        AppUser appUser = findAppUser();
        if (appUser != null) {
            return appUser.getUserGold();
        }
        return 0;
    }

    @ModelAttribute("expToNextLvl")
    long expToNextLvl() {
        AppUser appUser = findAppUser();
        if (appUser != null) {
            LevelTable level=levelTableService.getLevel(appUser.getUserLvl());

            return level.getExp();
        }
        return -1;
    }
}


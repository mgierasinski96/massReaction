package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.LevelTable;
import mgierasinski.service.AppUserService;
import mgierasinski.service.LevelTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;




@ControllerAdvice
public class AdviceController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    LevelTableService levelTableService;


    @ModelAttribute("userGold")
    long userGold() {

        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            return appUser.getUserGold();
        }
        return -1;
    }

    @ModelAttribute("expToNextLvl")
    long expToNextLvl() {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            LevelTable level=levelTableService.getLevel(appUser.getUserLvl());

            return level.getExp();
        }
        return -1;
    }
}


package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/trainHp")
    @ResponseBody
    public void trainHp(@RequestParam int newUserGold, @RequestParam int newHealthValue) {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            double newUserTotalHp = newHealthValue * appUser.getUserProfession().getHpCalculation();
            System.out.println("total hp" + newUserTotalHp);
            appUserService.trainHp(newHealthValue, newUserTotalHp, newUserGold, appUser.getUserId());
        }
    }

    @RequestMapping(value = "/trainWisdom")
    @ResponseBody
    public void trainWisdom(@RequestParam int newUserGold, @RequestParam int newWisdomValue) {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {
                double newUserTotalDmg = newWisdomValue * appUser.getUserProfession().getDmgCalculation();
                appUserService.trainDmgWizard(newWisdomValue, newUserTotalDmg, newUserGold, appUser.getUserId());

            } else {
                double newUserTotalDodge = newWisdomValue * appUser.getUserProfession().getDodgeCalculation();
                appUserService.trainDodgeWizard(newWisdomValue, newUserTotalDodge, newUserGold, appUser.getUserId());
            }

        }
    }


    @RequestMapping(value = "/trainStrength")
    @ResponseBody
    public void trainStrength(@RequestParam int newUserGold, @RequestParam int newStrengthValue) {

        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {

            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {
                double newUserTotalDodge = newStrengthValue * appUser.getUserProfession().getDodgeCalculation();
                appUserService.trainDodgeWizard(newStrengthValue, newUserTotalDodge, newUserGold, appUser.getUserId());
            } else {
                double newUserTotalDmg = newStrengthValue * appUser.getUserProfession().getDmgCalculation();
                appUserService.trainDmgWarrior(newStrengthValue, newUserTotalDmg, newUserGold, appUser.getUserId());
            }

        }
    }
}

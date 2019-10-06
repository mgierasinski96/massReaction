package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.helpers.MathRound;
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
            newUserTotalHp= MathRound.round(newUserTotalHp,2);
            System.out.println("total hp" + newUserTotalHp);

            appUserService.trainHp(newHealthValue, newUserTotalHp, newUserGold, appUser.getUserId());
        }
    }

    @RequestMapping(value = "/trainWisdom")
    @ResponseBody
    public void trainWisdom(@RequestParam int newUserGold, @RequestParam int newWisdomValue) {

        System.out.println("trenuje madrosc");
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {
                double newUserTotalDmg = newWisdomValue * appUser.getUserProfession().getDmgCalculation();
                newUserTotalDmg= MathRound.round(newUserTotalDmg,2);
                appUserService.trainDmgWizard(newWisdomValue, newUserTotalDmg, newUserGold, appUser.getUserId());

            } else {
                System.out.println("czyli zmiena dodge wojowinkowi");
                double newUserTotalDodge = newWisdomValue * appUser.getUserProfession().getDodgeCalculation();
                newUserTotalDodge= MathRound.round(newUserTotalDodge,2);
                System.out.println("nowa madrosc "+newWisdomValue + " dala dodza "+newUserTotalDodge);
                appUserService.trainDodgeWarrior(newWisdomValue, newUserTotalDodge, newUserGold, appUser.getUserId());
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
                newUserTotalDodge= MathRound.round(newUserTotalDodge,2);
                appUserService.trainDodgeWizard(newStrengthValue, newUserTotalDodge, newUserGold, appUser.getUserId());
            } else {
                double newUserTotalDmg = newStrengthValue * appUser.getUserProfession().getDmgCalculation();
                newUserTotalDmg= MathRound.round(newUserTotalDmg,2);
                appUserService.trainDmgWarrior(newStrengthValue, newUserTotalDmg, newUserGold, appUser.getUserId());
            }

        }
    }
}

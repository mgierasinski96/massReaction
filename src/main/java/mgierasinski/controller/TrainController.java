package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.Item;
import mgierasinski.service.ItemService;
import mgierasinski.utils.MathRound;
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

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/trainHp")
    @ResponseBody
    public void trainHp(@RequestParam int newUserGold, @RequestParam int newHealthValue) {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            double newUserTotalHp = appUser.getUserTotalHP() + 1 * appUser.getUserProfession().getHpCalculation();
            newUserTotalHp= MathRound.round(newUserTotalHp,2);
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
                double newUserTotalDmg =appUser.getUserTotalDmg()+1 * appUser.getUserProfession().getDmgCalculation();
                newUserTotalDmg= MathRound.round(newUserTotalDmg,2);
                appUserService.trainDmgWizard(newWisdomValue, newUserTotalDmg, newUserGold, appUser.getUserId());

            } else {

                double newUserTotalDodge = appUser.getUserTotalDodge()+1 * appUser.getUserProfession().getDodgeCalculation();
                newUserTotalDodge= MathRound.round(newUserTotalDodge,2);
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
                double newUserTotalDodge = appUser.getUserTotalDodge()+1 * appUser.getUserProfession().getDodgeCalculation();
                newUserTotalDodge= MathRound.round(newUserTotalDodge,2);
                appUserService.trainDodgeWizard(newStrengthValue, newUserTotalDodge, newUserGold, appUser.getUserId());
            } else {
                double newUserTotalDmg = appUser.getUserTotalDmg()+1 * appUser.getUserProfession().getDmgCalculation();
                newUserTotalDmg= MathRound.round(newUserTotalDmg,2);
                appUserService.trainDmgWarrior(newStrengthValue, newUserTotalDmg, newUserGold, appUser.getUserId());
            }

        }
    }

    @RequestMapping(value = "/equipItem")
    @ResponseBody
    public void equipItem(@RequestParam int eItemId,@RequestParam float newStrengthCalc,@RequestParam float newWisdomCalc,@RequestParam float newHPCalc) {

        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            Item item=itemService.getItem(eItemId);
            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {

                appUserService.updateDmgDodgeHP(newWisdomCalc,newStrengthCalc,newHPCalc,appUser.getUserId());
                appUserService.equipUnequipItem(appUser.getUserId(),item.getItemId(),true);

            }
            else if(appUser.getUserProfession().getProfessionName().toLowerCase().equals("wojownik")) {
                appUserService.updateDmgDodgeHP(newStrengthCalc,newWisdomCalc,newHPCalc,appUser.getUserId());
                appUserService.equipUnequipItem(appUser.getUserId(),item.getItemId(),true);


            }
        }
    }

    @RequestMapping(value = "/unequipItem")
    @ResponseBody
    public void unequipItem(@RequestParam int uItemId,@RequestParam float newStrengthCalc,@RequestParam float newWisdomCalc,@RequestParam float newHPCalc)
    {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            Item item=itemService.getItem(uItemId);
            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {

                appUserService.updateDmgDodgeHP(newWisdomCalc,newStrengthCalc,newHPCalc,appUser.getUserId());
                appUserService.equipUnequipItem(appUser.getUserId(),item.getItemId(),false);

            }
            else if(appUser.getUserProfession().getProfessionName().toLowerCase().equals("wojownik")) {
                appUserService.updateDmgDodgeHP(newStrengthCalc,newWisdomCalc,newHPCalc,appUser.getUserId());
                appUserService.equipUnequipItem(appUser.getUserId(),item.getItemId(),false);


            }
        }
    }



}

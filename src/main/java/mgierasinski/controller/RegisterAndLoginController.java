package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserItems;
import mgierasinski.domain.Item;
import mgierasinski.domain.Profession;
import mgierasinski.service.AppUserService;
import mgierasinski.service.ItemService;
import mgierasinski.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterAndLoginController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    ProfessionService professionService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value="loginForm")
    public String loginForm()
    {
        return "loginPage";
    }


    @RequestMapping(value = "/register")
    public String registerCharacter(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "registerCharacter";
    }


    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@ModelAttribute("appUser") AppUser appUser, BindingResult result,@RequestParam("strengthValueCalc") String strengthValueCalc,
                             @RequestParam("wisdomValueCalc") String wisdomValueCalc) {


        if (result.getErrorCount() == 0) {

            if (appUser.getUserId() == 0) {

                System.out.println(strengthValueCalc);
                System.out.println(wisdomValueCalc);
                if(wisdomValueCalc.indexOf("%")==-1)
                {
                    Profession mag=professionService.findByProfessionName("Czarodziej");
                    appUser.setUserProfession(mag);
                    appUser.setUserTotalDmg(Double.parseDouble(wisdomValueCalc));
                    String dodge=strengthValueCalc.substring(0,strengthValueCalc.indexOf("%"));
                    appUser.setUserTotalDodge(Double.parseDouble(dodge));

                }
                else
                {
                    Profession wojownik=professionService.findByProfessionName("Wojownik");
                    appUser.setUserProfession(wojownik);
                    appUser.setUserTotalDmg(Double.parseDouble(strengthValueCalc));
                    String dodge=wisdomValueCalc.substring(0,wisdomValueCalc.indexOf("%"));
                    appUser.setUserTotalDodge(Double.parseDouble(dodge));
                }

                List<AppUserItems> beginnerItems=new ArrayList<>();
                AppUserItems item1=new AppUserItems(appUser,itemService.getItem(1),false);
                AppUserItems item2=new AppUserItems(appUser,itemService.getItem(2),false);
                beginnerItems.add(item1);//drewniana tarcza glupcow
                beginnerItems.add(item2);//szturchacz
                appUser.setAppUserItems(beginnerItems);

                appUserService.addAppUser(appUser);

                return "mainBody";

            }

        }

        return "registerAppUser";
    }


}

package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.Profession;
import mgierasinski.service.AppUserService;
import mgierasinski.service.PointService;
import mgierasinski.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    @Autowired
    AppUserService appUserService;

    @Autowired
    PointService pointService;

    @RequestMapping(value = "/")
    public String mainPage() {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null)
            return "redirect:myCharacter.html";


        return "mainBody";
    }

    @RequestMapping(value = "/input")
    public String input(Model model) {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null) {
            model.addAttribute("userId", appUser.getUserId());
            model.addAttribute("pointList", pointService.getAll());
            if (appUser.getUserProfession().getProfessionName().toLowerCase().equals("czarodziej")) {
                model.addAttribute("wisdomCalc", appUser.getUserProfession().getDmgCalculation());
                model.addAttribute("strengthCalc", appUser.getUserProfession().getDodgeCalculation());
                model.addAttribute("healthCalc", appUser.getUserProfession().getHpCalculation());
                model.addAttribute("userProfession", appUser.getUserProfession().getProfessionName());
            } else {
                model.addAttribute("wisdomCalc", appUser.getUserProfession().getDodgeCalculation());
                model.addAttribute("strengthCalc", appUser.getUserProfession().getDmgCalculation());
                model.addAttribute("healthCalc", appUser.getUserProfession().getHpCalculation());
                model.addAttribute("userProfession", appUser.getUserProfession().getProfessionName());

            }
        }


        return "input";
    }

}


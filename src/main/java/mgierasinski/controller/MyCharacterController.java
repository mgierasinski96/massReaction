package mgierasinski.controller;


import mgierasinski.domain.AppUser;
import mgierasinski.domain.AppUserItems;
import mgierasinski.domain.Item;
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

import java.util.List;

@Controller
public class MyCharacterController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    ProfessionService professionService;

    @Autowired
    PointService pointService;

@RequestMapping(value="/myCharacter")
    public String myCharacter(Model model)
{
        AppUser appUser = appUserService.findLoggedAppUser();

if(appUser!=null) {
    System.out.println("znalazlo usera "+ appUser.getAppUserItems().size());
    model.addAttribute("appUser", appUser);
    model.addAttribute("strengthCost", pointService.getPointById(appUser.getUserStrength()).getPointCost());
    model.addAttribute("wisdomCost", pointService.getPointById(appUser.getUserWisdom()).getPointCost());
    model.addAttribute("hpCost", pointService.getPointById(appUser.getUserHP()).getPointCost());
    model.addAttribute("listOfPointForJs", pointService.getAll());
    model.addAttribute("userItems",appUser.getAppUserItems());
model.addAttribute("itemListLength",appUser.getAppUserItems().size());



    return "myCharacter";
}
return null;
}



}

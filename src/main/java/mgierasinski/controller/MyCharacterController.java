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

import java.util.ArrayList;
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

    model.addAttribute("appUser", appUser);
    model.addAttribute("strengthCost", pointService.getPointById(appUser.getUserStrength()).getPointCost());
    model.addAttribute("wisdomCost", pointService.getPointById(appUser.getUserWisdom()).getPointCost());
    model.addAttribute("hpCost", pointService.getPointById(appUser.getUserHP()).getPointCost());
    model.addAttribute("listOfPointForJs", pointService.getAll());

    List<AppUserItems> allUserItems=appUser.getAppUserItems();
    List<AppUserItems> equippedItems=new ArrayList<>();

    List<AppUserItems> unEquippedItems=new ArrayList<>();
    for(AppUserItems userItem: allUserItems)
    {
        if(userItem.getEquipped()==false)
        {
            unEquippedItems.add(userItem);
        }
        else if(userItem.getEquipped()==true)
        {
            equippedItems.add(userItem);
        }
    }
    model.addAttribute("userUNequippedItems",unEquippedItems);
    model.addAttribute("itemUNequippedListLength",unEquippedItems.size());
    model.addAttribute("userEquippedItems",equippedItems);



    return "myCharacter";
}
return null;
}



}

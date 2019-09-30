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
    String username;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
        username = ((UserDetails) principal).getUsername();
    } else {
        username = principal.toString();
    }

    if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("employee") || username.equals("user"))) {
        AppUser appUser = appUserService.findByLogin(username);


        model.addAttribute("appUser",appUser);
        model.addAttribute("strengthCost",pointService.getPointById(appUser.getUserStrength()).getPointCost());
        model.addAttribute("wisdomCost",pointService.getPointById(appUser.getUserWisdom()).getPointCost());
        model.addAttribute("hpCost",pointService.getPointById(appUser.getUserHP()).getPointCost());

    }
    return "myCharacter";
}



}

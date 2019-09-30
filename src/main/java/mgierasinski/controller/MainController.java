package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @Autowired
    AppUserService appUserService;

    @RequestMapping(value="/")
    public String mainPage()
    {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        AppUser appUser=appUserService.findByLogin(username);
        if(appUser!=null)
            return "redirect:myCharacter.html";



        return "mainBody";
    }
}

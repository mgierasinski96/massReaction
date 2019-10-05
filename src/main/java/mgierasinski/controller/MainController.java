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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;

@Controller
public class MainController {


    @Autowired
    AppUserService appUserService;


    @RequestMapping(value = "/")
    public String mainPage() {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null)
            return "redirect:myCharacter.html";


        return "mainBody";
    }


}


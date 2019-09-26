package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdviceController {

    @Autowired
    AppUserService appUserService;

    @ModelAttribute("userGold")
    String userGold(HttpServletRequest request) {

        try {
            String username;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }

            if (!(username.equals("anonymousUser") || username.equals("admin") || username.equals("gm") || username.equals("user"))) {
                AppUser appUser = appUserService.findByLogin(username);
                return appUser.getUserGold();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Niezalogowany lub nieistniejący użytkownik");
        }

        return null;
    }
}

package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.LevelTable;
import mgierasinski.service.AppUserService;
import mgierasinski.service.LevelTableService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Aspect
@ControllerAdvice
@Order(1)
public class AspectController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    LevelTableService levelTableService;

    AppUser findAppUser() {
        HttpServletRequest request;
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
                return appUser;
            }
        } catch (Exception ex) {
            System.out.println("Niezalogowany lub nieistniejący użytkownik");
        }

        return null;
    }

    @Before("execution(* mgierasinski.controller.AdviceController.*(..))")//to any method that is in package aop.luv2code.aopdemoDao
    @ModelAttribute("userExp")
    long userExp() {

        AppUser appUser = findAppUser();
        if (appUser != null) {
            LevelTable level=levelTableService.getLevel(appUser.getUserLvl());
            LevelTable levelBelow=levelTableService.getLevel(appUser.getUserLvl()-1);
            long userExp;
            if(appUser.getUserLvl()==1)
            {
                userExp=appUser.getUserTotalExp();
            }
            else {
                userExp = appUser.getUserTotalExp() - levelBelow.getTotalExp();

            }

            if(userExp>level.getExp())
            {
                System.out.println("LVL UP");
                long nextLevel=appUser.getUserLvl()+1;
                appUserService.lvlAdvanced(nextLevel,appUser.getUserId());
                levelBelow=levelTableService.getLevel(appUser.getUserLvl());
                userExp=appUser.getUserTotalExp() - levelBelow.getTotalExp();
            }

            return userExp;
        }
        return -1;
    }


}

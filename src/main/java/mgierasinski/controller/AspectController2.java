package mgierasinski.controller;

import mgierasinski.domain.AppUser;
import mgierasinski.domain.LevelTable;
import mgierasinski.service.AppUserService;
import mgierasinski.service.LevelTableService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Aspect
@ControllerAdvice
@Order(2)
public class AspectController2 {

    @Autowired
    AppUserService appUserService;

    @Autowired
    LevelTableService levelTableService;

    @Before("execution(* mgierasinski.controller.AdviceController.*(..))")//to any method that is in package aop.luv2code.aopdemoDao
    @ModelAttribute("userLvl")
    long userLvl() {
        AppUser appUser = appUserService.findLoggedAppUser();
        if (appUser != null)
            return appUser.getUserLvl();

        return 0;
    }
}

package mgierasinski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class registerController {




    @RequestMapping(value="/register")
    public String registerCharacter()
    {
        return "registerCharacter";
    }
}

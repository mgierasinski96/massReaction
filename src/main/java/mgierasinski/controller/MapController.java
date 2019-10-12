package mgierasinski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {


    @RequestMapping(value="/showMapTundra")
    public String showMapTundra()
    {
        return "tundraMap";
    }

    @RequestMapping(value="/showMapWinterDespair")
    public String showMap()
    {
        return "winterDespairMap";
    }
}

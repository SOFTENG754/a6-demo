package nz.ac.auckland.se754.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        int screenTime = 0;
        model.addAttribute("name", "User");
        model.addAttribute("screenTime", screenTime);

        return "welcome";
    }
}

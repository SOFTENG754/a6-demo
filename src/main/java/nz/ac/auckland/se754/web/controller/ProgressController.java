package nz.ac.auckland.se754.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ProgressController {
    @RequestMapping(value="/progress", method = RequestMethod.GET)
    public String showProgressPage(ModelMap model, HttpSession session){
        return "progress";
    }
}

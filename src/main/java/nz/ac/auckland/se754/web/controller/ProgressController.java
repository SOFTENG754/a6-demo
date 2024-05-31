package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.backend.exception.NoUserFoundException;
import nz.ac.auckland.se754.web.backend.exception.PrivateProgressException;
import nz.ac.auckland.se754.web.model.LearningProgress;
import nz.ac.auckland.se754.web.model.User;
import nz.ac.auckland.se754.web.service.LearningProgressManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@SessionAttributes("name")
public class ProgressController {

    @RequestMapping(value="/progress", method = RequestMethod.GET)
    public String showProgressPage(ModelMap model, HttpSession session) throws NoUserFoundException, PrivateProgressException {
        User newUser = new User("newUser");
        User returnUser = new User("returnUser");
        LearningProgressManager.initialize(newUser, returnUser);
        String name = (String) model.get("name");
        String ownProgress ="";

        if(Objects.equals(name, newUser.username)){
            ownProgress = newUser.getLearningProgress().getNumberOfCompletedCourses() + " course completed";
        }else{
            ownProgress = returnUser.getLearningProgress().getNumberOfCompletedCourses() + " courses completed";

        }

        model.put("ownProgress", ownProgress);

        return "progress";
    }

    @RequestMapping(value="/progress", method = RequestMethod.POST)
    public String showProgressPage(ModelMap model) throws NoUserFoundException, PrivateProgressException {
        String otherProgress = String.valueOf(LearningProgressManager.getLearningProgress("newUser").getNumberOfCompletedCourses()) + " course completed" ;
        model.put("otherProgress", otherProgress);
        return "progress";
    }
}

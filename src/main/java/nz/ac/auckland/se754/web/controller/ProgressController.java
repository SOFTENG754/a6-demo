package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.backend.exception.NoUserFoundException;
import nz.ac.auckland.se754.web.backend.exception.PrivateProgressException;
import nz.ac.auckland.se754.web.service.LearningProgressManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class ProgressController {

    @RequestMapping(value="/progress", method = RequestMethod.GET)
    public String showProgressPage(ModelMap model, HttpSession session) throws NoUserFoundException, PrivateProgressException {
        LearningProgressManager.initialize();
        String name = (String) model.get("name");

        String ownProgress = LearningProgressManager.getLearningProgress(name).getNumberOfCompletedCourses() + " course completed";
        model.put("ownProgress", ownProgress);
        return "progress";
    }
}

package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.User;
import nz.ac.auckland.se754.web.service.Database;
import nz.ac.auckland.se754.web.service.Profile;
import org.mockito.Mockito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfilePage() {
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String changeUsername(ModelMap model, @RequestParam String newUsername, HttpSession session) {
        User dummyUser = Mockito.mock(User.class);
        Database mockDB = Mockito.mock(Database.class);
        Mockito.when(mockDB.checkUsernameExists("user1")).thenReturn(false);

        Profile service = new Profile(mockDB);
        boolean isValidUsername = service.validateUsername(newUsername);

        if (isValidUsername) {
            service.updateUsername(dummyUser, newUsername);
            model.addAttribute("alertMessage", "Your username has been changed to " + newUsername);
        } else {
            model.addAttribute("alertMessage", "Username is taken or is invalid");
        }

        return "profile";
    }
}

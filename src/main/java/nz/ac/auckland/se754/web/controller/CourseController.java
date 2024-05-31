package nz.ac.auckland.se754.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {

    @GetMapping("/course/{courseid}")
    public String getLessonPage(@PathVariable("courseid") int courseid, Model model) {

        String progress = "";
        switch (courseid){
            case 1:
                progress =  "0/2";
                break;
            case 2:
                progress = "1/2";
                break;
            case 3:
                progress = "2/3";
                break;
            case 4:
                progress= "3/4";
                break;
            default: // Add a default case to handle other course IDs
                progress = "N/A"; // Or any other default progress value
                break;
        }
        model.addAttribute("courseid", courseid);
        model.addAttribute("progress", progress);
        return "course"; // This will map to /WEB-INF/jsp/lesson.jsp
    }
}

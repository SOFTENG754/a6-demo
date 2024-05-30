package nz.ac.auckland.se754.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {
    @GetMapping("/course/{courseid}/lesson/{lessonid}")
    public String getLessonPage(@PathVariable("courseid") int courseid, @PathVariable("lessonid") int lessonid, Model model) {
        model.addAttribute("courseid", courseid);
        model.addAttribute("lessonid", lessonid);
        return "lesson"; // This will map to /WEB-INF/jsp/lesson.jsp
    }

    @GetMapping("/course/{courseid}")
    public String getLessonPage(@PathVariable("courseid") int courseid, Model model) {
        model.addAttribute("courseid", courseid);
        return "course"; // This will map to /WEB-INF/jsp/lesson.jsp
    }
}

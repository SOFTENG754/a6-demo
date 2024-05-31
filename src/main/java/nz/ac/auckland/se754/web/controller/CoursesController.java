package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.CourseItem;
import nz.ac.auckland.se754.web.model.Item;
import nz.ac.auckland.se754.web.service.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import nz.ac.auckland.se754.web.service.Questions;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("name")
public class CoursesController {
	
	@Autowired
	Courses service;
	
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public ModelAndView showQuestions(ModelMap model){
		String name = (String) model.get("name");
		List<CourseItem> itemList = service.retrieveCourses(name);
		ModelAndView map = new ModelAndView("/courses");
		map.addObject("courselists", itemList);
		return map;
	}

	@RequestMapping(value="/courses/toggleInterest", method = RequestMethod.POST)
	public String toggleInterest(@RequestParam("id") int id) {
		service.toggleInterest(id);
		return "redirect:/courses";
	}

	@RequestMapping(value="/courses/{courseNumber}", method = RequestMethod.GET)
	public String goToCourse(@PathVariable("courseNumber") int courseNumber, ModelMap model) {
		String progress = "";
		switch (courseNumber){
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
		model.addAttribute("courseid", courseNumber);
		model.addAttribute("progress", progress);
		return "course";
	}
}

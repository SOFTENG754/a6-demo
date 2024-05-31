package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.backend.exception.InvalidCourseProgressException;
import nz.ac.auckland.se754.web.model.CourseItem;
import nz.ac.auckland.se754.web.model.CourseProgress;
import nz.ac.auckland.se754.web.model.Item;
import nz.ac.auckland.se754.web.service.Courses;
import org.mockito.Mockito;
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
	public String goToCourse(@PathVariable("courseNumber") int courseNumber, ModelMap model) throws InvalidCourseProgressException {
		String name = (String) model.get("name");
		CourseProgress courseProgress = service.retrieveUserProgress(name, courseNumber);
//		CourseProgress courseProgress = Mockito.mock(CourseProgress.class);
//		Mockito.when(courseProgress.getProgress()).thenReturn(0);
		String progress = courseProgress.getProgress() + "/" + courseProgress.getCourseItem().getCourse().getLessons().length;

		model.put("courseid", courseNumber);
		model.put("progress", progress);
		return "course";
	}
}

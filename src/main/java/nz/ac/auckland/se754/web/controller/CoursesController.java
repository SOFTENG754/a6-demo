package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.Questions;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("name")
public class CoursesController {
	
	@Autowired
	Questions service;
	
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public ModelAndView showQuestions(ModelMap model){
		String name = (String) model.get("name");
		List<Item> itemList = service.retrieveQuestions(name);
		ModelAndView map = new ModelAndView("/courses");
		map.addObject("lists", itemList);
		return map;
	}
}

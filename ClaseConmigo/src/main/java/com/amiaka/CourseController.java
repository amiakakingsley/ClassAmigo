package com.amiaka;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amiaka.CourseService.CourseService;
import com.amiaka.ModelDto.CourseDto;

@Controller
public class CourseController {

	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@GetMapping("/user/getAllCourses")
	public ModelAndView modelAndView(ModelAndView modelAandView) {
		List<CourseDto> courses = courseService.findAll();
		modelAandView.addObject("courses", courses);
		modelAandView.setViewName("home");
		return modelAandView;
	}
}

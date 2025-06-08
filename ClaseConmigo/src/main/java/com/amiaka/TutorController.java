package com.amiaka;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amiaka.CourseService.CourseService;
import com.amiaka.ModelDto.CourseDto;


import jakarta.servlet.http.HttpSession;

@Controller
public class TutorController {

	private final CourseService courseService;

	public TutorController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/tutor/home")
	public String home(HttpSession httpSession) {
		httpSession.getAttribute("usename");
		return "Tutor";
	}

	@PostMapping("/tutor/create-course")
	public String create_course(CourseDto courseDto, RedirectAttributes redirectAttributes, HttpSession httpSession){
		httpSession.getAttribute("username");
		courseService.Safe_courses(courseDto);

		return "redirect:/tutor/home";
	}
	
	@GetMapping("/tutor/crete-call")
	public ResponseEntity<String> createCallSession(){
		String sessionId = UUID.randomUUID().toString();
		
		System.out.println("this is where i day like this");
		
		String callUrl = "http://localhost:8080/vidoe-call/" + sessionId;
		
		return ResponseEntity.ok(callUrl);
	}
	
	
	
	
}

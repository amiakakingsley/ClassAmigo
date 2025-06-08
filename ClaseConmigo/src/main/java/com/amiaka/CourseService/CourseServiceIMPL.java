package com.amiaka.CourseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amiaka.ModelDto.CourseDto;
import com.amiaka.Models.ApplicationUser;
import com.amiaka.Models.Courses;
import com.amiaka.Repository.CoursesRepository;
import com.amiaka.Userservice.UserService;
@Service
public class CourseServiceIMPL implements CourseService {
	
	private final CoursesRepository coursesRepository;
	private final UserService userService;
	
	public CourseServiceIMPL(CoursesRepository coursesRepository, 
			UserService userService) {
		super();
		this.coursesRepository = coursesRepository;
		this.userService = userService;
		
	}
	
	@Override
	public boolean Safe_courses(CourseDto courseDto) {
	     ApplicationUser user = userService.getPrincipal();
		
        Courses course = new Courses();
        course.setApplicationUser(user);
        course.setCourseName(courseDto.getCourseName());
        course.setDescription(courseDto.getDescription());
        course.setName(user.getFirstname() + " " + user.getLastname());
        course.setPrice(courseDto.getPrice());
        
        coursesRepository.save(course);
        return true;
	}

	@Override
	public List<CourseDto> findByFullname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> findAll() {
		
		List<Courses> availableCourses = coursesRepository.findAll();
		
		List<CourseDto> courseDto = new ArrayList<>();
		
		for(Courses courses : availableCourses) {
			CourseDto courseDto2 = new CourseDto();
			courseDto2.setId(courses.getId());
			courseDto2.setName(courses.getName());
			courseDto2.setPrice(courses.getPrice());
			courseDto2.setDescription(courses.getDescription());
			courseDto2.setCourseName(courses.getCourseName());

			courseDto.add(courseDto2);
		
		}
 		
		return courseDto;
	}

}

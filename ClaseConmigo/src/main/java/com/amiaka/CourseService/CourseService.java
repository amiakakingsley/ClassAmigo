package com.amiaka.CourseService;

import java.util.List;

import com.amiaka.ModelDto.CourseDto;

public interface CourseService {

	boolean Safe_courses(CourseDto sourseDto);
	
	List<CourseDto> findByFullname(String name);
	
	List<CourseDto> findAll();
	
}

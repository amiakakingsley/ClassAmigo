package com.amiaka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}

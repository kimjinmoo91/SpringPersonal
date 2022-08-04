package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
//CourseRepository: SQL 대체 역할       Course라는 대상이고, id는 Long이다
}
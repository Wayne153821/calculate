package com.size.service;

import java.util.List;

import com.size.entity.Grade;



public interface GradeService {
	
	List<Grade> findAllGrades();
	
	int AddGrade(Grade g);
	
	List<Grade> findTodayGrades(String now_time);
	
	List<Grade> findFive();
}

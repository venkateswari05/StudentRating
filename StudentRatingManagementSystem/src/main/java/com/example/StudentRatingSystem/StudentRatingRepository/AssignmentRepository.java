package com.example.StudentRatingSystem.StudentRatingRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentRatingSystem.Model.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
	
	@Query(value="SELECT subject_subject_id, student_sid, category_category_name, score from assignment where student_sid=500 group by category_category_name, subject_subject_id,student_sid")
	public Iterable<Object> getAllAssignments();
}

package com.example.StudentRatingSystem.StudentRatingRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.StudentRatingSystem.Model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}

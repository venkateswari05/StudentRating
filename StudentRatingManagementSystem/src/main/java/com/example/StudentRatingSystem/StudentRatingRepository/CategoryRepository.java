package com.example.StudentRatingSystem.StudentRatingRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.StudentRatingSystem.Model.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
}

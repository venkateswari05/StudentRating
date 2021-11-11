package com.example.StudentRatingSystem.StudentRatingService;

import com.example.StudentRatingSystem.Model.Assignment;
import com.example.StudentRatingSystem.Model.Category;
import com.example.StudentRatingSystem.Model.Student;
import com.example.StudentRatingSystem.Model.Subject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface StudentRatingServiceInf {

    public boolean addCategory(Category category);
    public boolean addAssignment(Assignment assignment);
    public boolean addSubject(Subject subject);
    public boolean addStudent(Student student);

    public Category getCategory(String category);
    public Assignment getAssignment(int assignment);
    public Subject getSubject(int subject);
    public Student getStudent(int student);

    public boolean addCategoryToAssignment(String categoryName, int assignmentId);
    public void addSubjectsToStudent(ArrayList<Integer> subjects, int studentId);
    public void submitAssignments(ArrayList<Integer> assignments, int subjectId, int studentId);
    public List<Object> getAssignmentDetails(int studentId);
}

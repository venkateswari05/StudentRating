package com.example.StudentRatingSystem.StudentRatingController;

import com.example.StudentRatingSystem.Model.Assignment;
import com.example.StudentRatingSystem.Model.Category;
import com.example.StudentRatingSystem.Model.Student;
import com.example.StudentRatingSystem.Model.Subject;
import com.example.StudentRatingSystem.StudentRatingService.StudentRatingServiceInf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentRatingController {
    @Autowired
    StudentRatingServiceInf studentRatingServiceInf;

    @RequestMapping(value = "/add/category", method = RequestMethod.POST)
    public boolean addCategory(@RequestBody Category category){
        return studentRatingServiceInf.addCategory(category);
    }
    @RequestMapping(value = "/add/assignment", method = RequestMethod.POST)
    public boolean addAssignment(@RequestBody Assignment assignment){
        return studentRatingServiceInf.addAssignment(assignment);
    }
    @RequestMapping(value = "/add/subject", method = RequestMethod.POST)
    public boolean addSubject(@RequestBody Subject subject){
        return studentRatingServiceInf.addSubject(subject);
    }
    @RequestMapping(value = "/add/student", method = RequestMethod.POST)
    public boolean addStudent(@RequestBody Student student){
        return studentRatingServiceInf.addStudent(student);
    }

    @RequestMapping(value = "/get/{categoryId}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable String categoryId){
        return studentRatingServiceInf.getCategory(categoryId);
    }
    @RequestMapping(value = "/get/{assignmentId}", method = RequestMethod.GET)
    public Assignment getAssignment(@PathVariable int assignmentId){
        return studentRatingServiceInf.getAssignment(assignmentId);
    }
    @RequestMapping(value = "/get/{subjectId}", method = RequestMethod.GET)
    public Subject getSubject(@PathVariable int subjectId){
        return studentRatingServiceInf.getSubject(subjectId);
    }
    @RequestMapping(value = "/get/{studentId}", method = RequestMethod.GET)
    public Student getStudent(@RequestBody int studentId) {
        return studentRatingServiceInf.getStudent(studentId);
    }

    @RequestMapping(value = "/assign/categoryToAssignment/{categoryName}/{assignmentId}", method = RequestMethod.PUT)
    public boolean addCategoryToAssignment(@PathVariable String categoryName, @PathVariable int assignmentId){
        return studentRatingServiceInf.addCategoryToAssignment(categoryName, assignmentId);
    }
    
    @RequestMapping(value = "/assign/subjectToStudent/{studentId}", method = RequestMethod.PUT)
    public void addSubjectsToStudent(@RequestBody ArrayList<Integer> subjectsIds, @PathVariable int studentId) {
    	studentRatingServiceInf.addSubjectsToStudent(subjectsIds, studentId);
    	
    }
    
    @RequestMapping(value = "/submit/assignment/{subjectId}/{studentId}", method = RequestMethod.PUT)
    public void addAssignmentsToSubject(@RequestBody ArrayList<Integer> assignments,@PathVariable int subjectId, @PathVariable int studentId) {
    	studentRatingServiceInf.submitAssignments(assignments, subjectId, studentId);
    }
    
    @RequestMapping(value = "/get/assignment/details/{studentId}")
    public List<Object> getAssignmentDetails(int studentId){
    	return (List<Object>) studentRatingServiceInf.getAssignmentDetails(studentId);
    }
}

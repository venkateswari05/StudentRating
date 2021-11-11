package com.example.StudentRatingSystem.StudentRatingServiceImpl;

import com.example.StudentRatingSystem.Model.Assignment;
import com.example.StudentRatingSystem.Model.Category;
import com.example.StudentRatingSystem.Model.Student;
import com.example.StudentRatingSystem.Model.Subject;
import com.example.StudentRatingSystem.StudentRatingRepository.AssignmentRepository;
import com.example.StudentRatingSystem.StudentRatingRepository.CategoryRepository;
import com.example.StudentRatingSystem.StudentRatingRepository.StudentRatingRepository;
import com.example.StudentRatingSystem.StudentRatingRepository.SubjectRepository;
import com.example.StudentRatingSystem.StudentRatingService.StudentRatingServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentRatingServiceImpl implements StudentRatingServiceInf {

    @Autowired
    StudentRatingRepository studentRatingRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean addCategory(Category category) {

        Optional optional  = categoryRepository.findById(category.getCategoryName());
        if(optional.isPresent()){
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.CONFLICT, " the catogory already presents");
            }

        }else{
            categoryRepository.save(category);
            return true;
        }
    }

    @Override
    public boolean addAssignment(Assignment assignment) {
        Optional optional  = assignmentRepository.findById(assignment.getAssignmentId());
        if(optional.isPresent()){
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.CONFLICT, " the assignment is already present");
            }

        }else{
            assignmentRepository.save(assignment);
            return true;
        }
    }

    @Override
    public boolean addSubject(Subject subject) {

        Optional optional  = subjectRepository.findById(subject.getSubjectId());
        if(optional.isPresent()){
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.CONFLICT, " the assignment is already present");
            }

        }else{
            subjectRepository.save(subject);
            return true;
        }

    }

    @Override
    public boolean addStudent(Student student) {

        Optional optional  = studentRatingRepository.findById(student.getSid());
        if(optional.isPresent()){
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.CONFLICT, " the assignment is already present");
            }

        }else{
            studentRatingRepository.save(student);
            return true;
        }
    }

    @Override
    public Category getCategory(String category) {
        Optional optional  = categoryRepository.findById(category);
        if(optional.isPresent()){
            return (Category) optional.get();

        }else{
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the category is not present");
            }
        }
    }

    @Override
    public Assignment getAssignment(int assignmentId) {
        Optional optional  = assignmentRepository.findById(assignmentId);
        if(optional.isPresent()){
            return (Assignment) optional.get();

        }else{
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the assignment is not present");
            }
        }
    }

    @Override
    public Subject getSubject(int subjectId) {
        Optional optional  = subjectRepository.findById(subjectId);
        if(optional.isPresent()){
            return (Subject) optional.get();

        }else{
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the subject is not present");
            }
        }
    }

    @Override
    public Student getStudent(int studentId) {
        Optional optional  = studentRatingRepository.findById(studentId);
        if(optional.isPresent()){
            return (Student) optional.get();

        }else{
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the Student is not present");
            }
        }
    }

    @Override
    public boolean addCategoryToAssignment(String categoryName, int assignmentId) {

        Optional optionalCategory  = categoryRepository.findById(categoryName);
        if(optionalCategory.isPresent()){

            Optional optionalAssignment  = assignmentRepository.findById(assignmentId);
            if(optionalAssignment.isPresent()){
                Assignment ass = (Assignment) optionalAssignment.get();
                ass.setCategory((Category) optionalCategory.get());
                assignmentRepository.save(ass);
                return true;
            }else {

                try{
                    throw new RuntimeException("Error Occurred");
                }catch (Exception e){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the Assignment is not present");
                }
            }

        }else{
            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " the Category is not present");
            }
        }

    }

    @Override
    public void addSubjectsToStudent(ArrayList<Integer> subjectIds, int studentId) {

        Optional optionalStudent  = studentRatingRepository.findById(studentId);


        ArrayList<Subject> presentSubjects = null;
        if(optionalStudent.isPresent()){

            Student tempStudent = (Student) optionalStudent.get();
            List<Subject> subjectList = (List<Subject>) tempStudent.getSubject();

            for(Integer s : subjectIds){

                Optional optionalSubject  = subjectRepository.findById(s);
                if(optionalSubject.isPresent()){

                    if(subjectList.contains(optionalSubject.get())){
                        presentSubjects.add((Subject) optionalSubject.get());
                    }else {
                        subjectList.add((Subject) optionalSubject.get());
                    }

                }else{

                    try{
                        throw new RuntimeException("Error Occurred");
                    }catch (Exception e){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, " The Subject is not present");
                    }
                }
            }
            tempStudent.setSubject(subjectList);
            studentRatingRepository.save(tempStudent);

        }else{

            try{
                throw new RuntimeException("Error Occurred");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " The Student is not present");
            }
        }
    }

	@Override
	public void submitAssignments(ArrayList<Integer> assignments, int subjectId, int studentId) {
		
		Optional optionalSubject = subjectRepository.findById(subjectId);
		Optional optionalStudent = studentRatingRepository.findById(studentId);
		ArrayList<Assignment> presentAssignments = null;
		if(optionalStudent.isPresent()) {
			
		
			if(optionalSubject.isPresent()) {
				
				Subject tempSubject =  (Subject) optionalSubject.get();
				List<Assignment> assignmentList = (List<Assignment>) tempSubject.getAssignment();
				
				for(Integer a : assignments){
					Optional optionalAssignment  = assignmentRepository.findById(a);
					if(optionalAssignment.isPresent()) {
						
						if(assignmentList.contains(optionalAssignment.get())){
							presentAssignments.add((Assignment) optionalAssignment.get());
	                    }else {
	                    	
	                    	Assignment as = (Assignment) optionalAssignment.get();
	                    	Student student = (Student) optionalStudent.get();
	                    	as.setSubject(tempSubject);
	                    	as.setStudent(student);
	                    	assignmentRepository.save(as);
	                    	assignmentList.add(as);
	                    }
					}else {
						
						try{
	                        throw new RuntimeException("Error Occurred");
	                    }catch (Exception e){
	                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, " The Assignment is not present");
	                    }
					}
				}
				tempSubject.setAssignment(assignmentList);
				subjectRepository.save(tempSubject);
				
			}else{
	
	            try{
	                throw new RuntimeException("Error Occurred");
	            }catch (Exception e){
	                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " The Subject is not present");
	            }
	        }
		
		}else {
			 try{
	                throw new RuntimeException("Error Occurred");
	            }catch (Exception e){
	                throw new ResponseStatusException(HttpStatus.NOT_FOUND, " The Student is not present");
	            }
		}
		
	}

	@Override
	public List<Object> getAssignmentDetails(int studentId) {
		
		Iterable<Object> assignmentList =  assignmentRepository.getAllAssignments();
		
		return (List<Object>) assignmentList;
	}


}

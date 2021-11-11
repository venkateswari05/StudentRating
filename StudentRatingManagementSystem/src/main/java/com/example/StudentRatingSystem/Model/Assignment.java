package com.example.StudentRatingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.Objects;

@Entity
public class Assignment {
    @Id
    private int assignmentId;
    private int score;
    @OneToOne
    private Category category;
    private Date submissionDate;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Student student; 

	public Assignment(){}

    public Assignment(int assignmentId, int score, Category category, Date submissionDate, Subject subject,
			Student student) {
		
		this.assignmentId = assignmentId;
		this.score = score;
		this.category = category;
		this.submissionDate = submissionDate;
		this.subject = subject;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}
    
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", score=" + score + ", category=" + category
				+ ", submissionDate=" + submissionDate + ", subject=" + subject + ", student=" + student + "]";
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		if (assignmentId != other.assignmentId)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (score != other.score)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentId;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + score;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		return result;
	}
}

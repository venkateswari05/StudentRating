package com.example.StudentRatingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    private int sid;
    private String sName;
    @ManyToMany
    private List<Subject> subject;
    @OneToMany(mappedBy = "student")
    private List<Assignment> assignment;

    public Student(){}

    public Student(int sid, String sName, List<Subject> subject, List<Assignment> assignment) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.subject = subject;
		this.assignment = assignment;
	}

	public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    @Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", subject=" + subject + ", assignment=" + assignment + "]";
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sid != other.sid)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + sid;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}
}

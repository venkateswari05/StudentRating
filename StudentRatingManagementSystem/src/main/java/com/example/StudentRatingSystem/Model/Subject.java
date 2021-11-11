package com.example.StudentRatingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
@Entity
public class Subject {
    @Id
    private int subjectId;
    private String name;
    @OneToMany(mappedBy = "subject")
    private List<Assignment> assignment;

    public Subject(){}

    public Subject(int subjectId, String name, List<Assignment> assignment) {
        this.subjectId = subjectId;
        this.name = name;
        this.assignment = assignment;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assignment> getAssignment() {
        return assignment;
    }

    public void setAssignment(List<Assignment> assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", assignment=" + assignment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId && Objects.equals(name, subject.name) && Objects.equals(assignment, subject.assignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, assignment);
    }
}

package com.example.StudentRatingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Category {

    @Id
    private String categoryName;
    private int maxMarks;
    @OneToOne(mappedBy = "category")
    private Assignment assignment;

    public Category() {}

    public Category(String categoryName, int maxMarks) {
        this.categoryName = categoryName;
        this.maxMarks = maxMarks;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", maxMarks=" + maxMarks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return maxMarks == category.maxMarks && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, maxMarks);
    }
}

package java.course;

import java.assignment.Assignment;
import java.util.List;

public class Course {
    private String courseName;
    private List<Assignment> assignments;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}

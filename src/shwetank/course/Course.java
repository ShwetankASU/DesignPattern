package shwetank.course;

import shwetank.assignment.Assignment;
import shwetank.enums.CourseLevelType;

import java.util.List;

public class Course {
    private String courseName;
    private List<Assignment> assignments;
    private CourseLevelType courseLevelType;

    public Course(String courseName, CourseLevelType courseLevelType) {
        this.courseName = courseName;
        this.courseLevelType = courseLevelType;
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

    public CourseLevelType getCourseLevel(){
        return courseLevelType;
    }
}

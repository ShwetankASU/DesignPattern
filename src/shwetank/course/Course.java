package shwetank.course;

import shwetank.assignment.Assignment;
import shwetank.enums.CourseLevelEnum;
import shwetank.reminder.NodeVisitor;
import shwetank.reminder.Reminder;

import java.util.ArrayList;
import java.util.List;

public class Course implements Reminder {
    private String courseName;
    private List<Assignment> assignments;
    private CourseLevelEnum courseLevelEnum;

    public Course(String courseName, CourseLevelEnum courseLevelEnum) {
        assignments = new ArrayList<>();
        this.courseName = courseName;
        this.courseLevelEnum = courseLevelEnum;
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

    public CourseLevelEnum getCourseLevel(){
        return courseLevelEnum;
    }

    @Override
    public void addNodeVisitor(NodeVisitor visitor) {
        visitor.visitCourse(this);
    }
}

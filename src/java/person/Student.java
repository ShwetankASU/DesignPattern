package java.person;

import java.course.CourseMenu;
import java.enums.CourseLevelType;

public class Student extends Person {

    public Student(CourseMenu courseMenu) {
        super(courseMenu);
    }

    @Override
    public void showMenu() {

    }

    @Override
    public void createCourseMenu(CourseLevelType courseLevelType) {

    }

}

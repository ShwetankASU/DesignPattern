package java.person;

import java.course.CourseMenu;
import java.enums.CourseLevelType;

public class Teacher extends Person {

    public Teacher(CourseMenu courseMenu) {
        super(courseMenu);
    }

    @Override
    public void showMenu() {

    }

    @Override
    public void createCourseMenu(CourseLevelType courseLevelType) {

    }

}

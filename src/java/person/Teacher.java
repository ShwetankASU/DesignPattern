package java.person;

import java.course.CourseMenu;
import java.enums.CourseLevelType;
import java.enums.UserType;
import java.factory.CourseFactory;

public class Teacher extends Person {

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        showRadioButton();
        showComBoxes();
        showLabels();
    }

    @Override
    public CourseMenu createCourseMenu(CourseLevelType courseLevelType) {
        CourseMenu courseMenu = new CourseFactory().getCourseMenu(UserType.TEACHER, courseLevelType);
        updateCourseLevel(courseMenu);
        return courseMenu;
    }

}

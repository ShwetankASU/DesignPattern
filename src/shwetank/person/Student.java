package shwetank.person;

import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelType;
import shwetank.enums.UserType;
import shwetank.factory.CourseFactory;

public class Student extends Person {

    @Override
    public void showMenu() {
        showViewButton();
        showRadioButton();
        showComBoxes();
        showLabels();
    }

    @Override
    public CourseMenu createCourseMenu(CourseLevelType courseLevelType) {
        CourseMenu courseMenu = new CourseFactory().getCourseMenu(UserType.STUDENT, courseLevelType);
        updateCourseLevel(courseMenu);
        return courseMenu;
    }

}

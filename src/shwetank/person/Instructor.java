package shwetank.person;

import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelEnum;
import shwetank.enums.UserType;
import shwetank.factory.CourseFactory;
//Bridge Design Pattern
//Factory Design Pattern
public class Instructor extends Person {

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        showRadioButton();
        showComBoxes();
        showLabels();
    }

    @Override
    public CourseMenu createCourseMenu(CourseLevelEnum courseLevelEnum) {
        CourseMenu courseMenu = new CourseFactory().getCourseMenu(UserType.INSTRUCTOR, courseLevelEnum);
        updateMenu(courseMenu);
        return courseMenu;
    }

}

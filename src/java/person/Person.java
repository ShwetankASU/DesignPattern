package java.person;

import java.course.CourseMenu;
import java.enums.CourseLevelType;
import java.util.ArrayList;

public abstract class Person {

    private CourseMenu mCourseMenu;
    public ArrayList courseList = new ArrayList();

    Person() {

    }

    void showAddButton() {
        mCourseMenu.showAddButton();
    }

    void showViewButton() {
        mCourseMenu.showViewButton();
    }

    void showRadioButton() {
        mCourseMenu.showRadioButton();
    }

    void showLabels() {
        mCourseMenu.showLabels();
    }

    void showComBoxes() {
        mCourseMenu.showComBoxes();
    }

    void updateCourseLevel(CourseMenu courseMenu) {
        this.mCourseMenu = courseMenu;
    }

    public abstract void showMenu();

    public abstract CourseMenu createCourseMenu(CourseLevelType courseLevelType);
}

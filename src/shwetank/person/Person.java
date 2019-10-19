package shwetank.person;

import shwetank.course.Course;
import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelEnum;

import java.util.ArrayList;

public abstract class Person {

    private CourseMenu mCourseMenu;

    private ArrayList<Course> mCourseList = new ArrayList<>();

    public abstract void showMenu();

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

    void updateMenu(CourseMenu courseMenu) {
        this.mCourseMenu = courseMenu;
    }

    public abstract CourseMenu createCourseMenu(CourseLevelEnum courseLevelEnum);

    public void addCourse(Course course) {
        mCourseList.add(course);
    }

    public void removeCourse(Course course) {
        mCourseList.remove(course);
    }

}

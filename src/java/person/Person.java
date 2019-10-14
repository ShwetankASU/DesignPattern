package java.person;

import java.course.CourseMenu;
import java.enums.CourseLevelType;

public abstract class Person {

    private CourseMenu mCourseMenu;

    public Person(CourseMenu mCourseMenu) {
        this.mCourseMenu = mCourseMenu;
    }

    public void showAddButton(){

    }

    public void showViewButton(){

    }

    public void showRadioButton(){

    }

    public void showLabels(){

    }

    public abstract void showMenu();
    public abstract void createCourseMenu(CourseLevelType courseLevelType);
}

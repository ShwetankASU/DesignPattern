package java.factory;

import java.course.CourseMenu;
import java.course.HighLevelCourseMenu;
import java.course.LowLevelCourseMenu;
import java.enums.CourseLevelType;
import java.enums.UserType;

public class CourseFactory extends Factory{

    @Override
    public CourseMenu getCourseMenu(UserType userType, CourseLevelType courseLevelType) {
        CourseMenu courseMenu = null;
        switch (userType){
            case STUDENT:
                courseMenu = getCourseMenu(courseLevelType);
                break;
            case TEACHER:
                courseMenu = getCourseMenu(courseLevelType);
                break;
        }
        return courseMenu;
    }

    private CourseMenu getCourseMenu(CourseLevelType courseLevelType) {
        CourseMenu courseMenu = null;
        switch (courseLevelType){
            case LOW:
                courseMenu = new LowLevelCourseMenu();
                break;
            case HIGH:
                courseMenu = new HighLevelCourseMenu();
                break;
        }
        return courseMenu;
    }
}

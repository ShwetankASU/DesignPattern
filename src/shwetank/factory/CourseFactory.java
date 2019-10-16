package shwetank.factory;

import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelType;
import shwetank.enums.UserType;
import shwetank.course.HighLevelCourseMenu;
import shwetank.course.LowLevelCourseMenu;

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

package java.factory;

import java.course.CourseMenu;
import java.enums.CourseLevelType;
import java.enums.UserType;

public abstract class Factory {

     public abstract CourseMenu getCourseMenu(UserType userType, CourseLevelType courseLevelType);

}

package shwetank.factory;

import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelType;
import shwetank.enums.UserType;

public abstract class Factory {

     public abstract CourseMenu getCourseMenu(UserType userType, CourseLevelType courseLevelType);

}

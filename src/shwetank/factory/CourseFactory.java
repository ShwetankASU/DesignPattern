package shwetank.factory;

import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelEnum;
import shwetank.enums.UserType;
import shwetank.course.HighLevelCourseMenu;
import shwetank.course.LowLevelCourseMenu;

public class CourseFactory extends Factory{

    @Override
    public CourseMenu getCourseMenu(UserType userType, CourseLevelEnum courseLevelEnum) {
        return userType == UserType.STUDENT ? getStudentCourseMenuForCourseLevel(courseLevelEnum) : getInstructorCourseMenuForCourseLevel(courseLevelEnum);
    }

    private CourseMenu getStudentCourseMenuForCourseLevel(CourseLevelEnum courseLevelEnum) {
        return courseLevelEnum == CourseLevelEnum.LOW ? new LowLevelCourseMenu() : new HighLevelCourseMenu();
    }

    private CourseMenu getInstructorCourseMenuForCourseLevel(CourseLevelEnum courseLevelEnum) {
        return courseLevelEnum == CourseLevelEnum.LOW ? new LowLevelCourseMenu() : new HighLevelCourseMenu();
    }

}

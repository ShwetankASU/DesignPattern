package java.factory;

import java.course.CourseMenu;
import java.course.HighLevelCourseMenu;
import java.course.LowLevelCourseMenu;
import java.enums.CourseLevelType;
import java.enums.UserType;
import java.person.Person;
import java.person.Student;
import java.person.Teacher;

public class PersonFactory extends Factory{

    @Override
        public Person getPerson(UserType userType, CourseLevelType courseLevelType) {
        Person person = null;
        switch (userType){
            case STUDENT:
                person = new Student(getCourseMenu(courseLevelType));
                break;
            case TEACHER:
                person = new Teacher(getCourseMenu(courseLevelType));
                break;
        }
        return person;
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

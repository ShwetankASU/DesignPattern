package java;

import java.assignment.Assignment;
import java.course.Course;
import java.enums.CourseLevelType;
import java.enums.UserType;
import java.interfaces.FacadeManager;
import java.person.Person;
import java.person.UserInfoItem;
import java.util.ArrayList;
import java.util.Collections;

public class FacadeManagerImpl implements FacadeManager {
    private UserType userType;
    private Course theSelectedCourse;
    private CourseLevelType courseLevelType;
    private ArrayList courseList = (ArrayList) Collections.EMPTY_LIST;
    private Person person;

    public FacadeManagerImpl() {

    }

    /**
     * @return on successful login return true else false
     */
    @Override
    public boolean login() {
        return true;
    }

    @Override
    public void addAssignment() {
        Assignment a = new Assignment();
        //fill required information
        //either call teacher of student AssignmentMenu according to the user type
    }

    @Override
    public void viewAssignment() {

    }

    @Override
    public void gradeSolution() {

    }

    @Override
    public void reportSolutions() {

    }

    @Override
    public void submitSolution() {

    }

    @Override
    public void remind() {

    }

    @Override
    public void createUser(UserInfoItem userInfoItem) {
        //create user according to the information provided in UserInfoItem object (either student or teacher)
        //if wrong information is provided throw an exception (UnknownUserCreationException)
    }

    @Override
    public void createCourseList() {

    }

    @Override
    public void attachCourseToUser() {
        //if user is not yet created or not logged in throw UserNotAvailableException
    }

    @Override
    public Course selectCourse() {
        return new Course();
    }

    @Override
    public void courseOperation() {

    }
}

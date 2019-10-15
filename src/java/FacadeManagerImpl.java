package java;

import java.assignment.Assignment;
import java.assignment.AssignmentMenu;
import java.course.Course;
import java.enums.CourseLevelType;
import java.enums.UserType;
import java.factory.AssignmentMenuFactory;
import java.factory.PersonFactory;
import java.interfaces.FacadeManager;
import java.login.Login;
import java.person.Person;
import java.person.UserInfoItem;
import java.reminder.Reminder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FacadeManagerImpl implements FacadeManager {
    private UserType userType;
    private Course selectedCourse;
    private CourseLevelType courseLevelType;
    private List courseList = new ArrayList(0);
    private Person person;

    private FacadeManagerImpl (){
    }

    static FacadeManager getFacadeManager() {
        return new FacadeManagerImpl();
    }

    @Override
    public boolean login(String userName, String password) {
        Login login = new Login();
        return login.verifyUser(userName, password);
    }

    @Override
    public void addAssignment() {
        if(selectedCourse != null){
            Assignment a = new Assignment("New Assignment Text", new Date());
            a.setAssignmentText("New Assignment Text");
            selectedCourse.setAssignment(a);
        }

        //either call teacher of student AssignmentMenu according to the user type
        //Not sure how and when this will be used
        AssignmentMenuFactory assignmentMenuFactory = new AssignmentMenuFactory();
        AssignmentMenu assignmentMenu = assignmentMenuFactory.getAssignmentMenu(userType);
    }

    @Override
    public void createUser(UserInfoItem userInfoItem) {
        //if wrong information is provided throw an exception (UnknownUserCreationException)
        userType = userInfoItem.getUserType();
        person = new PersonFactory().getPerson(userInfoItem.getUserType());
    }

    @Override
    public void createCourseList() {

    }

    @Override
    public void attachCourseToUser() {
        //if user is not yet created or not logged in throw UserNotAvailableException
        if(person == null || selectedCourse == null){
            return;
        }
        person.courseList.add(selectedCourse);
    }

    @Override
    public void selectCourse() {
        selectCourseFromList(courseList);
    }

    @Override
    public void courseOperation() {
        person.createCourseMenu(courseLevelType);
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
        Reminder reminder = new Reminder();
    }

    private void selectCourseFromList(List courseList) {
        int number = getSelectedCourse(courseList);
        if(number == 0){
            return;
        }
        if(courseList.size() >= number){
            selectedCourse = (Course) courseList.get(number-1);
        }else{
            getSelectedCourse(courseList);
        }
    }

    private int getSelectedCourse(List list) {
        print("Course List:");
        for (int i = 0; i < list.size(); i++) {
            Course course = (Course) list.get(i);
            print( (i+1) +")" + course.getCourseName());
        }
        print("Please select any one course or Press 0 to exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void print(String message){
        System.out.println(message);
    }
}

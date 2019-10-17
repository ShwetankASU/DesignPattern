package shwetank;

import shwetank.assignment.AssignmentMenu;
import shwetank.course.Course;
import shwetank.course.CourseMenu;
import shwetank.enums.CourseLevelType;
import shwetank.enums.UserType;
import shwetank.interfaces.FacadeManager;
import shwetank.login.Login;
import shwetank.assignment.Assignment;
import shwetank.database.DatabaseManagerImpl;
import shwetank.factory.AssignmentMenuFactory;
import shwetank.factory.PersonFactory;
import shwetank.person.Person;
import shwetank.person.UserInfoItem;
import shwetank.reminder.Reminder;
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
    private Login login;

    private FacadeManagerImpl (){
    }

    static FacadeManager getFacadeManager() {
        return new FacadeManagerImpl();
    }

    @Override
    public boolean login(String userName, String password) {
        login = new Login(DatabaseManagerImpl.getInstance());

        DatabaseManagerImpl.User user = login.verifyUser(userName, password);
        if(user == null){
            return false;
        }
        userType = user.getUserType();
        person = new PersonFactory().getPerson(userType);
        return true;
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
        assignmentMenu.showAssignmentMenu();
    }

    @Override
    public void createUser(UserInfoItem userInfoItem) throws Exception {
        userType = userInfoItem.getUserType();
        person = new PersonFactory().getPerson(userInfoItem.getUserType());
        DatabaseManagerImpl.getInstance().createUser(userInfoItem);
    }

    @Override
    public void createCourseList() {
        courseList = DatabaseManagerImpl.getInstance().getCourseList();
    }

    @Override
    public void attachCourseToUser() {
        //if user is not yet created or not logged in throw UserNotAvailableException
        if(person == null || selectedCourse == null){
            return;
        }
        person.addCourse(selectedCourse);
    }

    @Override
    public void selectCourse() {
        selectCourseFromList(courseList);
    }

    @Override
    public void courseOperation() {
        CourseMenu courseMenu = person.createCourseMenu(courseLevelType);
        courseMenu.showMenu();
    }

    @Override
    public void viewAssignment() {
        AssignmentMenuFactory assignmentMenuFactory = new AssignmentMenuFactory();
        AssignmentMenu assignmentMenu = assignmentMenuFactory.getAssignmentMenu(userType);
        assignmentMenu.viewAssignment();
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
            if(selectedCourse.getCourseName().contains("890") || selectedCourse.getCourseName().contains("880")){
                courseLevelType = CourseLevelType.HIGH;
            }else{
                courseLevelType = CourseLevelType.LOW;
            }
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

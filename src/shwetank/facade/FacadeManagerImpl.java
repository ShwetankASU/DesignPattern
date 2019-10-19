package shwetank.facade;

import shwetank.assignment.Assignment;
import shwetank.assignment.AssignmentMenu;
import shwetank.course.Course;
import shwetank.database.DatabaseManagerImpl;
import shwetank.enums.CourseLevelEnum;
import shwetank.enums.UserType;
import shwetank.factory.AssignmentMenuFactory;
import shwetank.factory.PersonFactory;
import shwetank.iterator.ClassCourseList;
import shwetank.iterator.CourseIterator;
import shwetank.iterator.SolutionIterator;
import shwetank.iterator.SolutionList;
import shwetank.login.Login;
import shwetank.person.Person;
import shwetank.person.UserInfoItem;
import shwetank.reminder.ReminderVisitor;
import shwetank.solution.Solution;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//Facade Design Pattern
public class FacadeManagerImpl implements FacadeManager {
    private UserType mUserType;
    private Course mSelectedCourse;
    private CourseLevelEnum mCourseLevelEnum;
    private List mCourseList = new ArrayList(0);
    private Person mPerson;
    private Login mLogin;
    private ReminderVisitor mVisitor;

    private FacadeManagerImpl() {

    }

    public static FacadeManager getFacadeManager() {
        return new FacadeManagerImpl();
    }

    @Override
    public boolean doLogin(String userName, String password) {
        mLogin = new Login(DatabaseManagerImpl.getManager());
        DatabaseManagerImpl.User user = mLogin.verifyCredentials(userName, password);
        if (user == null) {
            return false;
        }
        mUserType = user.getUserType();
        mPerson = new PersonFactory().getPerson(mUserType);
        return true;
    }

    @Override
    public void addAssignment(String assignmentMessage) {
        Assignment assignment = new Assignment(assignmentMessage, new Date());
        mSelectedCourse.setAssignment(assignment);
        AssignmentMenuFactory assignmentMenuFactory = new AssignmentMenuFactory();
        AssignmentMenu assignmentMenu = assignmentMenuFactory.getAssignmentMenu(mUserType, assignment);
        assignmentMenu.showAssignmentMenu();
    }

    @Override
    public void createUser(UserInfoItem userInfoItem) {
        DatabaseManagerImpl.getManager().createUser(userInfoItem);
        mUserType = userInfoItem.getUserType();
        mPerson = new PersonFactory().getPerson(userInfoItem.getUserType());
    }

    @Override
    public void createCourseList() {
        mCourseList = DatabaseManagerImpl.getManager().getCourseList();
    }

    @Override
    public void attachCourseToUser() {
        if (mPerson == null || mSelectedCourse == null) {
            print("Either not logged in or course is not selected");
            return;
        }
        mPerson.addCourse(mSelectedCourse);
    }

    @Override
    public void selectCourse() {
        selectCourse(mCourseList);
    }

    @Override
    public void courseOperation() {
        mPerson.createCourseMenu(mCourseLevelEnum).showMenu();
    }

    @Override
    public void invalidate() {
        mUserType = null;
        mSelectedCourse = null;
        mCourseLevelEnum = null;
        mCourseList = new ArrayList(0);
        mPerson = null;
        mLogin = null;
        mVisitor = null;
    }

    @Override
    public void viewAssignment() {
        Assignment assignment = selectAssignmentFromCourse(mSelectedCourse, mSelectedCourse.getAssignments());
        if (assignment == null) {
            return;
        }
        AssignmentMenuFactory assignmentMenuFactory = new AssignmentMenuFactory();
        AssignmentMenu assignmentMenu = assignmentMenuFactory.getAssignmentMenu(mUserType, assignment);
        assignmentMenu.viewAssignment();
    }

    private Assignment selectAssignmentFromCourse(Course course, List<Assignment> assignments) {
        print("Select any assignment");
        if (assignments.size() > 0) {
            for (int index = 0; index < assignments.size(); index++) {
                print((index + 1) + ")" + assignments.get(index).getAssignmentText());
            }
            print("Please select any one assignment:");
            Scanner scanner = new Scanner(System.in);
            return assignments.get(scanner.nextInt() - 1);
        } else {
            print("No Assignment Available");
        }
        return null;
    }

    @Override
    public void gradeSolution() {
        if (mUserType == UserType.INSTRUCTOR) {
            print("Enter the Solution:");
            Scanner scanner = new Scanner(System.in);
            String providedSolution = scanner.next();
            Solution solution = new Solution(providedSolution);
            SolutionList solutionList = new SolutionList(new ArrayList<>());
            solutionList.arrayList.add(solution);
            mSelectedCourse.getAssignments().get(0).setSolutionList(solutionList);
            solution.setGrade(97);
        }
    }

    @Override
    public void reportSolutions() {
        if (mUserType == UserType.INSTRUCTOR) {

            Solution solution = null;
            SolutionList solutionList = mSelectedCourse.getAssignments().get(0).getSolutionList();
            SolutionIterator iterator = new SolutionIterator(solutionList);
            while (iterator.hasNext()) {
                solution = solutionList.arrayList.get(iterator.getCurrentIndex());
                if (solution.isGraded()) {
                    solution.reportSolution();
                    break;
                }
                iterator.next();
            }
            if (solution == null) {
                return;
            }
            if (solution.isReported()) {
                print("Assignment is graded with " + solution.getGrade());
            }
        }

    }

    @Override
    public void submitSolution() {
        if (mUserType == UserType.STUDENT) {
            print("Please Press 1 to Submit Assignment:");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                Assignment assignment = mSelectedCourse.getAssignments().get(0);
                assignment.submitAssignment();
                print("Assignment Submitted");
            }
        }
    }

    @Override
    public void remind() {
        mVisitor = new ReminderVisitor();
        mVisitor.visitFacade(this);
        mSelectedCourse.addNodeVisitor(mVisitor);
        mSelectedCourse.getAssignments().get(0).addNodeVisitor(mVisitor);
    }

    private void selectCourse(List<Course> courseList) {
        int number = getSelectedCourse(courseList);
        if (number == 0) {
            return;
        }
        if (courseList.size() >= number) {
            mSelectedCourse = courseList.get(number - 1);
            if (mSelectedCourse.getCourseName().contains("890") || mSelectedCourse.getCourseName().contains("880")) {
                mCourseLevelEnum = CourseLevelEnum.HIGH;
            } else {
                mCourseLevelEnum = CourseLevelEnum.LOW;
            }
        } else {
            getSelectedCourse(courseList);
        }
    }

    private int getSelectedCourse(List<Course> list) {
        ClassCourseList classCourseList = new ClassCourseList(list);
        CourseIterator iterator = new CourseIterator(classCourseList);
        print("Course List:");
        while (iterator.hasNext()) {
            int index = iterator.getCurrentIndex();
            Course course = (Course) iterator.next();
            print((index + 1) + ")" + course.getCourseName());
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void print(String message) {
        System.out.println(message);
    }
}

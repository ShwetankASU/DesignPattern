package java.interfaces;

import java.course.Course;
import java.person.UserInfoItem;

public interface FacadeManager {

    boolean login();
    void addAssignment();
    void viewAssignment();
    void gradeSolution();
    void reportSolutions();
    void submitSolution();
    void remind();
    void createUser(UserInfoItem userInfoItem);
    void createCourseList();
    void attachCourseToUser();
    Course selectCourse();
    void courseOperation();
}

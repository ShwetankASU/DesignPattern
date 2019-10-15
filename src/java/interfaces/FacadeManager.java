package java.interfaces;

import java.person.UserInfoItem;

public interface FacadeManager {

    boolean login(String userName, String password);
    void addAssignment();
    void viewAssignment();
    void gradeSolution();
    void reportSolutions();
    void submitSolution();
    void remind();
    void createUser(UserInfoItem userInfoItem);
    void createCourseList();
    void attachCourseToUser();
    void selectCourse();
    void courseOperation();
}

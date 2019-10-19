package shwetank.facade;

import shwetank.person.UserInfoItem;
//Facade Design Pattern
public interface FacadeManager {

    boolean doLogin(String userName, String password);
    void addAssignment(String assignment);
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
    void invalidate();
}

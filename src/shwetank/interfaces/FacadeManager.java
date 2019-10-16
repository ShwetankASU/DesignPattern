package shwetank.interfaces;

import shwetank.person.UserInfoItem;

public interface FacadeManager {

    boolean login(String userName, String password);
    void addAssignment();
    void viewAssignment();
    void gradeSolution();
    void reportSolutions();
    void submitSolution();
    void remind();
    void createUser(UserInfoItem userInfoItem) throws Exception;
    void createCourseList();
    void attachCourseToUser();
    void selectCourse();
    void courseOperation();
}

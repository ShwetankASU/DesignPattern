package java;

import java.enums.UserType;
import java.interfaces.FacadeManager;
import java.person.UserInfoItem;

public class Main {

    public static void main(String[] args){

        FacadeManager facadeManager = FacadeManagerImpl.getFacadeManager();

        facadeManager.createUser(new UserInfoItem(UserType.STUDENT));

        String userName = "abcd";
        String password = "pass";
        facadeManager.login(userName, password);
        facadeManager.attachCourseToUser();
        facadeManager.createCourseList();

        facadeManager.selectCourse();

        facadeManager.attachCourseToUser();

        facadeManager.courseOperation();
    }

}

package shwetank;

import shwetank.enums.UserType;
import shwetank.interfaces.FacadeManager;
import shwetank.person.UserInfoItem;

public class Main {

    public static void main(String[] args){

        FacadeManager facadeManager = FacadeManagerImpl.getFacadeManager();
        String userName = "shwetank";
        String password = "bhardwaj";
        try {
            facadeManager.createUser(new UserInfoItem(UserType.STUDENT, userName, password));
        } catch (Exception e) {
            e.printStackTrace();
        }

        facadeManager.login(userName, password);
        facadeManager.createCourseList();
        facadeManager.selectCourse();
        facadeManager.attachCourseToUser();
        facadeManager.courseOperation();
    }

}

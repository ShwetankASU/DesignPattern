package shwetank.database;

import shwetank.course.Course;
import shwetank.person.UserInfoItem;

import java.util.List;

public interface DatabaseManager {

    boolean verifyUser(String userName, String password);
    void createUser(UserInfoItem userInfoItem) throws Exception;
    List<Course> getCourseList();
}

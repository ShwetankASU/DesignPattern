package shwetank.database;

import shwetank.course.Course;
import shwetank.person.UserInfoItem;

import java.util.List;

public interface DatabaseManager {

    DatabaseManagerImpl.User verifyCredentials(String userName, String password);
    void createUser(UserInfoItem userInfoItem);
    List<Course> getCourseList();
}

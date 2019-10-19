package shwetank.database;

import shwetank.course.Course;
import shwetank.enums.CourseLevelEnum;
import shwetank.enums.UserType;
import shwetank.person.UserInfoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManagerImpl implements DatabaseManager {

    private static DatabaseManager mDatabaseManager;
    private Map<String, User> userDatabaseHashMap = new HashMap<>();
    private List<Course> courseList = new ArrayList<>();

    private DatabaseManagerImpl(){
        initialiseUserDatabase();
        initialiseCourseDatabase();
    }

    private void initialiseCourseDatabase() {
        courseList.add(new Course("CSE870", CourseLevelEnum.LOW));
        courseList.add(new Course("CSE880", CourseLevelEnum.LOW));
        courseList.add(new Course("CSE890", CourseLevelEnum.HIGH));
    }

    private void initialiseUserDatabase() {
        userDatabaseHashMap.put("pepe", new User(UserType.STUDENT, "1111"));
        userDatabaseHashMap.put("yaya", new User(UserType.STUDENT, "2222"));
        userDatabaseHashMap.put("yape", new User(UserType.STUDENT, "3333"));
        userDatabaseHashMap.put("Inst1", new User(UserType.INSTRUCTOR, "1111"));
    }

    public static DatabaseManager getManager(){
        if(mDatabaseManager == null){
            mDatabaseManager = new DatabaseManagerImpl();
        }
        return mDatabaseManager;
    }

    @Override
    public User verifyCredentials(String userName, String password) {
        if(userDatabaseHashMap.containsKey(userName) && userDatabaseHashMap.get(userName).getPassword().equals(password)){
            return userDatabaseHashMap.get(userName);
        }
        return null;
    }

    @Override
    public void createUser(UserInfoItem userInfoItem) {
        User user = new User(userInfoItem.getUserType(), userInfoItem.getPassword());
        userDatabaseHashMap.put(userInfoItem.getUserName(), user);
    }

    @Override
    public List<Course> getCourseList() {
        return courseList;
    }

    public static class User{
        private UserType userType;
        private String password;

        User(UserType userType, String password){
            this.userType = userType;
            this.password = password;
        }

        public UserType getUserType() {
            return userType;
        }

        String getPassword() {
            return password;
        }
    }
}

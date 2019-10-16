package shwetank.database;

import shwetank.course.Course;
import shwetank.enums.CourseLevelType;
import shwetank.enums.UserType;
import shwetank.person.UserInfoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManagerImpl implements DatabaseManager {

    private static DatabaseManager mDatabaseManager;
    Map<String, User> userMap = new HashMap<>();
    List<Course> courseList = new ArrayList<>();

    private DatabaseManagerImpl(){
        userMap.put("pepe", new User(UserType.STUDENT, "1111"));
        userMap.put("yaya", new User(UserType.STUDENT, "2222"));
        userMap.put("yape", new User(UserType.STUDENT, "3333"));
        userMap.put("Inst1", new User(UserType.TEACHER, "1111"));

        courseList.add(new Course("CSE890", CourseLevelType.HIGH));
        courseList.add(new Course("CSE870", CourseLevelType.HIGH));
        courseList.add(new Course("CSE880", CourseLevelType.LOW));
    }

    public static DatabaseManager getInstance(){
        if(mDatabaseManager == null){
            mDatabaseManager = new DatabaseManagerImpl();
        }
        return mDatabaseManager;
    }

    @Override
    public boolean verifyUser(String userName, String password) {
        return userMap.containsKey(userName) && userMap.get(userName).getPassword().equals(password);
    }

    @Override
    public void createUser(UserInfoItem userInfoItem) throws Exception {
        if(userMap.containsKey(userInfoItem.getUserName())){
            throw new Exception("User Already Exists");
        }else{
            User user = new User(userInfoItem.getUserType(), userInfoItem.getPassword());
            userMap.put(userInfoItem.getUserName(), user);
        }
    }

    @Override
    public List<Course> getCourseList() {
        return courseList;
    }

    static class User{
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

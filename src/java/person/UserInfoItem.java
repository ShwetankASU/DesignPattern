package java.person;

import java.enums.UserType;

public class UserInfoItem {
    private UserType userType;

    public UserInfoItem(UserType userType){
        this.userType = userType;
    }

    public UserType getUserType(){
        return userType;
    }
}

package shwetank.person;

import shwetank.enums.UserType;

public class UserInfoItem {
    private UserType mUserType;
    private String mUserName;
    private String mPassword;

    public UserInfoItem(UserType userType, String userName, String password){
        this.mUserType = userType;
        this.mUserName = userName;
        this.mPassword = password;
    }

    public UserType getUserType(){
        return mUserType;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getPassword() {
        return mPassword;
    }
}

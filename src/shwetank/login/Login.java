package shwetank.login;

import shwetank.database.DatabaseManager;

public class Login {

    private DatabaseManager databaseManager;

    public Login(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }
    public boolean verifyUser(String userName, String password) {
        return databaseManager.verifyUser(userName, password);
    }
}

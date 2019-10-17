package shwetank.login;

import shwetank.database.DatabaseManager;
import shwetank.database.DatabaseManagerImpl;

public class Login {

    private DatabaseManager databaseManager;

    public Login(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }
    public DatabaseManagerImpl.User verifyUser(String userName, String password) {
        return databaseManager.verifyUser(userName, password);
    }
}

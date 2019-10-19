package shwetank.login;

import shwetank.database.DatabaseManager;
import shwetank.database.DatabaseManagerImpl;

public class Login {
    private DatabaseManager mDatabaseManager;

    public Login(DatabaseManager databaseManager) {
        this.mDatabaseManager = databaseManager;
    }

    public DatabaseManagerImpl.User verifyCredentials(String userName, String password) {
        return mDatabaseManager.verifyCredentials(userName, password);
    }
}

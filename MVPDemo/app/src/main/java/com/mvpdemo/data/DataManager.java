package com.mvpdemo.data;

import com.mvpdemo.data.database.DatabaseManager;
import com.mvpdemo.datamodel.College;

import java.util.ArrayList;

public class DataManager implements IDataManager {

    private DatabaseManager databaseManager;
    private static DataManager instance;

    private DataManager() {
        databaseManager = DatabaseManager.getInstance();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null)
                    instance = new DataManager();
            }
        }
        return instance;
    }

    @Override
    public void addCollege(College college) {
        databaseManager.insert(college);
    }

    @Override
    public void updateCollege(College college) {
        databaseManager.update(college);
    }

    @Override
    public void deleteCollege(int collegeId) {
        databaseManager.del(collegeId);
    }

    @Override
    public ArrayList<College> retrieveCollege() {
        return databaseManager.retrieve();
    }

    @Override
    public College fetchParticularCollege(int collegeId) {
        return databaseManager.fetchSpecificCollege(collegeId);
    }
}

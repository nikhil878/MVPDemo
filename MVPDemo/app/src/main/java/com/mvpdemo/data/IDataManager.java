package com.mvpdemo.data;

import com.mvpdemo.datamodel.College;

import java.util.ArrayList;

public interface IDataManager {

    void addCollege(College college);
    void updateCollege(College college);
    void deleteCollege(int collegeId);
    ArrayList<College> retrieveCollege();
    College fetchParticularCollege(int collegeId);
}

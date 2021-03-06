package com.mvpdemo.addcollegesample;

import com.mvpdemo.base.BaseModel;
import com.mvpdemo.datamodel.College;

public class AddCollegeModel extends BaseModel<AddCollegeListener> {
    public AddCollegeModel(AddCollegeListener listener) {
        super(listener);
    }

    @Override
    public void init() {

    }

    public void addToDatabase(College college) {
        getDataManager().addCollege(college);
    }

    public void updateDatabase(College college)
    {
        getDataManager().updateCollege(college);
    }

    public void getCollegeData(int collegeId) {
        getListener().onCollegeFetched(getDataManager().fetchParticularCollege(collegeId));
    }
}

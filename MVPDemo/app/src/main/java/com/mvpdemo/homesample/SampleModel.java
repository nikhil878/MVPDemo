package com.mvpdemo.homesample;

import com.mvpdemo.base.BaseModel;
import com.mvpdemo.datamodel.College;

public class SampleModel extends BaseModel<SampleModelListener> {
    public SampleModel(SampleModelListener listener) {
        super(listener);
    }

    @Override
    public void init() {

    }

    public void getList() {
       getListener().onCollegeRetrieved(getDataManager().retrieveCollege());
    }

    public void deleteFromDatabase(int collegeId) {
        getDataManager().deleteCollege(collegeId);
    }
}

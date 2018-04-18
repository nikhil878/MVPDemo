package com.mvpdemo.homesample;

import com.mvpdemo.base.BasePresenter;
import com.mvpdemo.datamodel.College;

import java.util.ArrayList;

public class SamplePresenter extends BasePresenter<SampleView> implements SampleModelListener {

    private SampleModel model;

    public SamplePresenter(SampleView view) {
        super(view);
    }

    @Override
    protected void setModel() {
        model = new SampleModel(this);
    }

    @Override
    protected void destroy() {
        model.detachListener();
        model = null;
    }

    @Override
    protected void initView() {

    }

    public void onFabClicked() {
        getView().showNewCollegeScreen();
    }

    public void getCollegeList() {
        model.getList();
    }

    @Override
    public void onCollegeRetrieved(ArrayList<College> list) {
        if (list != null) {
            getView().showColleges(list);
        } else
            getView().noSuchCollege();
    }

    public void onRowClick(int collegeId) {
        getView().showDialogOption(collegeId);
    }

    public void onUpdateCollege(int collegeId) {
        getView().ShowUpdateCollegeScreen(collegeId);
    }

    public void onDeleteCollege(int collegeId) {
        model.deleteFromDatabase(collegeId);
    }
}

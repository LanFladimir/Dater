package com.dev_lan.dater.ui.main;

import com.dev_lan.dater.bean.Dater;

import org.litepal.LitePal;

import java.util.List;

public class MainPresenter implements IPresenter {
    IView mIView;
    public MainPresenter( IView view) {
        mIView = view;
    }

    @Override
    public void getDaterList() {
        mIView.loadData(LitePal.findAll(Dater.class));
    }
}

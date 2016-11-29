package com.redinfinity.template.temp;


import android.content.Context;

import com.redinfinity.template.app.BasePresenter;
import com.redinfinity.template.app.BaseView;

/**
 * Created by xiejian on 16/6/30.
 */
public interface TempContract {
    interface View extends BaseView<Presenter> {
        void initView();
        void setValues();
        void onListener();
        void showProgressDialog();
        void dismissProgressDialog();
        void dealErrorMessage(int errorCode, String errorMessage);
    }

    interface Presenter extends BasePresenter {

        void template(Context mContext, String params);
    }
}

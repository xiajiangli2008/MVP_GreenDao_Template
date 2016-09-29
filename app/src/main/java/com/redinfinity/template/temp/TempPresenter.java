package com.redinfinity.template.temp;

import android.content.Context;

import com.redinfinity.template.data.bean.BaseModle;
import com.redinfinity.template.data.source.NetWorkDataSource;
import com.redinfinity.template.data.source.NetWorkRepository;

/**
 * Created by xiejian on 16/6/30.
 */
public class TempPresenter implements TempContract.Presenter {
    private TempContract.View mView;

    public TempPresenter(TempContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

        mView.showProgressDialog();
    }

    @Override
    public void template(Context mContext, String params) {

        NetWorkRepository.getInstance().templateRequest(mContext, params, new NetWorkDataSource.LoadCallback() {
            @Override
            public void onSuccess(BaseModle response) {

            }

            @Override
            public void onAfter() {

                mView.dismissProgressDialog();
            }

            @Override
            public void onFailed() {

            }
        });
    }
}

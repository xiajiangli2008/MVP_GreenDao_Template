package com.redinfinity.template.temp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redinfinity.template.R;
import com.redinfinity.template.app.BaseActivity;
import com.redinfinity.template.data.source.NetWorkErrorCenter;

/**
 * Created by xiejian on 16/6/30.
 */
public class TempFragment extends Fragment implements TempContract.View {

    private BaseActivity mActivity;
    private View layout;
    private TempContract.Presenter mPresernter;

//    private ImageView iv_left;
//    private ImageView iv_right;
//    private TextView tv_title;

    public static TempFragment newInstance() {
        TempFragment fragment = new TempFragment();
        return fragment;
    }
    @Override
    public void setPresenter(TempContract.Presenter presenter) {
        mPresernter = presenter;
    }

    @Override
    public void dealErrorMessage(int errorCode, String errorMessage) {

        NetWorkErrorCenter.getInstance().dealErrorFromNet(mActivity,
                errorCode, errorMessage);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layout == null) {
            mActivity = (BaseActivity) this.getActivity();
            layout = mActivity.getLayoutInflater().inflate(R.layout.fragment_temp,
                    null);
            initView();
            setValues();
            onListener();

        } else {
            ViewGroup parent = (ViewGroup) layout.getParent();
            if (parent != null) {
                parent.removeView(layout);
            }
        }
        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresernter.start();
        mPresernter.template(mActivity, "");
    }

    @Override
    public void initView() {
//        iv_left = (ImageView) layout.findViewById(R.id.iv_left);
//        iv_right = (ImageView) layout.findViewById(R.id.iv_right);
//        tv_title = (TextView) layout.findViewById(R.id.tv_title);
    }

    @Override
    public void setValues() {
//        tv_title.setText("模板标题");
    }

    @Override
    public void onListener() {
//        iv_left.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mActivity.finish();
//            }
//        });
//
//        iv_right.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public void showProgressDialog() {
        mActivity.showWaitingMessage();
    }

    @Override
    public void dismissProgressDialog() {
        mActivity.dismissProgress();
    }
}

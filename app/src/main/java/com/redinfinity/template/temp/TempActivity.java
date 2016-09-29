package com.redinfinity.template.temp;

import android.os.Bundle;

import com.redinfinity.template.R;
import com.redinfinity.template.app.BaseActivity;
import com.redinfinity.template.utils.ActivityUtils;

/**
 * 项目名称：AndroidMVPTemplate
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/8/25 10:40
 * 修改人：Administrator
 * 修改时间：2016/8/25 10:40
 * 修改备注：
 */
public class TempActivity extends BaseActivity {

    private TempPresenter mPresenter;
    private TempFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mFragment =
                (TempFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mFragment == null) {
            // Create the fragment
            mFragment = TempFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), mFragment, R.id.contentFrame);
        }

        // Create the presenter
        mPresenter = new TempPresenter( mFragment);

    }
}

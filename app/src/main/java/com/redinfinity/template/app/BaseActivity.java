package com.redinfinity.template.app;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 项目名称：FlowPolicyDecision
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/8/4 16:11
 * 修改人：Administrator
 * 修改时间：2016/8/4 16:11
 * 修改备注：
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addActivity(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
                localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            }
        }
    }

    public ProgressDialog progress;

    public void showProgress(String title, String msg) {
        if (progress != null) {
            progress.dismiss();
        }
        progress = ProgressDialog.show(this, title, msg, true, false);
        progress.setCancelable(true);
        progress.setCanceledOnTouchOutside(false);
    }

    public void dismissProgress() {
        if (progress != null) {
            progress.dismiss();
        }
    }

    public void showWaitingMessage() {
        showProgress("", "加载中...");
    }

    public void toastMsg(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}

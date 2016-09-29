package com.redinfinity.template.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;


/**
 * 项目名称：
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/7/19 22:22
 * 修改人：Administrator
 * 修改时间：2016/7/19 22:22
 * 修改备注：
 */
public class MyApplication extends Application {
    private static Context mContext;
    public static MyApplication instance;
    //public static LoginModel loginModel;

    private List<Activity> activityList;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        instance = this;

        activityList = new LinkedList<Activity>();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    /**
     * 得到登录信息
     *
     * @return LoginModle实例
     */
//    public LoginModel getLoginModel() {
//        if (loginModel != null) {
//            return loginModel;
//        } else {
//            String str = (String) SPUtils.get(mContext, Constants.USER_INFO_KEY, "");
//            try {
//                loginModel = (LoginModel) SerializedObjectsUtil.deSerialization(str);
//                return loginModel;
//            } catch (ClassNotFoundException e) {
//                //TODO 处理异常
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

    /**
     * 清空登录信息
     */
//    public void cleanLoginModel() {
//        loginModel = null;
//    }

    /**
     * 保存登录信息
     */
//    public void saveLoginModel(LoginModel loginModel) {
//
//        String loginModelStr = null;
//        try {
//            loginModelStr = SerializedObjectsUtil.serialize(loginModel);
//            SPUtils.put(mContext, Constants.USER_INFO_KEY, loginModelStr);
//        } catch (IOException e) {
//            L.e("序列化失败");
//            e.printStackTrace();
//        }
//    }

    /**
     * 保存账户密码
     */
//    public void saveUsernameAndPassword(String username, String password) {
//        SPUtils.put(mContext, Constants.USER_NAME_KEY, username);
//        SPUtils.put(mContext, Constants.PASSWORD_KEY, password);
//    }

    /**
     * 获取用户名
     */
//    public String getUsername() {
//        return (String) SPUtils.get(mContext, Constants.USER_NAME_KEY, "");
//    }

    /**
     * 获取加密后密码
     */
//    public String getPassword() {
//        return (String) SPUtils.get(mContext, Constants.PASSWORD_KEY, "");
//    }

    /**
     * 获取token
     */
    public String getToken() {

        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InNhZGZzZGEiLCJ1c2VyX2lkIjoiMzgiLCJleHAiOjE0NzIyOTE2Njd9.ObRhDQ0zUubd42mK29LKGSanyr98dIhc9xWB2V4aJT0";
//        if(getLoginModel() != null) {
//
//            return getLoginModel().getToken();
//        } else {
//            return "";
//        }
    }

    /**
     * 是否登录
     */
//    public boolean isLogin() {
//        return (boolean) SPUtils.get(mContext, Constants.IS_LOGIN, false);
//    }

    /**
     * 设置登录状态
     */
//    public void setLoginStatus(boolean isLogin) {
//        SPUtils.put(mContext, Constants.IS_LOGIN, isLogin);
//    }

    /**
     * 设置是否为第一次登录
     */
//    public void setIsFristLogin(boolean isFristLogin) {
//        SPUtils.put(mContext, Constants.IS_FRIST_LOGIN, isFristLogin);
//    }

//    public boolean isFristLogin() {
//        return (boolean) SPUtils.get(mContext, Constants.IS_FRIST_LOGIN, true);
//    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void removeActivity(int n) {
        int num;
        for (int i = 0; i < n; i++) {
            num = activityList.size();
            activityList.get(num - 1).finish();
            activityList.remove(num-1);
        }
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    /**
     * 获取设备id
     * @return
     */
    public String getDeviceId() {
        return ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();//设备唯一标识 idfa
    }
}

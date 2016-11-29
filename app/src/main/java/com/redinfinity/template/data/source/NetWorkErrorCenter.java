package com.redinfinity.template.data.source;

import android.content.Context;

import com.redinfinity.template.utils.T;

/**
 * Created by xiejian on 2016/11/29.
 */

public class NetWorkErrorCenter {

    private static class NetWorkErrorCenterHolder{

        private static final NetWorkErrorCenter INSTANCE = new NetWorkErrorCenter();
    }

    public static final NetWorkErrorCenter getInstance(){
        return NetWorkErrorCenterHolder.INSTANCE;
    }

    public void dealErrorFromNet(Context mContext, int errorCode, String errorMessage){

        switch (errorCode){
            case 400:

                tokenExpired(mContext);
                break;
            case 401:

                break;
            case 402:

                break;
            default:
                T.showShort(mContext, errorMessage);
                break;
        }
    }

    private void tokenExpired(Context mContext){

        //token后台重新登录
    }
}

package com.redinfinity.template.data.source;

import android.content.Context;

import com.redinfinity.template.data.bean.BaseModle;

/**
 * 项目名称：AndroidMVPTemplate
 * 类描述：
 * 创建人：xiejian
 * 创建时间：16/9/27 下午3:18
 * 修改人：xiejian
 * 修改时间：16/9/27 下午3:18
 * 修改备注：
 */
public interface NetWorkDataSource<T> {

    interface LoadCallback<T>{

        void onSuccess(BaseModle<T> response);
        void onAfter();
        void onError(int errorCode, String errorMessage);
    }

    //网络请求数据函数接口
    void templateRequest(Context mContext, String params, LoadCallback<T> callback);
}

package com.redinfinity.template.data.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by weihuajian on 16/6/22.
 */
public abstract class RetrofitCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call call, Response response) {

        int code = response.raw().code();
        if (code == 200) {
            /**
             * 这里我只实现了成功和失败的回调，还可以根据接口返回的状态信息实现相应的回调
             * */
            T t = (T) response.body();
            onSuccess(t);

        } else if (code == 204) {
            onNoData(ERR_MSG.NO_DATA);
        } else if (code == 400) {
            onFail(ERR_MSG.ERR0E_400);
        } else if (code == 500) {
            onFail(ERR_MSG.ERROR_500);
        } else if (code == 501) {
            onFail(ERR_MSG.ERROR_501);
        } else if (code == 503) {
            onFail(ERR_MSG.ERROR_503);
        } else if (code == 504) {
            onFail(ERR_MSG.ERROR_504);
        } else {
            onFail(ERR_MSG.ERROR_NO_RESULT);
        }

        onAfter();
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        onFail(t.getMessage());
        onAfter();
    }

    /**
     * 请求成功的回调
     */
    protected abstract void onSuccess(T response);

    /**
     * 请求完的回调，可以在里面停止刷新控件，可以不实现
     */
    protected void onAfter() {
    }

    /**
     * 没有数据的回调，可以不实现
     */
    protected void onNoData(String msg) {

    }

    /**
     * 请求失败的回调
     */
    protected abstract void onFail(String msg);


    /**
     * 自定义的错误信息
     */
    class ERR_MSG {
        private static final String NO_DATA = "暂无数据";
        private static final String ERR0E_400 = "请求失败";
        private static final String ERROR_500 = "服务器操作失败";
        private static final String ERROR_501 = "非法请求";
        private static final String ERROR_503 = "TOKEN无效";
        private static final String ERROR_504 = "请求参数错误";
        private static final String ERROR_NO_RESULT = "未知错误";
    }

}

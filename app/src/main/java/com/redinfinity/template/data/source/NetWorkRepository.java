package com.redinfinity.template.data.source;

import android.content.Context;
import android.widget.TextView;

import com.redinfinity.template.data.ApiService;
import com.redinfinity.template.data.Retrofit.RetrofitCallback;
import com.redinfinity.template.data.Retrofit.RetrofitUtils;
import com.redinfinity.template.data.bean.BaseModle;
import com.redinfinity.template.data.bean.LoginModel;
import com.redinfinity.template.utils.L;
import com.redinfinity.template.utils.MD5Util;
import com.redinfinity.template.utils.T;

import retrofit2.Retrofit;

/**
 * 项目名称：AndroidMVPTemplate
 * 类描述：
 * 创建人：xiejian
 * 创建时间：16/9/27 下午3:23
 * 修改人：xiejian
 * 修改时间：16/9/27 下午3:23
 * 修改备注：
 */
public class NetWorkRepository implements NetWorkDataSource {

    private static class NetWorkRepositoryHolder{

        private static final NetWorkRepository INSTANCE = new NetWorkRepository();
    }

    public static final NetWorkRepository getInstance(){

        return NetWorkRepositoryHolder.INSTANCE;
    }

    @Override
    public void templateRequest(final Context mContext, String params, final LoadCallback callback) {

        RetrofitUtils.getInstance(mContext, false)
                .create(ApiService.class)
                .login("18507085956", MD5Util.getMD5String("123456"))
                .enqueue(new RetrofitCallback<BaseModle<LoginModel>>() {
                    @Override
                    protected void onSuccess(BaseModle<LoginModel> response) {

                        if (response.isStatus()){

                            callback.onSuccess(response);
                        }else{

                            callback.onError(response.getErrcode(), response.getMessage());
                        }
                    }

                    @Override
                    protected void onAfter() {
                        super.onAfter();
                        callback.onAfter();
                    }

                    @Override
                    protected void onFail(String msg) {

                        L.d("templateRequest---------onFailure---------------------->", msg);
                        T.showShort(mContext,msg);
                    }
                });
    }
}

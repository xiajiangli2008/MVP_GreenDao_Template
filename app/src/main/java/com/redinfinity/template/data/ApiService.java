package com.redinfinity.template.data;

import com.redinfinity.template.data.bean.BaseModle;
import com.redinfinity.template.data.bean.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 项目名称：AndroidMVPTemplate
 * 类描述：
 * 创建人：xiejian
 * 创建时间：16/9/27 下午3:29
 * 修改人：xiejian
 * 修改时间：16/9/27 下午3:29
 * 修改备注：
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("index.php/Api/auth/auth")
    Call<BaseModle<LoginModel>> login(@Field("username") String userName, @Field("password") String passWord);
}

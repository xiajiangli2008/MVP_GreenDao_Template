package com.redinfinity.template.data.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 项目名称：AndroidMVPTemplate
 * 类描述：
 * 创建人：xiejian
 * 创建时间：16/9/27 下午4:03
 * 修改人：xiejian
 * 修改时间：16/9/27 下午4:03
 * 修改备注：
 */
public class LoginModel implements Serializable {

    @SerializedName("token")
    protected String Token;
    @SerializedName("username")
    protected String UserName;
    @SerializedName("point_value")
    protected  String PointValue;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPointValue() {
        return PointValue;
    }

    public void setPointValue(String pointValue) {
        PointValue = pointValue;
    }
}

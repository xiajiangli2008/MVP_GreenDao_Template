package com.redinfinity.template.app;

/**
 * 公共常量
 * Created by yybo on 16/7/1.
 */
public class Constants {

    /** 服务器地址 */
    //public static final String URL_PATH = "http://192.168.12.4:8001/";
    public static final String URL_PATH = "http://120.76.176.155:8080/";

    /** 测试服务器地址 **/
    public static final String TEST_URL_PATH = "http://172.16.0.37/";

    /** 用户数据保存本地的key值*/
    public static final String USER_INFO_KEY = "userInfo";
    /** 用户名保存本地的key值*/
    public static final String USER_NAME_KEY = "username";
    /** 密码保存本地的key值*/
    public static final String PASSWORD_KEY = "password";
    /** 登录状态值保存本地的key值*/
    public static final String IS_LOGIN = "isLogin";
    /** 是否第一次登录*/
    public static final String IS_FRIST_LOGIN = "isFristLogin";

    /**
     * 定位结果状态
     */
    public static final int location_fail = 1;
    public static final int location_success = 2;

    /**
     * 购买定位结果详情状态
     */
    public static final int location_non_buy = 0;
    public static final int location_ok_buy = 1;

    /**
     * listView操作方式
     */
    public static final int refreshWay = 1;
    public static final int onloadMoreWay = 2;

    /**
     * 支付方式
     */
    public static final int ALI_PAYMENT = 1;
    public static final int WEIXIN_PAYMENT = 2;

    /**
     * 微信
     */
    public static final String WXAppId = "wx72b896cfc133ba6d";
    public static final String WXAppSecret = "9b26fe2900a8e745c6dd663332730a0e";
    public static final String KEY_CODE = "";

    /**
     * QQ、QQZone
     */
    public static final String QQAppId = "";
    public static final String QQAppKey = "";
    public static final String QQGroupKey = "HJl3rYHjYbW3mSSHTVbYVwf4LwU1zg2D";

    /**
     * Sina
     */
    public static final String SinaAppId = "";
    public static final String SinaAppKey = "";

    /**
     * 短信分享和其他分享方式
     */
    public static final int OtherShare = 1;
    public static final int SMSShare = 2;
}

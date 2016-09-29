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


    public static final String USER_ACCESS_PROTOCOL = "本《协议》是用户与南昌恒韬软件技术有限公司（下称“恒韬软件”）之间的法律协议。\n" +
            "一、服务内容\n" +
            "\t《智能云定位》是一款安装在手机上的应用，帮助您找到家人和朋友的地理位置。\n" +
            "\t软件会生成一个自定义的链接内容并带有获取位置功能的链接。\n" +
            "\t家人和朋友打开连接、并允许位置，您才能获取到位置信息。\n" +
            "\t应用场景如：家人被骗去传销，限制人身自由。可以使用《智能云定位》快捷找到您的家人的地理位置。将此地址提供给警方，一举捣毁传销窝点，救出家人。\n" +
            "二、用户使用须知\n" +
            "\t用户在使用恒韬软件服务过程中，必须遵循以下原则：\n" +
            "\t1、遵循中国有关的法律和法规；\n" +
            "\t2、软件将收集手机唯一标识号来区别用户，我们并不知道您是谁，用户分享的位置信息数据我们会存储在服务器上，用户在删除链接时，位置信息会一起删除，保护用户隐私\n" +
            "\t3、发起分享位置连接时，请告诉对方此条链接将获取对方的位置，以免侵犯他人隐私权利。对违法忠告的违法行为，用户需自行承担相关法律责任，本公司已经尽了告知业务，侵犯他人隐私权利的行为和本公司无关。\n" +
            "三、免责声明\n" +
            "\t1、恒韬软件不担保网络服务一定能满足用户的要求，也不担保网络服务不会中断，对网络服务的及时性、安全性、准确性也都不作担保。\n" +
            "\t2、对于因电信系统或互联网网络故障、计算机故障或病毒、信息损坏或丢失、计算机系统问题或其他任何不可抗力原因而产生损失，恒韬软件不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。\n" +
            "四、法律及争议解决\n" +
            "\t1、本协议适用中华人民共和国法律。\n" +
            "\t2、因本协议引起的或与本协议有关的任何争议，各方应友好协商解决；协商不成的，任何一方均可将有关争议提交至南昌仲裁委员会并按照其届时有效的仲裁规则仲裁；仲裁裁决是终局的，对各方均有约束力。\n" +
            "\t3、恒韬软件在法律允许最大范围对本协议拥有解释权和修改权。";

}

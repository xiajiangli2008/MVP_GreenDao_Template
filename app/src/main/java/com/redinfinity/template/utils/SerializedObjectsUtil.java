package com.redinfinity.template.utils;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 项目名称：FunSchool
 * 类描述：序列化、反序列化
 * 创建人：Administrator
 * 创建时间：2016/7/26 23:08
 * 修改人：Administrator
 * 修改时间：2016/7/26 23:08
 * 修改备注：
 */
public class SerializedObjectsUtil {
    public static String serialize(Object object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //然后将得到的字符数据装载到ObjectOutputStream。

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        //writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它。
        objectOutputStream.writeObject(object);
        //最后，用Base64.encode将字节文件转换成Base64编码保存在String中
        String objectString = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        //关闭objectOutputStream
        objectOutputStream.close();
        return objectString;
    }

    public static Object deSerialization(String str) throws IOException,
            ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(str.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object = (Object) objectInputStream.readObject();
        objectInputStream.close();

        return object;
    }
}

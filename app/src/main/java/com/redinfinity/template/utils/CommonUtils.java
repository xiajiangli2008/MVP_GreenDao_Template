package com.redinfinity.template.utils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiejian on 2016/7/20.
 */
public class CommonUtils {

    /**
     * 重新设置ListView的高度
     *
     * @param listView
     * @return
     */
    public static int setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return 0;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem != null) {
                listItem.measure(0, 0);
//                CommonUtils.LOGV("samton", "listItem Height === " + listItem.getMeasuredHeight());
                totalHeight += listItem.getMeasuredHeight();
            }
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // ((MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
//        CommonUtils.LOGV("samton", "totalHeight Height === " +totalHeight
//        );
        return totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
    }

    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean notEmpty(List list) {
        return !isEmpty(list);
    }

    //全部为空
    public static boolean isAllEmpty(List... lists) {
        List<Boolean> booleans = new ArrayList<>();

        for (List list : lists) {
            if (isEmpty(list)) {
                booleans.add(Boolean.TRUE);
            }
        }

        return notEmpty(booleans) && booleans.contains(Boolean.FALSE);
    }

    //只有一个为空
    public static boolean isOneEmpty(List... lists) {
        for (List list : lists) {
            if (isEmpty(list)) {
                return true;
            }
        }

        return false;
    }


    //====================================================================
    //====================================================================

    public static boolean isEmpty(String s) {
        return s == null || TextUtils.isEmpty(s);
    }

    public static boolean notEmpty(String s) {
        return s != null && !TextUtils.isEmpty(s.trim());
    }

    public static boolean isAllEmpty(String... strings) {
        List<Boolean> booleans = new ArrayList<>();

        for (String s : strings) {
            booleans.add(CommonUtils.isEmpty(s));
        }

        return notEmpty(booleans) && booleans.contains(Boolean.FALSE);
    }

    //只有一个为空
    public static boolean isOneEmpty(String... strings) {
        for (String s : strings) {
            if (isEmpty(s)) {
                return true;
            }
        }

        return false;
    }

    public static long mLastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }

    public static View infalte(Context context, @LayoutRes int layoutId, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(layoutId, parent, false);

    }

    /**
     * 请求接口签名方法
     *
     * @param params
     * @return
     */
//    public static String calcuatePaySign(List<ParamsBean> params){
//
//        StringBuilder paramsBuilder = new StringBuilder();
//        for (ParamsBean paramsBean : params) {
//            paramsBuilder.append(paramsBean.getParamsKey()).append("&").append(paramsBean.getParamsValue()).append("&");
//        }
//        paramsBuilder.append("key_code").append("&").append(Constants.KEY_CODE);
//
////        L.v("samton", "app before = " + paramsBuilder.toString());
//
//        String result = MD5Util.getMD5String(MD5Util.getMD5String(paramsBuilder.toString()));
////        L.v("samton", "app result === " + result);
//        return result.toString();
//    }

//    public static List<ParamsBean> getSoreParam(List<ParamsBean> paramsList){
//        Map<String,ParamsBean> paramsMap = new HashMap<String,ParamsBean>();
//        List<ParamsBean> paramsSoreList = new ArrayList<ParamsBean>();
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < paramsList.size(); i++) {
//            list.add(paramsList.get(i).getParamsKey());
//            paramsMap.put(paramsList.get(i).getParamsKey(), paramsList.get(i));
//        }
//        Collections.sort(list, new Comparator() {
//            public int compare(Object o1, Object o2) {
//                int result = 0;
//                String s1 = o1.toString().toLowerCase();
//                String s2 = o2.toString().toLowerCase();
//                if (s1.equals(s2)) {
//                    result = o1.toString().compareTo(o2.toString());
//                } else {
//                    result = s1.compareTo(s2);
//                }
//                return result;
//            }
//        });
//        for (int i = 0; i < list.size(); i++) {
////    		System.out.print("******************"+list.get(i));
//            if(list.get(i)!=null && paramsMap.get(list.get(i))!=null){
//                paramsSoreList.add(paramsMap.get(list.get(i)));
//            }
//        }
//        return paramsSoreList;
//    }
}

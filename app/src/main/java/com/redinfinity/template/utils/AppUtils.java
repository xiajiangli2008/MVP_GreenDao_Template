package com.redinfinity.template.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;

/**
 * 跟App相关的辅助类
 * 
 * @author yybo
 * 
 */
public class AppUtils {

	private AppUtils()
	{
        /* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}
	/**
	 * 获取应用程序名称
	 */
	public static String getAppName(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			int labelRes = packageInfo.applicationInfo.labelRes;
			return context.getResources().getString(labelRes);
		} catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * [获取应用程序版本名称信息]
	 *
	 * @param context
	 * @return 当前应用的版本名称
	 */
	public static String getVersionName(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			return packageInfo.versionName;

		} catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * [获取应用程序版本号]
	 *
	 * @param context
	 * @return 当前应用的版本号
	 */
	public static int getVersionCode(Context context)
	{
		try
		{
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			return packageInfo.versionCode;

		} catch (NameNotFoundException e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 判断包名是否存在
	 *
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean checkApkExist(Context context, String packageName) {
		if (packageName == null || "".equals(packageName))
			return false;
		try {
			ApplicationInfo info = context.getPackageManager()
					.getApplicationInfo(packageName,
							PackageManager.GET_UNINSTALLED_PACKAGES);
			return true;
		} catch (NameNotFoundException e) {
			return false;
		}
	}

	// 获取控件的高
	public static int getH(View v)
	{
		int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		v.measure(w, h);
		int height =v.getMeasuredHeight();
		return height;
	}

	// 获取控件的高
	public static int getW(View v)
	{
		int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		v.measure(w, h);
		int width =v.getMeasuredWidth();
		return width;
	}

}

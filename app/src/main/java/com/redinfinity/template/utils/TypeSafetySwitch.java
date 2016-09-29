package com.redinfinity.template.utils;

/**
 * 类型安全转换
 * @author yybo
 *
 */
public class TypeSafetySwitch {
	
	private TypeSafetySwitch()  
    {  
        /* cannot be instantiated */  
        throw new UnsupportedOperationException("cannot be instantiated");  
	}
	
	/**
	 * int类型安全转换
	 * @param value	待转换的数据
	 * @param defaultValue	默认返回值
	 * @return
	 */
	public final static int convertToInt(Object value, int defaultValue) {
		  if (value == null || "".equals(value.toString().trim())) {
		    return defaultValue;
		  }
		  try {
		    return Integer.valueOf(value.toString());
		  } catch (Exception e) {
		    try {
		      return Double.valueOf(value.toString()).intValue();
		    } catch (Exception e1) {
		      return defaultValue;
		    }
		  }
		} 
	
	/**
	 * long类型安全转换
	 * 
	 * @param value
	 *            待转换的数据
	 * @param defaultValue
	 *            默认返回值
	 * @return
	 */
	public final static long convertToLong(Object value, Long defaultValue) {
		if (value == null || "".equals(value.toString().trim())) {
			return defaultValue;
		}
		try {
			return Long.valueOf(value.toString());
		} catch (Exception e) {
			try {
				return Double.valueOf(value.toString()).longValue();
			} catch (Exception e1) {
				return defaultValue;
			}
		}
	}
	
	/**
	 * double类型安全转换
	 * 
	 * @param value
	 *            待转换的数据
	 * @param defaultValue
	 *            默认返回值
	 * @return
	 */
	public final static double convertToDouble(Object value, double defaultValue) {
		if (value == null || "".equals(value.toString().trim())) {
			return defaultValue;
		}
		try {
			return Double.valueOf(value.toString());
		} catch (Exception e) {
			try {
				return Double.valueOf(value.toString()).doubleValue();
			} catch (Exception e1) {
				return defaultValue;
			}
		}
	}
}

package com.springmvc_mybatis.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 	Conveter<S,T>	S：前端视图页面传入类型		T：将要转成类型
 * @author 33452
 *
 */
public class DateConverters implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if (source != null) {
				// 把字符串转换为日期类型
				DateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				return df.parse(source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//转换异常返回null
		return null;
	}

}

package com.springmvc_mybatis.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 	Conveter<S,T>	S��ǰ����ͼҳ�洫������		T����Ҫת������
 * @author 33452
 *
 */
public class DateConverters implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			if (source != null) {
				// ���ַ���ת��Ϊ��������
				DateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				return df.parse(source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ת���쳣����null
		return null;
	}

}

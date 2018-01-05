package org.test.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.test.pojo.Person;

/**
 * @author Administrator String2PersonConverter.1创建自定义转换器
 */
public class String2PersonConverter implements Converter<String, Person> {

	@Override
	public Person convert(String text) {
		Person person = new Person();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (text != null) {
			String[] t = text.split("/");
			person.setPname(t[0]);
			person.setPsex(t[1]);
			try {
				person.setpDate(sdf.parse(t[2]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return person;
	}

}

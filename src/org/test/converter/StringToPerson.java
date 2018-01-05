package org.test.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.test.pojo.Person;

/**
 * @author Administrator java���õ�����ת���༭�� StringToPerson.2 ��������װ����
 */
public class StringToPerson extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		return getValue().toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Person person = new Person();
		if (text != null && text.lastIndexOf(":") > 3) {
			String[] t = text.split(":");
			person.setPname(t[0]);
			person.setPsex(t[1]);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			try {
				person.setpDate(sdf.parse(t[2]));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		setValue(person);
	}

}

package com.example.mvc.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class JulianDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String strDate) {
		Date tempDate = null;
		try {
			System.out.println("CONVERTING");
			tempDate = new SimpleDateFormat("yyyyDDD").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}

	
}

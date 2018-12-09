package com.ecb.xmlutility.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtility {
	private static final Logger log = LoggerFactory.getLogger(DateUtility.class);
	
	public static Date setPreviousDate(int num) {
		Date currentDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_YEAR, - num);

		Date previousDate = calendar.getTime();
		return previousDate;
	}
	
	public static Date setCurrentDateByOne(int num) {
		Date currentDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_YEAR,+ num);
		

		Date previousDate = calendar.getTime();
		return previousDate;
	}

	public static XMLGregorianCalendar getXMLGegorianDate(Date date) throws DatatypeConfigurationException {
		String FORMATER = "yyyy-MM-dd";

		DateFormat format = new SimpleDateFormat(FORMATER);

		// Date date = new Date();
		XMLGregorianCalendar gDateFormatted1 = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(format.format(date));

		return gDateFormatted1;
	}

	public static XMLGregorianCalendar dateTimeToXMLGregorianCalendar(Date dateTime) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {

			gregorianCalendar.setTime(new Date(System.currentTimeMillis()));
			DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
			xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			log.error("Exception in conversion of DateTime to XMLGregorianCalendar" + e);
		}
		return xmlGregorianCalendar;
	}

	public static XMLGregorianCalendar normalizeDateTimeToXMLGregorianCalendar(Date date) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			/*
			 * DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
			 * xmlGregorianCalendar =
			 * dataTypeFactory.newXMLGregorianCalendar(date.to)).normalize();
			 */
			// GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar).normalize();
		} catch (DatatypeConfigurationException e) {
			System.out.println("Exception in conversion of DateTime to XMLGregorianCalendar" + e);
		}
		return xmlGregorianCalendar;
	}
	
	public static int getRandomNumber() {
		int max = 100;
		int min = 1;
		// create instance of Random class
		Random randomNum = new Random();
		log.info(" ::::: inside random number :::::: " + (min + randomNum.nextInt(max)));
		return (min + randomNum.nextInt(max));
	}
}

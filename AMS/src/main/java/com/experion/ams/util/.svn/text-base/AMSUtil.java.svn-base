/**
 * 
 */
package com.experion.ams.util;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.service.DashboardService;

/**
 * @author tt
 *
 */
public class AMSUtil {

	/**
	 * 
	 * @param messageSource
	 *            MessageSource budle object from the calling class.
	 * @param toAddress
	 *            toAddress to which the email has to be dispatched.
	 * @param password
	 *            password to be sent to the user.
	 * @return true/false determines whether the email delivery is success or
	 *         not.
	 * 
	 *         Method to dispatch email which contains password to the user. The
	 *         email credentials are read from the Messages.properties file.
	 */

	private static final Log log = LogFactory.getLog(AMSUtil.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	/**
	 * 
	 * @param map
	 * @param templateFile
	 * @return
	 * @throws Exception
	 * 
	 *             This method reads the .vm file located in the system path.
	 *             This template will be used as the email template.
	 */

	public static int getDaysBetweenDates(Date fromDate, Date toDate) {
		DateTime jodaDate1 = new DateTime(fromDate);
		DateTime jodaDate2 = new DateTime(toDate);
		return Days.daysBetween(jodaDate1, jodaDate2).getDays();
		// return ((int)((toDate.getTime()-fromDate.getTime())/ (1000 * 60 * 60
		// * 24)));

	}

	public static int getYearDifference(Date fromDate, Date toDate) {
		DateTime jodaDate1 = new DateTime(fromDate);
		DateTime jodaDate2 = new DateTime(toDate);
		int years = Years.yearsBetween(jodaDate1, jodaDate2).getYears();
		return years;
	}

	public static final int getMonthsDifference(Date date1, Date date2) {
		DateTime jodaDate1 = new DateTime(date1);
		DateTime jodaDate2 = new DateTime(date2);
		Months months = Months.monthsBetween(jodaDate1, jodaDate2);
		return months.getMonths();
	}

	public static int getWorkingDaysBetweenDates(Date fromDate, Date toDate) {
		Calendar startCal;
		Calendar endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(fromDate);
		endCal = Calendar.getInstance();
		endCal.setTime(toDate);
		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}
		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			return -1;
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

		return workDays;

	}


	public static String getSimpleDateFormat(Date dbdate) throws ParseException
	{
		
		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = targetFormat.format(dbdate);
         return formattedDate;

	}

	public static Date getSimpleDate(String dbdate) {
		Date date = null;

	try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		date = formatter.parse(dbdate);
			date = formatter.parse(dbdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	public static Double getDeprAmount(double curbookvalue, double value,
			int days) {
		double DeprAmount = curbookvalue * (value / 100);
		DeprAmount = (DeprAmount / 365) * days;
		double finalDeprAmount = Math.round(DeprAmount * 100.0) / 100.0;

		return finalDeprAmount;

	}

	public long getEmployeeCode(HttpSession session) {
		long employeeCode = 0;
		try {
			long employeeCodeValue = Long.parseLong(session.getAttribute(
					"empCode").toString());
			employeeCode = employeeCodeValue;
		} catch (Exception e) {
			return employeeCode;
		}
		return employeeCode;
	}
	
	
	public static java.util.Date dateFormatter(String strdate) {
		{
			// (1) create a SimpleDateFormat object with the desired format.
			// this is the format/pattern we're expecting to receive.
			String expectedPattern = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
			try {
				// (2) give the formatter a String that matches the
				// SimpleDateFormat pattern
				String userInput = strdate;
				java.util.Date date = formatter.parse(userInput);


				// (3) prints out "Tue Sep 22 00:00:00 EDT 2009"
				// System.out.println(date);

				return date;
			} catch (ParseException e) {
				log.error("error in parsing", e);
				// execution will come here if the String that is given
				// does not match the expected format.
				// e.printStackTrace();
				return null;
			}
		
		}}
	
	public static Date formatStringToDate(String date, String initDateFormat,
			String endDateFormat) throws ParseException {

		Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
//		System.err.println("initDate is "+initDate);
//		SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
////		String parsedDate = formatter.format(initDate);
//		initDate=formatter.parse(formatter.format(initDate));
		return initDate;
	}
	
	public static String formatDateToString(Date date, String initDateFormat,
			String endDateFormat) throws ParseException {

//		Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
//		SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
//		String parsedDate = formatter.format(initDate);

//		return parsedDate;
		return null;
	}


}

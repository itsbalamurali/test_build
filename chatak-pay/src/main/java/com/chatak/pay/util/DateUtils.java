package com.chatak.pay.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.security.core.session.SessionInformation;

import com.chatak.pg.util.Constants;
import com.chatak.pg.util.Properties;
import com.chatak.pg.util.StringUtils;

public class DateUtils {

  private DateUtils() {
    super();
  }

  private static Logger logger = Logger.getLogger(DateUtils.class);

  private static final int TWO_DIGITS = Constants.TWO;
  
  private static final int DECEMBER = Constants.TWELVE;

  /**
   * This method used for getting the start date time per today.
   * 
   * @return Timestamp
   */
  public static Timestamp getDailyFrequency(Date today) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp dateWithTime = new Timestamp(today.getTime());
    String strTodays = String.valueOf(dateWithTime);
    String year = strTodays.substring(0, Constants.FOUR);
    String month = strTodays.substring(Constants.FIVE, Constants.SEVEN);
    String date = strTodays.substring(Constants.EIGHT, Constants.TEN);
    Date convertedDateFormat = null;
    try {
      convertedDateFormat = formatter.parse(year + "-" + month + "-" + date + " " + "00:00:00");
    } catch (ParseException e) {
      logger.error("Error :: DateUtils :: getDailyFrequency", e);
    }
    long dateLong = 0L;
    if (convertedDateFormat != null) {
      dateLong = convertedDateFormat.getTime();
    }
    return new Timestamp(dateLong);
  }

  /**
   * This method used for getting the start date time of this week based on
   * today.
   * 
   * @return Timestamp
   */
  public static Timestamp getWeeklyFrequency() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DAY_OF_WEEK, 1);
    return getDailyFrequency(cal.getTime());
  }

  /**
   * This method used for check the eligibility of order request date and time
   * 
   * @param orderReqDateTime
   * @return boolean
   * @throws ParseException
   */
  public static boolean isEligOrderPrinting(String orderReqDateTime) {
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEE MMM dd yyyy hh:mma");
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mma");
    Timestamp reqDateTime = null;
    boolean isOrderPrinting = true;
    long ONE_DAY = Constants.DAY_TO_MILLISECONDS;
    Timestamp hisDate =
        new Timestamp(new Timestamp(System.currentTimeMillis()).getTime() - ONE_DAY);
    try {
      reqDateTime = new Timestamp(dateFormat1.parse(orderReqDateTime).getTime());
      if (reqDateTime.before(hisDate)) {
        isOrderPrinting = false;
      }
    } catch (Exception e) {
      logger.error("Error :: DateUtils :: ", e);
      try {
        reqDateTime = new Timestamp(dateFormat2.parse(orderReqDateTime).getTime());
        if (reqDateTime.before(hisDate)) {
          isOrderPrinting = false;
        }
      } catch (ParseException e1) {
        isOrderPrinting = false;
        logger.error("Error :: DateUtils :: isEligOrderPrinting", e1);
      }
    }
    return isOrderPrinting;
  }
  
  /**
   * This method used for getting the start date time of this month based on
   * today.
   * 
   * @return Timestamp
   */
  public static Timestamp getMonthlyFrequency() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.DATE, 1);
    return getDailyFrequency(cal.getTime());
  }

  /**
   * This method used for get CurrentDate In String
   * 
   * @param cal
   * @param formatter
   * @return String
   */
  public static String getCurrentDateInString(Calendar cal, SimpleDateFormat formatter) {
    String currentDate = "";
    Date date = new Date();
    cal.setTime(date);
    cal.set(Calendar.MILLISECOND, 0);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    date = cal.getTime();
    currentDate = formatter.format(date);
    return currentDate;
  }

  /**
   * This method used for get CurrentDate In MM/dd/yyyy format
   * 
   * @return String - String
   */
  public static String getCurrentDateInMMddyyyy() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat mmddyyyyformatter = new SimpleDateFormat("MM/dd/yyyy");
    String currentDate = mmddyyyyformatter.format(cal.getTime());
    return currentDate;
  }
  
  /**
   * This method used for get Date of Days Before Current Days In MM/dd/yyyy
   * format
   * 
   * @param days
   * @return String - String
   */
  public static String getDateOfDaysBeforeCurrentDateInMMddyyyy(int days) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat mmddyyyyformatter = new SimpleDateFormat("MM/dd/yyyy");
    String currentDate = "";
    if (days > 0) {
      cal.add(Calendar.DATE, days * -1);
      currentDate = mmddyyyyformatter.format(cal.getTime());
    } else {
      currentDate = mmddyyyyformatter.format(cal.getTime());
    }
    return currentDate;
  }

  /**
   * This method used for get Date of Days Before Current Days In MM/dd/yyyy
   * format
   * 
   * @param days
   * @return String - String
   */
  public static Timestamp getDateOfDaysBeforeCurrentDateAndTime(int days) {
    Calendar cal = Calendar.getInstance();
    if (0 < days) {
      cal.add(Calendar.DATE, days * -1);
    }
    return (new Timestamp(cal.getTimeInMillis()));
  }

  /**
   * ConvertTo8583FormattedAmount : This method converts a float to ISO 8583
   * format which is : 234.Constants.FIVE ==> 000000023450
   * 
   * @param amt
   * @return String
   */
  public static String convertTo8583FormattedAmount(Double amt, int length) {
    String bal = String.valueOf(amt) + "00";
    int idxOfDecimal = bal.indexOf('.');
    if (idxOfDecimal < 0) {
      idxOfDecimal = String.valueOf(amt).length();
    }
    String tmpBal = bal.substring(0, idxOfDecimal)
        + bal.substring((++idxOfDecimal), (idxOfDecimal + Constants.TWO));
    return StringUtils.getFixedLengthZEROLeftPad(tmpBal, length);
  }
  
  /**
   * method to get java.sql.Timestamp to given date string and format of date
   * 
   * @param date
   * @return Timestamp
   */
  public static Timestamp getTimestamp(String date) {
    try {
    	SimpleDateFormat mmddyyyyformatter = new SimpleDateFormat("MM/dd/yyyy");
    	return (new Timestamp(mmddyyyyformatter.parse(date).getTime()));
    } catch (ParseException e) {
      logger.error("Error :: DateUtils :: getTimestamp", e);
    }
    return null;
  }

  /**
   * This method to get Current Day
   * 
   * @return int
   */
  public static int getCurrentDayOfWeek() {
    Calendar cal = Calendar.getInstance();
    return (cal.get(Calendar.DAY_OF_WEEK));
  }

  /**
   * This method will validate the start Date (YYYYMMDD) and end Date
   * (YYYYMMDD), if present
   * 
   * @param startDate
   * @param endDate
   * @return boolean
   */
  public static boolean validateStEndDate(String startDate, String endDate) {
    boolean validFlag = true;
    if (startDate.length() != Constants.EIGHT) {
      validFlag = false;
    }
    try {
      if (validFlag) {
        // If the date is today also then allow
        Timestamp currentDateTime = new Timestamp(System.currentTimeMillis());
        String dTime = new SimpleDateFormat("yyyyMMdd").format(currentDateTime);
        dTime = formatTranDate(dTime);
        String dd = dTime.substring(Constants.SIX);
        String yyyy = dTime.substring(0, Constants.FOUR);
        String mm = dTime.substring(Constants.FOUR, Constants.SIX);
        String dt = yyyy + "-" + mm + "-" + dd + " 00:00:00";
        currentDateTime = java.sql.Timestamp.valueOf(dt);

        // starting or ending year should not be 0
        Timestamp currentDate = null;
        int startingYear = StringUtils.convertToInt(startDate.substring(0, Constants.FOUR));

        currentDate = getSqlDateFromDateStr(getDateStrFromSqlTimestatmp(currentDateTime));

        if (!StringUtils.validateDate(startDate)) {
          validFlag = false;
        } else if (startingYear == 0) {
          validFlag = false;
        } else if (!getSqlDateFromDateStr(startDate).before(currentDate)) {
          validFlag = false;
        } else if (endDate != null && !endDate.equals("")) {
          isFlagValid(startDate, endDate, validFlag, currentDate);
        }
      }
    } catch (Exception exp) {
      validFlag = false;
      logger.error("Error :: DateUtils :: validateStEndDate", exp);
    }

    return validFlag;
  }

  private static boolean isFlagValid(String startDate, String endDate, boolean validFlag,
      Timestamp currentDate) {
    if (endDate.length() != Constants.EIGHT) {
      validFlag = false;
    } else if (!StringUtils.validateDate(endDate)) {
      validFlag = false;
    } else {
      // starting or ending year should not be 0
      int endingYear = StringUtils.convertToInt(endDate.substring(0, Constants.FOUR));
      if ((endingYear == 0) || (!getSqlDateFromDateStr(endDate).before(currentDate)) || (!getSqlDateFromDateStr(startDate)
              .before(getSqlDateFromDateStr(formatTranDate(endDate)))) ) {
        validFlag = false;
      } 
    }
    return validFlag;
  }

  /**
   * This method will format specific month (YYMM) for transaction
   * 
   * @param tranMonth
   * @return String
   */
  public static String formatTranMonth(String tranMonth) {
    String stMonth = "";
    String stYear = "";
    String endMonth = "";
    String endYear = "";
    if (tranMonth != null && tranMonth.length() == Constants.FOUR) {
      stYear = tranMonth.substring(0, Constants.TWO);
      stMonth = tranMonth.substring(Constants.TWO);
      if (DECEMBER == StringUtils.convertToInt(stMonth)) {
        endMonth = "01";
        endYear = StringUtils.formatNumber((StringUtils.convertToInt(stYear) + 1), TWO_DIGITS);
      } else {
        endMonth = StringUtils.formatNumber((StringUtils.convertToInt(stMonth) + 1), TWO_DIGITS);
        endYear = stYear;
      }
    }
    return endYear + endMonth;
  }
  
  /**
   * This method will format specific date (YYYYMMDD) for transaction, it will
   * add one day and return the date in YYYYMMDD format.
   * 
   * @param tranDate
   * @return String
   */
  public static String formatTranDate(String inputDate) {
    String outputDate = "";

    try {
      Calendar calender = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      calender.setTime(sdf.parse(inputDate));
      calender.add(Calendar.DATE, 1); // Add one Day
      outputDate = sdf.format(calender.getTime());
    } catch (ParseException e) {
      logger.error("Error :: DateUtils :: formatTranDate", e);
    }

    return outputDate;
  }

  /**
   * This method will validate the month (YYMM) and return true if it is valid
   * 
   * @param tranMonth
   * @return boolean
   */
  public static boolean validateTranMonth(String tranMonth) {
    boolean validFlag = true;

    if (tranMonth == null || tranMonth.length() != Constants.FOUR) {
      validFlag = false;
    }
    try {
      if (validFlag) {
    	String mm = tranMonth.substring(Constants.TWO);
        String yy = tranMonth.substring(0, Constants.TWO);
        if (Integer.parseInt(yy) < 0 || Integer.parseInt(yy) > Constants.NINETYNINE
            || Integer.parseInt(mm) <= 0 || Integer.parseInt(mm) > Constants.TWELVE) {
          validFlag = false;
        }
      }
    } catch (Exception e) {
      validFlag = false;
      logger.error("Error :: DateUtils :: validateTranMonth", e);
    }
    return validFlag;
  }

  /**
   * This method used for convert String of Date(YYYYMMDD) to Sql_Timestamp.
   * 
   * @param date
   * @return TimeStamp
   */
  public static Timestamp getSqlDateFromDateStr(String dateMonYear) {
	Date convertedDateFormat = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strTodays = String.valueOf(dateMonYear);
    String year = strTodays.substring(0, Constants.FOUR);
    String month = strTodays.substring(Constants.FOUR, Constants.SIX);
    String date = strTodays.substring(Constants.SIX);
    try {
      convertedDateFormat = formatter.parse(year + "-" + month + "-" + date + " " + "00:00:00");
    } catch (ParseException e) {
      logger.error("Error :: DateUtils :: getSqlDateFromDateStr", e);
    }
    long dateLong = 0L;
    if (convertedDateFormat != null) {
      dateLong = convertedDateFormat.getTime();
    }
    return new Timestamp(dateLong);
  }

  /**
   * This method used for convert Sql_Timestamp to Date String in YYYYMMDD
   * format.
   * 
   * @param dateWithTime
   *          - String
   * @return TimeStamp (YYYYMMDD)
   */
  public static String getFormatDate(Timestamp dateWithTime) {
    String strTodays = dateWithTime.toString();
    return strTodays.substring(0, Constants.FOUR)
        + strTodays.substring(Constants.FIVE, Constants.SEVEN)
        + strTodays.substring(Constants.EIGHT, Constants.TEN)
        + strTodays.substring(Constants.ELEVEN, Constants.TWELVE)
        + strTodays.substring(Constants.THIRTEEN, Constants.FOURTEEN);
  }
  
  /**
   * This method used for convert Sql_Timestamp to Date String in YYYYMMDD
   * format.
   * 
   * @param dateWithTime
   *          - String
   * @return TimeStamp (YYYYMMDD)
   */
  public static String getDateStrFromSqlTimestatmp(Timestamp dateWithTime) {
    String strTodays = dateWithTime.toString();
    String year = strTodays.substring(0, Constants.FOUR);
    String month = strTodays.substring(Constants.FIVE, Constants.SEVEN);
    String date = strTodays.substring(Constants.EIGHT, Constants.TEN);
    return year + month + date;
  }

  public static String getFormattedTime() {
    StringBuilder formattedTime = new StringBuilder();
    Calendar c = Calendar.getInstance();
    // CCYYMMDDHHMMSS
    DecimalFormat formatter = new DecimalFormat("00");
    c.setTime(new Date());
    formattedTime.append(c.get(Calendar.YEAR));
    formattedTime.append(formatter.format(c.get(Calendar.MONTH) + 1l));
    formattedTime.append(formatter.format(c.get(Calendar.DATE)));
    formattedTime.append(formatter.format(c.get(Calendar.HOUR_OF_DAY)));
    formattedTime.append(formatter.format(c.get(Calendar.MINUTE)));
    formattedTime.append(formatter.format(c.get(Calendar.SECOND)));
    return formattedTime.toString();
  }

  public static String getResponseTime() {
	Calendar c = Calendar.getInstance();
	StringBuilder formattedTime = new StringBuilder();
    // CCYYMMDDHHMMSS
    DecimalFormat formatter = new DecimalFormat("00");
    c.setTime(new Date());
    formattedTime.append(formatter.format(c.get(Calendar.HOUR_OF_DAY)));
    formattedTime.append(formatter.format(c.get(Calendar.MINUTE)));
    return formattedTime.toString();
  }

  /**
   * Method to check the requested time and session registry time
   * 
   * @return
   */
  public static boolean isValidRequestSessionRegistryTime(SessionInformation sessionInformation) {
    Date lastSessionRequestDate = sessionInformation.getLastRequest();
    Date lastRequestDate = new Date(lastSessionRequestDate.getTime());
    lastRequestDate.setTime(lastRequestDate.getTime()
        + (Integer.parseInt(Properties.getProperty("chatak-acq-admin.session.timeout"))
            * Constants.TIME_OUT));
    return lastRequestDate.after(new Date());
  }
  
  public static String getCurrentTime() {
    StringBuilder formattedTime = new StringBuilder();
    // CCYYMMDDHHMMSS
    DecimalFormat formatter = new DecimalFormat("00");
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    formattedTime.append(formatter.format(c.get(Calendar.HOUR_OF_DAY)));
    formattedTime.append(formatter.format(c.get(Calendar.MINUTE)));
    formattedTime.append(formatter.format(c.get(Calendar.SECOND)));
    return formattedTime.toString();
  }

  /**
   * Method to get formated string from timestamp
   * 
   * @param timestamp
   * @return
   */
  public static String timestampToString(Timestamp timestamp) {
	  SimpleDateFormat mmddyyyyformatter = new SimpleDateFormat("MM/dd/yyyy");
	  if (null == timestamp) {
      return "";
    }
    return mmddyyyyformatter.format(new Date(timestamp.getTime()));
  }
}

package com.kcss.core.util.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 * <p>
 * All letters 'A' to 'Z' and 'a' to 'z' are reserved as pattern letters. The
 * following pattern letters are defined:
 * <pre>
 *  Symbol  Meaning                     Presentation      Examples
 *  ------  -------                     ------------      -------
 *   G       era                         text              AD; Anno Domini; A
 *   u       year                        year              2004; 04
 *   y       year-of-era                 year              2004; 04
 *   D       day-of-year                 number            189
 *   M/L     month-of-year               number/text       7; 07; Jul; July; J
 *   d       day-of-month                number            10
 *
 *   Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
 *   Y       week-based-year             year              1996; 96
 *   w       week-of-week-based-year     number            27
 *   W       week-of-month               number            4
 *   E       day-of-week                 text              Tue; Tuesday; T
 *   e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
 *   F       week-of-month               number            3
 *
 *   a       am-pm-of-day                text              PM
 *   h       clock-hour-of-am-pm (1-12)  number            12
 *   K       hour-of-am-pm (0-11)        number            0
 *   k       clock-hour-of-am-pm (1-24)  number            0
 *
 *   H       hour-of-day (0-23)          number            0
 *   m       minute-of-hour              number            30
 *   s       second-of-minute            number            55
 *   S       fraction-of-second          fraction          978
 *   A       milli-of-day                number            1234
 *   n       nano-of-second              number            987654321
 *   N       nano-of-day                 number            1234000000
 *
 *   V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
 *   z       time-zone name              zone-name         Pacific Standard Time; PST
 *   O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
 *   X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
 *   x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
 *   Z       zone-offset                 offset-Z          +0000; -0800; -08:00;
 *
 *   p       pad next                    pad modifier      1
 *
 *   '       escape for text             delimiter
 *   ''      single quote                literal           '
 *   [       optional section start
 *   ]       optional section end
 *   #       reserved for future use
 *   {       reserved for future use
 *   }       reserved for future use
 * </pre>
 */
public class DateUtil {

    public static final String LONG_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmssSSS";

    public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_DATE_TIME_FORMAT_STR_EXT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String PURE_STANDARD_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmss";

    public static final String STANDARD_DATE_TIME_ZONE_FORMAT_STR ="yyyy-MM-dd HH:mm:ss Z";

    public static final String MIDDLE_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm";
    public static final String PURE_MIDDLE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmm";

    public static final String SHORT_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH";
    public static final String PURE_SHORT_DATE_TIME_FORMAT_STR = "yyyyMMddHH";

    public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String PURE_STANDARD_DATE_FORMAT_STR = "yyyyMMdd";

    public static final String MIDDLE_DATE_FORMAT_STR = "yyyy-MM";
    public static final String PURE_MIDDLE_DATE_FORMAT_STR = "yyyyMM";

    public static final String YEAR_FORMAT_STR = "yyyy";

    public static final String SHORT_STANDARD_DATE_FORMAT_STR = "MM-dd";
    public static final String PURE_SHORT_STANDARD_DATE_FORMAT_STR = "MMdd";

    // add by xieyingbin for log record start
    public static final String EXCEL_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss.SSS";
    // add by xieyingbin for log record end

    /**
     * 通用日期模式
     */
    private static final String[] GENERIC_DATE_PATTERNS = {
            LONG_DATE_TIME_FORMAT_STR, STANDARD_DATE_TIME_FORMAT_STR,
            MIDDLE_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR,STANDARD_DATE_TIME_FORMAT_STR_EXT,MIDDLE_DATE_FORMAT_STR,PURE_STANDARD_DATE_FORMAT_STR,
            STANDARD_DATE_TIME_ZONE_FORMAT_STR, EXCEL_DATE_TIME_FORMAT_STR};

    private DateUtil() {
    }

    /**
     * 日期字符串转化为日期
     *
     * @param str
     *            日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String str) {
        try {
            return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期时间格式(yyyyMMdd)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureStandardDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmmss)
     *
     * @param date
     * @return yyyyMMddHHmmss
     * @throws ParseException
     */
    public static String formatPureStandardDate(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDatetime(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmmssSSS)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
    }
    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss SSS)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime2(Date date) {
        return DateFormatUtils.format(date, LONG_DATE_TIME_FORMAT_STR);
    }
    /**
     * 日期时间格式(yyyy-MM-dd HH:mm)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmm)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 格式日期为系统的标准格式(yyyy-MM-dd)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDate(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 格式日期为系统的标准格式(yyyy-MM)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatMiddleDate(Date date) {
        return DateFormatUtils.format(date, MIDDLE_DATE_FORMAT_STR);
    }

    /**
     * 格式日期为系统的标准格式(MM-dd)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatShortStandardDate(Date date) {
        return DateFormatUtils.format(date, SHORT_STANDARD_DATE_FORMAT_STR);
    }


    public static String genStrWithPattern(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static boolean isSameDay(Date first, Date second) {
        return DateTimeComparator.getDateOnlyInstance().compare(first, second) == 0;
    }

    public static boolean isSame(Date source, Date target) {
        return DateTimeComparator.getInstance().compare(source, target) == 0;
    }

    public static boolean isAfter(Date source, Date target) {
        return DateTimeComparator.getInstance().compare(source, target) == 1;
    }

    public static boolean isBefore(Date source, Date target) {
        return DateTimeComparator.getInstance().compare(source, target) == -1;
    }

    public static long daysBetween(Date start, Date end) {
        return Days.daysBetween(new LocalDate(start.getTime()), new LocalDate(end.getTime())).getDays();
    }

    public static int yearsBetween(Date start, Date end) {
        return Years.yearsBetween(new LocalDate(start.getTime()), new LocalDate(end.getTime())).getYears();
    }

    /**
     * date 增加days天
     *
     * @param date
     * @return
     */
    public static Date plusDays(Date date, long days) {
        if (date == null) {
            return null;
        }
        LocalDateTime dueDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return Date.from(dueDateTime
                .plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * date 减少days天
     *
     * @param date
     * @return
     */
    public static Date minusDays(Date date, long days) {
        if (date == null) {
            return null;
        }
        LocalDateTime dueDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return Date.from(dueDateTime
                .minusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * 获取现在时间-->GTM+0
     * @param
     * @return
     */
    public static Date nowDateGMT0(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+0"));
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

}

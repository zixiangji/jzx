package com.jzx.basic.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 时间工具
 */
public class TimeUtil {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(dateToLocalDateTime(date, "yyyy-MM-dd HH:mm:SS"));
    }

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获得weekPlus个周后的dayOfWeek周几的时间
     *
     * @param weekPlus
     * @param dayOfWeek
     * @return
     */
    public static LocalDate getCurrentWeekPlusDay(int weekPlus, int dayOfWeek) {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayWeek = DayOfWeek.of(dayOfWeek);
        return getWeekPlusDay(localDate, weekPlus, dayWeek);
    }

    public static LocalDate getWeekPlusDay(LocalDate localDate, int weekPlus, DayOfWeek dayOfWeek) {
        return localDate.with(TemporalAdjusters.dayOfWeekInMonth(weekPlus, dayOfWeek));
    }

    /**
     * 根据字符串和pattern获得LocalDate
     */
    public static LocalDate getLocalDateByStr(String str, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(str, formatter);
    }

    /**
     * 获得指定日期所在月的第一天
     */
    public static Date getMonthFirstDay(LocalDate today) {
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        ZonedDateTime firstDateTime = firstDayOfThisMonth.atStartOfDay(ZoneId.systemDefault());
        return Date.from(firstDateTime.toInstant());
    }

    /**
     * 获得指定日期所在月的最后一天
     */
    public static Date getMonthLastDay(LocalDate today) {
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        ZonedDateTime lastDateTime = lastDayOfThisMonth.atStartOfDay(ZoneId.systemDefault());
        return Date.from(lastDateTime.toInstant());
    }

    /**
     * 按照特定格式返回时间字符串
     *
     * @param date    时间
     * @param pattern 返回的格式
     * @return string
     */
    public static String dateToLocalDateTime(Date date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone).format(formatter);
    }

    /**
     * @param year    年为0则是全部，后面的季度和月份就不用选择了
     * @param quarter 季度[0,1,2,3,4],0是全部，剩下的是四个季度，1-3,4-6,7,9,10-12
     * @param month   月份[0-12]
     * @return
     */
    public static List<Date> getDateList(int year, int quarter, int month) {

        List<Date> list = new ArrayList<>(2);
        LocalDateTime d1 = null;
        LocalDateTime d2 = null;

        LocalDateTime localDate = LocalDateTime.now();
        if (year == 0 || (localDate.getYear() != year && localDate.getYear() - 1 != year)) {
            list.add(null);
            list.add(null);
            return list;
        }

        //全年
        if (quarter == 0 && month == 0) {
            d1 = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0);
            d2 = LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59);
        } else {
            switch (quarter) {
                case 1:
                    d1 = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0);
                    d2 = LocalDateTime.of(year, Month.MARCH, 31, 23, 59);
                    break;
                case 2:
                    d1 = LocalDateTime.of(year, Month.APRIL, 1, 0, 0);
                    d2 = LocalDateTime.of(year, Month.JUNE, 30, 23, 59);
                    break;
                case 3:
                    d1 = LocalDateTime.of(year, Month.JULY, 1, 0, 0);
                    d2 = LocalDateTime.of(year, Month.SEPTEMBER, 30, 23, 59);
                    break;
                case 4:
                    d1 = LocalDateTime.of(year, Month.OCTOBER, 1, 0, 0);
                    d2 = LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59);
                    break;
                default:
            }
            if (month != 0) {
                d1 = LocalDateTime.of(year, month, 1, 0, 0);
                d2 = d1.with(TemporalAdjusters.lastDayOfMonth());
            }
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt1 = d1.atZone(zoneId);
        ZonedDateTime zdt2 = d2.atZone(zoneId);
        Date from = Date.from(zdt1.toInstant());
        Date to = Date.from(zdt2.toInstant());
        list.add(from);
        list.add(to);
        return list;
    }

}

package com.jzx.basic.time;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TimeDemo {

    public static void localDateInfo() {
        // 设置日期
//        LocalDate localDate = LocalDate.of(2020, 6, 4);
        LocalDate localDate = LocalDate.now();


        int year = localDate.getYear();// 获取年份
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year + "\t" + year1);

        Month month = localDate.getMonth();   // 获取月份
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month + "\t" + month1);
        // 获取日
        int day = localDate.getDayOfMonth();   //结果：10
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH); // 结果：10
        System.out.println(day + "\t" + day1);
        // 获取今天是星期几
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();   //结果：TUESDAY
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK); //结果：2
        System.out.println(dayOfWeek + "\t" + dayOfWeek1);


        LocalDate dayOfWeekInMonth = localDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY));
        System.out.println(dayOfWeekInMonth);
    }

    public static void localTimeInfoStatus() {
        // 设置时间
        LocalTime localTime = LocalTime.of(13, 51, 10);
        //获取小时
        int hour = localTime.getHour();    // 结果：13
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY); // 结果：13
        System.out.println(hour + "\t" + hour1);
        //获取分
        int minute = localTime.getMinute();  // 结果：51
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR); // 结果：51
        System.out.println(minute + "\t" + minute1);
        //获取秒
        int second = localTime.getSecond();   // 结果：10
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE); // 结果：10
        System.out.println(second + "\t" + second1);


    }

    public static void localDateTimeStatus() {
        // 获取当前环境下时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        // +3天
        System.out.println(localDateTime.plusDays(3));
        // -3天
        System.out.println(localDateTime.minusDays(3));
    }

    // Instant基本信息
    public static void instantInfoStatus() {
        // Instant是时间线上的瞬时点，和System.currentTimeMillis()类似
        Instant instant = Instant.now();
        Instant ss = Instant.ofEpochMilli(1590718068280L);
        System.out.println(ss);
        System.out.println(instant.toString());
        System.out.println(instant.getEpochSecond());// 获取的秒
        System.out.println(instant.getNano());
        System.out.println(instant.compareTo(ss));
    }

    public static void main(String[] args) {

        localDateInfo();
    }
}

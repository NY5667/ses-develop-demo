package com.supcon.ses.developer.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * <p>
 *     日期操作工具类
 * </p>
 * @author lufengdong
 * @create 2022-08-19 15:02
 */
public class DateUtils {
    public static String DATE_FORMAT = "yyyyMMdd";
    public static String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public static String BAR_DATE_FORMAT = "yyyy-MM-dd";
    public static String BAR_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String ISO_DATE_TIME_FORMAT = "yyyyMMddHHmmssSSS";
    public static String DAY_MIN_HMS = " 00:00:00";
    public static String DAY_MAX_HMS = " 23:59:59";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final DateTimeFormatter BAR_DATE_FORMATTER = DateTimeFormatter.ofPattern(BAR_DATE_FORMAT);
    public static final DateTimeFormatter BAR_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(BAR_DATE_TIME_FORMAT);
    public static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern(ISO_DATE_TIME_FORMAT);

    public static String timeStamp2Str(Timestamp timestamp, String format){
        if(Objects.isNull(timestamp)){
            return null;
        }
        if(StringUtils.isBlank(format)){
            format = BAR_DATE_FORMAT;
        }
        return localDateTime2Str(timestamp.toLocalDateTime(), format);
    }

    public static String localDateTime2Str(LocalDateTime localDateTime){
        return localDateTime2Str(localDateTime, null);
    }

    // LocalDateTime转成指定格式的日期字符串
    public static String localDateTime2Str(LocalDateTime localDateTime, String format){
        if(Objects.isNull(localDateTime)){
            return null;
        }
        if(StringUtils.isBlank(format)){
            format = BAR_DATE_TIME_FORMAT;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    // yyyy-MM-dd HH:mm:ss格式日期字符串转LocalDateTime
    public static LocalDateTime str2LocalDateTime(String dateTime){
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

    // yyyy-MM-dd格式日期字符串转LocalDate
    public static LocalDate str2LocalDate(String date){
        return LocalDate.parse(date, BAR_DATE_FORMATTER);
    }

    // LocalDate转指定格式的字符串
    public static String localDate2Str(LocalDate date, String format){
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    // 获取一天的最大和最小时间字符串
    public static Pair<String, String> getMinAndMaxOfDay(LocalDate localDate){
        String min = localDateTime2Str(LocalDateTime.of(localDate, LocalTime.MIN), BAR_DATE_TIME_FORMAT);
        String max = localDateTime2Str(LocalDateTime.of(localDate, LocalTime.MAX), BAR_DATE_TIME_FORMAT);
        return new MutablePair<>(min, max);
    }

    // 获取指定日期前一周的第一天和最后一天
    public static Pair<String, String> getPreviousWeekStartAndEnd(String date, String format){
        LocalDate localDate = str2LocalDate(date);
        return getPreviousWeekStartAndEnd(localDate, format);
    }

    // 获取指定日期前一周的第一天和最后一天
    public static Pair<String, String> getPreviousWeekStartAndEnd(LocalDate localDate, String format){
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        final LocalDate from = localDate.minusDays((dayOfWeek -1) +  7);
        final LocalDate to = localDate.minusDays(dayOfWeek);
        return new MutablePair<>(DateUtils.localDate2Str(from, format), DateUtils.localDate2Str(to, format));
    }
}

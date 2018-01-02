package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseString(String timing) throws ParseException {
        return mSimpleDateFormat.parse(timing);
    }
    /**
     *
     * @param date
     * @return 转换好的日期格式
     */
    public static String parseDate(Date date) {
        return mSimpleDateFormat.format(date);
    }

    /**
     * 计算出发时间和结束时间的间隔（毫秒）权值
     * @param departureTime
     * @param arrivalTime
     * @return 间隔时间（long）
     */
    public static long parseLongTimeConsuming(Date departureTime, Date arrivalTime) {
        return 0;
    }

    /**
     * 计算出发时间和结束时间的间隔
     * @param departureTime
     * @param arrivalTime
     * @return 间隔时间
     */
    public static String timeConsuming(Date departureTime, Date arrivalTime) {
        long startTime = departureTime.getTime();
        long endTime = arrivalTime.getTime();
        long intervalTime = endTime - startTime;
        int seconds = (int) (intervalTime / 1000);
        String timeStr = "";
        long min = 0;
        long hour = 0;
        long day = 0;
        if (seconds > 60) {
            min = seconds / 60;
            if (min > 60) {
                min = (seconds / 60) % 60;
                hour = (seconds / 60) / 60;
                if (hour > 24) {
                    hour = ((seconds / 60) / 60) % 24;
                    day = (((seconds / 60) / 60) / 24);
                }
            }
        }
        if (min != 0) {
            timeStr = min + "分钟";
        }
        if (hour != 0) {
            timeStr = hour + "小时" + timeStr;
        }
        if (day != 0) {
            timeStr = day + "天" + timeStr;
        }
        return timeStr;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = new (simpleDateFormat.format("2017-1-1"));
        Date date = simpleDateFormat.parse("2018-1-1 14:00:00");
        Date date1 = simpleDateFormat.parse("2018-1-2 14:01:56");

        System.out.println(timeConsuming(date, date1));
    }
}

package io.bxbxbai.zhuanlan.utils;

import android.text.format.DateUtils;
import io.bxbxbai.zhuanlan.App;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author bxbxbai
 */
public class Utils {

    private static final int MINUTE = 60;
    private static final int HOUR = MINUTE * 60;
    private static final int DAY = HOUR * 24;
    private static final int MONTH = DAY * 30;
    private static final int YEAR = MONTH * 12;

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");


    public static String getAuthorAvatarUrl(String origin, String userId, String size) {
        origin = origin.replace(ZhuanLanApi.TEMPLATE_ID, userId);
        return origin.replace(ZhuanLanApi.TEMPLATE_SIZE, size);
    }

    public static String convertPublishTime(String time) {
        try {
            long s = TimeUnit.MILLISECONDS.toSeconds(
                    new Date().getTime() - FORMAT.parse(time).getTime());

            long count = s / YEAR;
            if (count != 0) {
                return count + "年前";
            }

            count = s / MONTH;
            if (count != 0) {
                return count + "月前";
            }

            count = s / DAY;
            if (count != 0) {
                return count + "天前";
            }

            return "今天";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "未知时间";
    }
}

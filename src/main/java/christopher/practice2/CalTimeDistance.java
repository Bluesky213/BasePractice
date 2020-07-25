/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Christopher
 */
public class CalTimeDistance {
    public static void main(String args[]) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date1 = format.parse("2019-09-20 12:12:12");
//        Date date2 = format.parse("2019-09-11  12:12:12");
        Date date2 = new Date();
       System.out.println(getDistanceTime2(date1,date2));
    }
    
        public static double getDistanceTime2(Date startTime, Date endTime) {
        double minute = 0;
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        minute = (diff / (60 * 1000));
        return minute;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Bluesky
 */
public class timetest {
    public static void main(String args[]){
        Date date=new Date();//Date 出来的对象就是当前的时间
        //date=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
                    calendar.set(Calendar.MINUTE,0);
                    calendar.set(Calendar.SECOND,0);
//        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(sdf.format(calendar.getTime()));
//        System.out.println(time);
    }
}

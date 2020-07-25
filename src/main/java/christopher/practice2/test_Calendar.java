/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Bluesky
 * 日期的add操作会自动计算跨越月份和日期
 */
public class test_Calendar {
    public static void main(String args[]){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
        
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        cal.add(Calendar.DATE, -3);//日期加一天
        //月份加一天是cal.add(Calendar.MONTH,1)
        System.out.println(cal.getTime());
        //cal.set(Calendar.MONTH, 10);赋值操作
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        if(cal.get(Calendar.MONTH)<10&&cal.get(Calendar.DAY_OF_MONTH)<10)
        {
            sdf=new SimpleDateFormat("M月/D日");
        }
        String time=String.valueOf(sdf.format(cal.getTime()));
        System.out.println(sdf.format(cal.getTime()));
        
        //SimpleDateFormat sdf=new SimpleDateFormat("MM/DD");
        //System.out.println(sdf.format(cal.getTime()));
    }
}

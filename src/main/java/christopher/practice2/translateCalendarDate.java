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
 */
public class translateCalendarDate {
    public static void main(String args[]){
        Calendar cal=Calendar.getInstance();
        //Calendar.getInstance()就是获得当前日历时间
        //String time=getDate(cal,1);
        //cal.set(2019, 1, 12);
        String time=getDate(cal,0);
        System.out.println(time);
    }
    public static String getDate(Calendar cal,int num){
        //Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        SimpleDateFormat sdf = null;
        
//        if(cal.get(Calendar.MONTH)<10&&cal.get(Calendar.DAY_OF_MONTH)<10)
//        {
//            sdf=new SimpleDateFormat("M月/D日");
//        }
//        if(cal.get(Calendar.MONTH)>=10&&cal.get(Calendar.DAY_OF_MONTH)<10)
//        {
//            sdf=new SimpleDateFormat("MM月/D日");
//        }
//        if(cal.get(Calendar.MONTH)<10&&cal.get(Calendar.DAY_OF_MONTH)>=10)
//        {
//            sdf=new SimpleDateFormat("M月/DD日");
////            System.out.println("DAY_OF_MONTH:"+cal.get(Calendar.DAY_OF_MONTH));
//            System.out.println(cal.get(Calendar.MONTH)+1+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
//        }
//        if(cal.get(Calendar.MONTH)>=10&&cal.get(Calendar.DAY_OF_MONTH)>=10)
//        {
//            sdf=new SimpleDateFormat("MM月/DD日");
//            
//        }
        String time=String.valueOf(cal.get(Calendar.MONTH)+1+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
        //System.out.println(cal.get(Calendar.MONTH)+1+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
//        String time=sdf.format(cal.getTime());//将cal中的时间格式化成sdf形式的
        return time;
    }
    
}

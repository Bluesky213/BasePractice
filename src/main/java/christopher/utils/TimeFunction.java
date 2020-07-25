package christopher.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeFunction {
    public static void main(String[] args) {
        calendarAsend();
    }
    public static void calendarAsend(){
        String startTime = "2020-07-10";
        String endTime   = "2020-07-31";
        SimpleDateFormat sdfDay =  new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(sdf.parse(startTime +" 00:00:00"));
        }catch(Exception e){
            e.printStackTrace();
        }
        for(;calendar.compareTo(Calendar.getInstance())!=1;calendar.add(Calendar.DATE,1)){//从过去某日到现在
            System.out.println(sdf.format(calendar.getTime()));
        }
        for(;calendar.compareTo(Calendar.getInstance())!=1;calendar.add(Calendar.DATE,1)){//从过去的一个时间段
            System.out.println(sdfDay.format(calendar.getTime()));
            if(sdfDay.format(calendar.getTime()).equals(endTime)){
                break;
            }
        }
    }
}
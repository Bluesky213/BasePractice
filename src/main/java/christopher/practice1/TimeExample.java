/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bluesky
 */
public class TimeExample {
    public static void main(String[] args) {
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm"); 
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4=new SimpleDateFormat(
                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        Date now=new Date();
        System.out.println(myFmt.format(now));
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
        System.out.println(now.toGMTString());
        System.out.println(now.toLocaleString());
        System.out.println(now.toString());
    }    
    
}
/**
  SimpleDateFormat函数语法：
  
  G 年代标志符
  y 年
  M 月
  d 日
  h 时 在上午或下午 (1~12)
  H 时 在一天中 (0~23)
  m 分
  s 秒
  S 毫秒
  E 星期
  D 一年中的第几天
  F 一月中第几个星期几
  w 一年中第几个星期
  W 一月中第几个星期
  a 上午 / 下午 标记符 
  k 时 在一天中 (1~24)
  K 时 在上午或下午 (0~11)
  z 时区
 */

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
 * @author Bluesky
 */
public class days {

    public static void main(String args[]) throws ParseException{
        int k=0;
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
        for(int i=1949;i<=2017;i++)
        {
            Date date1=sdf1.parse(String.valueOf(i)+"-10-01");
            if(getWeek(date1).equals("星期日"))
            {
                k++;
            }
        }
        System.out.println("一共有"+k+"天国庆节是星期日");
        //System.out.println(date1);
        //System.out.println(getWeek(date1));
        }
    public static String getWeek(Date date){ 
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}
}

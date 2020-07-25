/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

/**
 *
 * @author Bluesky
 */
public class CutStringByContext {
    public static void main(String args[])
    {
        String str = "今日天气实况：气温：6℃；风向/风力：静风 0级；湿度：67%；紫外线强度：中等。空气质量：良。";
        System.out.println("按顺序解析结果：");
        System.out.println(str.substring(str.indexOf("：气温")+1, str.lastIndexOf("；风向")));
        System.out.println(str.substring(str.indexOf("；风向/风力")+1, str.lastIndexOf("；湿度")));
        System.out.println(str.substring(str.indexOf("；湿度")+1, str.lastIndexOf("；紫外线强度")));
        System.out.println(str.substring(str.indexOf("；紫外线强度")+1, str.lastIndexOf("。空气质量")));
        System.out.println(str.substring(str.indexOf("。空气质量：")+1, str.lastIndexOf("。")));
        System.out.println();
        System.out.println("解析后考虑布局结果：");
        System.out.println(str.substring(str.indexOf("：气温")+1, str.lastIndexOf("；风向")));
        System.out.println(str.substring(str.indexOf("；湿度")+1, str.lastIndexOf("；紫外线强度")));
        System.out.println(str.substring(str.indexOf("。空气质量：")+1, str.lastIndexOf("。")));
        System.out.println(str.substring(str.indexOf("；风向/风力")+1, str.lastIndexOf("；湿度")));
        System.out.println(str.substring(str.indexOf("；紫外线强度")+1, str.lastIndexOf("。空气质量")));
        
        String str2="12月31日 晴";
        String str3=str2.substring(str2.indexOf(" ")+1, str2.lastIndexOf(""));
        //System.out.println(str2.substring(str2.indexOf(" ")+1, str2.lastIndexOf("")));
        if (str3.equals("晴"))
        {
            System.out.println("今天是晴天");
        }
        //判断是否包含某一段字符串
        if(str2.contains("晴"))
        {System.out.println("今天是晴天");}
        if(str2.contains("雨"))
        {System.out.println("今天是雨天");}
    }
}

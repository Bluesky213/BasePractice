/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.BaiduOCR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Bluesky
 */
public class test {
    public static void main(String args[]) throws Exception
    {
       captureHtml(); 
    }
    public static void captureHtml() throws Exception {  
    String strURL = "http://jwgl.hbeu.cn:8080/hbgcxy/framework/main.jsp";  
    URL url = new URL(strURL);  
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
    InputStreamReader input = new InputStreamReader(httpConn  
            .getInputStream(), "utf-8");  
    BufferedReader bufReader = new BufferedReader(input);  
    String line = "";  
    StringBuilder contentBuf = new StringBuilder();  
    while ((line = bufReader.readLine()) != null) {  
        contentBuf.append(line);  
    }  
    String buf = contentBuf.toString();  
    int beginIx = buf.indexOf("用户名");  
    int endIx = buf.indexOf("登录");  
    String result = buf.substring(beginIx, endIx);  
    System.out.println("captureHtml()的结果：\n" + result);  
}  
}

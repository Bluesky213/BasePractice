/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2.parseXML;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author Bluesky
 */
public class HttpUtil {
    public static List doGetXml(String u){
        HttpURLConnection con=null;
        InputStream is=null;
        List list=null;
        try {
            URL url=new URL(u);
            con= (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5*1000);  //设置超时时间
            con.setReadTimeout(5*1000);     //设置读取时间
            if(con.getResponseCode()==200){ //判断是否连接成功
                is=con.getInputStream();    //获取输入
                PullXmlUtil pullXmlUtil=new PullXmlUtil(is);
                try {
                    list=pullXmlUtil.getAllElement();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null){
                    is.close();
                }
                if(con!=null){
                    con.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

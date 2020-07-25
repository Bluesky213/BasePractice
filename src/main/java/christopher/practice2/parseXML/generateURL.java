/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2.parseXML;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bluesky
 */
public class generateURL {
    public static String URL_PROVINCE = "http://www.webxml.com.cn/webservices/weatherwebservice.asmx/getSupportProvince";
    public List provinceList;
    public static void main(String args[]){
        generateURL get=new generateURL();
        //get.provinceList=get.DoGetProvince(URL_PROVINCE);
        Iterator it=get.DoGetProvince(URL_PROVINCE).iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }
    public List DoGetProvince(String url){
        return HttpUtil.doGetXml(url);
    }
}

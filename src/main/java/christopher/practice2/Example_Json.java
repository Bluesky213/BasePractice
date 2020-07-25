/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Bluesky
 */
public class Example_Json {
    Example_Json e=new Example_Json();
    public static void main(String args[]) throws JSONException
    {
        JSONObject jsonObj  = new JSONObject();
        jsonObj.put("name0", "zhangsan");
        jsonObj.put("sex1", "female");
        //1.将JSON按照字符串格式输出
        System.out.println(jsonObj);
        //2.获取Json数据中某个Key对应的value
        System.out.println(jsonObj.get("sex1"));
        //3.Json数组
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("11");
        jsonArray.put("22");
        jsonArray.put("33");
        jsonArray.put("44");
        //jsonArray.add("11");
        //jsonArray.add("22");
        //jsonArray.add("33");
        System.out.println(jsonArray);    //输出为：["11","22","33"]
        
        
    }
}

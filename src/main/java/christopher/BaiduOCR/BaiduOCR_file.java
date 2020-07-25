/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.BaiduOCR;

import christopher.BaiduOCR.utils.Base64Util;
import christopher.BaiduOCR.utils.FileUtil;
import christopher.BaiduOCR.utils.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bluesky
 */
public class BaiduOCR_file {  
  
      
    public static void main(String[] args) {  
          
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";  
            // 本地图片路径  
            String filePath = "C:\\Users\\Bluesky\\Desktop\\verifycode.jpg";  
            try {
                byte[] imgData = FileUtil.readFileByBytes(filePath);
                String imgStr = Base64Util.encode(imgData);
                String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
                /** 
                 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。 
                 */  
                String accessToken = getAuth("cMDWENanytGLZn9s6WE0KEsH", "KKs7rfO4UqKmU0SkBwl42cTeurGY92gR");  
                String result = HttpUtil.post(otherHost, accessToken, params);
                //result是所有请求得到的信息
                //System.out.println(result); 
                //从得到的json格式的result中获取OCR文字识别结果
                JSONObject json=new JSONObject(result);
                    JSONArray words_result=json.getJSONArray("words_result");
                        JSONObject json0=words_result.getJSONObject(0);
                        String words=String.valueOf(json0.get("words"));
                 System.out.println(words);
            } catch (Exception e) {
                e.printStackTrace();  
            }
    }
  
  
      
     public static String getAuth(String ak, String sk) {
            // 获取token地址  
            String authHost = "https://aip.baidubce.com/oauth/2.0/token?";  
            String getAccessTokenUrl = authHost  
                    // 1. grant_type为固定参数  
                    + "grant_type=client_credentials"  
                    // 2. 官网获取的 API Key  
                    + "&client_id=" + ak  
                    // 3. 官网获取的 Secret Key  
                    + "&client_secret=" + sk;  
            try {  
                URL realUrl = new URL(getAccessTokenUrl);  
                // 打开和URL之间的连接  
                HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();  
                connection.setRequestMethod("GET");  
                connection.connect();  
                // 获取所有响应头字段  
                Map<String, List<String>> map = connection.getHeaderFields();  
                // 遍历所有的响应头字段  
                for (String key : map.keySet()) {  
                    System.err.println(key + "--->" + map.get(key));  
                }  
                // 定义 BufferedReader输入流来读取URL的响应  
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
                String result = "";  
                String line;  
                while ((line = in.readLine()) != null) {  
                    result += line;  
                }  
                /** 
                 * 返回结果示例 
                 */  
                System.err.println("result:" + result);  
                JSONObject jsonObject = new JSONObject(result);
                String access_token = jsonObject.getString("access_token");  
                return access_token;  
            } catch (Exception e) {  
                System.err.printf("获取token失败！");  
                e.printStackTrace(System.err);  
            }  
            return null;  
        }  
}
      

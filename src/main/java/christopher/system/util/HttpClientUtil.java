package christopher.system.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用HttpClient进行post请求的工具类
 * @ClassName: HttpClientUtil
 * @author Devin <xxx> 
 * @date 2017年2月7日 下午1:43:38 
 *
 */
public class HttpClientUtil {
    @SuppressWarnings("resource")
    public static String doPost (String url,String jsonstr,String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type","application/json;charset=utf-8");

            httpPost.setEntity(new StringEntity(jsonstr, Charset.forName("UTF-8")));httpPost.setHeader("Accept","application/json");
            //设置超时时间
//            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).setConnectionRequestTimeout(1000).setStaleConnectionCheckEnabled(true).build();
//            httpPost.setConfig(requestConfig);
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,3000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,3000);
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            String exceptionMsg = ex.getMessage();
            Map<String,Object> exceptionResult = new HashMap<>();
//            switch (exceptionMsg){
//                case "Connection refused: connect":
//                    exceptionResult.put("responseCode",ConnectionErrorCode);
//                    exceptionResult.put("responseMessage",ConnectionErrorMessage);
//                    break;
//                case "Read timed out":
//                    exceptionResult.put("responseCode",ConnectionTimeoutCode);
//                    exceptionResult.put("responseMessage",ConnectionTimeoutMessage);
//                    break;
//            }
            return JSONObject.toJSONString(exceptionResult);
        }
        return result;
    }
}
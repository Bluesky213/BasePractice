package christopher.practice2;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.google.gson.Gson;

public class extractImg {
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)"; 
    public static void main(String []args)
    {
        String html="<p>wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！wxParse测试程序，希望这次可以成功执行！</p><p><img src=\"http://localhost:8080/wechatServlet/images/hbeutext.jpg\" title=\"1557110118512023793.jpg\" alt=\"left.jpg\" width=\"646\" height=\"311\"/></p><p><img src=\"http://localhost:8080/wechatServlet/images/hbeutext.jpg\" title=\"1557110132239092618.jpg\" alt=\"right.jpg\" width=\"696\" height=\"312\"/></p>";
//        List<String> list=getImageSrc(html);
//        Gson gson = new Gson();
//        String str = gson.toJson(list);
//        System.out.println(str);
        System.out.println(listToJson(html));
        //
        try {
			System.out.println(listToJsonByMap(getImageSrc(html)));
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
    
    public static String listToJson(String html)
    {
        Gson gson = new Gson();
        String str = gson.toJson(getImageSrc(html));
        return str;
    }
    
    
public static List<String> getImageSrc(String htmlCode) {
    List<String> imageSrcList = new ArrayList<String>();
    Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(htmlCode);
    String quote = null;
    String src = null;
    while (m.find()) {
        quote = m.group(1);
        src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);
        imageSrcList.add(src);
    }
    return imageSrcList;
}

    public static JSONArray listToJsonByMap(List<String> list) throws JSONException{
         JSONArray json = new JSONArray();
         for(String element : list){
             JSONObject jo = new JSONObject();
             jo.put("src", element);
             json.put(jo);
         }
         return json;
    }
    
    public static String[] convertStrToArray(String str){   
        String[] strArray = null;   
        strArray = str.split(","); //拆分字符为"," ,然后把结果交给数组strArray 
        return strArray;
    }
}

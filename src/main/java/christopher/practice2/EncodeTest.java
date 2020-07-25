/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Christopher
 */
public class EncodeTest {
    public static void main(String args[]) throws UnsupportedEncodingException{
        String[] str = new String[7];
        str[0]="福建坤彩材料科技股份有限公司";
        str[1]="福建坤彩材料科技股份有限公司";
        str[2]="福建宇邦纺织科技有限公司";
        str[3]="福建康宏股份有限公司";
        str[4]="福建长德蛋白科技有限公司";
        str[5]="福建海岸纺织科技有限公司";
        str[6]="福建天马科技集团股份有限公司";
        for(String s:str){
            System.out.println(new String(stringToUnicode(s)));//ISO-8859-1
        }
    }
    
    public static String stringToUnicode(String s) {
        try {
                StringBuffer out = new StringBuffer("");
                //直接获取字符串的unicode二进制
                byte[] bytes = s.getBytes("unicode");
                //然后将其byte转换成对应的16进制表示即可
                for (int i = 0; i < bytes.length - 1; i += 2) {
                        out.append("&#x");
                        String str = Integer.toHexString(bytes[i + 1] & 0xff);
                        for (int j = str.length(); j < 2; j++) {
                                out.append("0");
                        }
                        String str1 = Integer.toHexString(bytes[i] & 0xff);
                        out.append(str1);
                        out.append(str);
                        out.append(";");
                }
                return out.toString();
        } catch (Exception e) {
                e.printStackTrace();
                return null;
        }
    }
    public static String convertStringToUTF8(String s) {  
        if (s == null || s.equals("")) {  
            return null;  
        }  
        StringBuffer sb = new StringBuffer();  
        try {  
            char c;  
            for (int i = 0; i < s.length(); i++) {  
                c = s.charAt(i);  
                if (c >= 0 && c <= 255) {  
                    sb.append(c);  
                } else {  
                    byte[] b;  
  
                    b = Character.toString(c).getBytes("utf-8");  
  
                    for (int j = 0; j < b.length; j++) {  
                        int k = b[j];  
                        if (k < 0)  
                            k += 256;  
                        sb.append(Integer.toHexString(k).toUpperCase());  
                        // sb.append("%" +Integer.toHexString(k).toUpperCase());  
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
  
        }  
        return sb.toString();  
    }  
}

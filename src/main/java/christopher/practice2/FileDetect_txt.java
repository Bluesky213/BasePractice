/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import javax.net.ssl.SSLException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 *
 * @author Bluesky
 */
public class FileDetect_txt {
    public static void main(String[] args) throws Exception{
        //HashMap
        HashMap<String, String> map = new HashMap();//map用来存储Key和Secret
        HashMap<String, byte[]> byteMap = new HashMap();
        map.put("api_key", "Ac6FhyXwhRsyVu_EA_c0Mwc6BGrzsNGN");
        map.put("api_secret", "F7hQgnIi7QNvGpBiSAOmupbRdVZLJbTu");
        //API的访问地址
            String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
            //String url = "https://api-cn.faceplusplus.com/facepp/v3/face/analyze";
        //要获取其下所有文件路径的目录路径
        String filePath = "E:\\Schoolphotos\\15\\17\\0153017541";
        ArrayList<String> filelist=new ArrayList<String>();
        filelist=getFiles2(filePath,filelist);
        for(String a:filelist)
        {
            File file = new File(a);
            byte[] buff = getBytesFromFile(file);//buff是图片的二进制数据
            byteMap.put("image_file", buff);//byteMap用来存储key为"image_file"的字节类型图片数据buff
            try
            {
                byte[] json = post(url, map, byteMap);//图片路径，key和secret，图片二进制数据
                System.out.println(file.getName()+":"+new String(json));//post()函数返回byte[]的字节数据转换成字符串类型并输出——最终的JSON格式的数据
                if(new String(json).contains("error"))
                {
                    writeself(byteMap,url,map,a);
                }
                else
                writeFaceInfo(json);
            }
            catch (Exception e) 
            {
                    e.printStackTrace();
            }
        }
	}
        //用于网络挤塞时再次上传图片并识别
        public static void writeself(HashMap<String, byte[]> byteMap,String url,HashMap<String, String> map,String a){
            File file = new File(a);
            byte[] buff = getBytesFromFile(file);//buff是图片的二进制数据
            byteMap.put("image_file", buff);//byteMap用来存储key为"image_file"的字节类型图片数据buff
            try
            {
                byte[] json = post(url, map, byteMap);//图片路径，key和secret，图片二进制数据
                System.out.println(new String(json));//post()函数返回byte[]的字节数据转换成字符串类型并输出——最终的JSON格式的数据
                if(new String(json).contains("error"))
                {
                    writeself(byteMap,url,map,a);
                }
                else
                writeFaceInfo(json);
            }
            catch (Exception e) 
            {
                    e.printStackTrace();
            }
        }
        public static void writeFaceInfo(byte[] info) throws IOException{
        String filename="C:/Users/Bluesky/Desktop/3.txt";
        java.io.BufferedWriter writer=new java.io.BufferedWriter(new FileWriter(filename,true));//建议需要写入大量的文本内容时使用BufferedWriter
        //将FIleWriter嵌套在BufferedWriter中
        writer.write(new String(info));
        writer.newLine();
        //writer.write("This is another text file using BufferedWrite,");
        //writer.newLine();
        //writer.write("So I can use a common way to start a newLine");
        writer.close();
    }
    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();//目的是防止上传文件中出现分隔符导致服务器无法正确识别文件起始位置
    
    //1.人脸识别地址url
    //2.存放api_key和api_secret的map
    //3.存放图片文件二进制数据的fileMap
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;//新建一个HttpURLConnection对象conne
        URL url1 = new URL(url);//新建一个URL对象url1
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);//设置连接超时时间
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        //Content-Type的类型扩充了multipart/form-data用以支持向服务器发送二进制数据
        //enctype表示在将数据发送至服务器前如何进行编码，默认是：Content-Type:application/x-www-form-urlencoded
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());//新建一个数据输出流DataOuputStream
        Iterator iter = map.entrySet().iterator();//entrySet()用于遍历map
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();//差不多是单个键值对的意思
            String key = entry.getKey();//遍历获取Map的Key
            String value = entry.getValue();//遍历获取Map的Value
            //obos写入:
            //--字符串
            //Content-Disposition:form-data;name=\"key\"
            //
            //value
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap != null && fileMap.size() > 0){//遍历FileMap
            Iterator fileIter = fileMap.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                //obos写入:
                //--字符串
                //Content-Disposition:form-data;name=\"  fileEntry.getKey()  \";filename=\"  encode(" ") \"
                //
                //fileEntry.getValue()
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());//写入文件
                obos.writeBytes("\r\n");
            }
        }
        //--字符串--
        //
        
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){//返回200表示连接成功
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//新建一个字节输出流对象
        byte[] buff = new byte[4096];       //byte一个字节数组【4096】
        int len;
        while((len = ins.read(buff)) != -1){//如果输入流不为空
            baos.write(buff, 0, len);       //连续写入
        }
        byte[] bytes = baos.toByteArray();//将写好的baos转换成字节数组
        ins.close();
        return bytes;
    }

    private static String getBoundary() {//执行32次 将后面的字符串从第随机数位开始截取的字符串的相加 得到的字符串
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }

    private static String encode(String value) throws Exception{//转成UTF-8的编码格式
        return URLEncoder.encode(value, "UTF-8");
    }
    
    public static byte[] getBytesFromFile(File f) {//返回该文件的字节类型
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();//将文件读进去并写出成Byte字节数组然后返回
        } catch (IOException e) {
        }
        return null;
    }
    
    //用于得到该目录下所有根文件的路径字符串
    static ArrayList<String> getFiles2(String filePath,ArrayList<String> filelist){
    //ArrayList<String> filelist = new ArrayList<String>();
    File root = new File(filePath);
    File[] files = root.listFiles();
    
    for(File file:files){     
     if(file.isDirectory()){//如果时目录则递归调用函数自身继续寻找该目录下的子文件夹
      /*
       * 递归调用
       */
      getFiles2(file.getAbsolutePath(),filelist);
      //放在上面表示存储各目录及其子目录的路径
      //filelist.add(file.getAbsolutePath());
      //System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
     }else{
      //System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
      //System.out.println(file.getAbsolutePath());
      //放在下面表示存储该根目录下所有子文件路径
      filelist.add(file.getAbsolutePath());
     }
    }
    return filelist;
 }
}

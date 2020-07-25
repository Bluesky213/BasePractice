/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.BaiduOCR;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @说明 从网络获取图片到本地
 * @author 崔素强
 * @version 1.0
 * @since
 */
public class GetImage {

    static String url = "http://jwgl.hbeu.cn:8080/hbgcxy/verifycode.servlet";

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        //String url = "http://jwgl.hbeu.cn:8080/hbgcxy/uploadfile/studentphoto/pic/015301754103.JPG";String url = "http://jwgl.hbeu.cn:8080/hbgcxy/uploadfile/studentphoto/pic/015301754103.JPG";
        getAndWriteImage();

    }
    public static void getAndWriteImage() {
        byte[] btImg = getImageFromNetByUrl(url);
        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "Schoolphotos\\VerifyCodes\\00001.jpg";
            writeImageToDisk(btImg, fileName);
        } else {
            System.out.println("没有从该连接获得内容");
        }
    }
    //自己写的：从教务管理系统下载一个验证码图片
    public static byte[] getImage() throws MalformedURLException {
        URL url = new URL("http://jwgl.hbeu.cn:8080/hbgcxy/verifycode.servlet");
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            if(btImg==null||btImg.length==0)
            {
                getImage();
            }
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将图片写入到磁盘
     *
     * @param img 图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName) {
        try {
            File file = new File("E:\\" + fileName);
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("图片已经写入到磁盘");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}

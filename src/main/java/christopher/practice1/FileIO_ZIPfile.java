/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Bluesky
 */
public class FileIO_ZIPfile {
    public static void main(String []args)throws IOException{
        FileInputStream in=new FileInputStream("C:/Users/Bluesky/Desktop/1.txt");
        GZIPOutputStream out=new GZIPOutputStream(new FileOutputStream("C:/Users/Bluesky/Desktop/test.gz"));
        System.out.println("writing compressing file from D:/Hello.txt tp D:/tezt.gz");
        int c;
        while((c=in.read())!=-1){
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file from D:/test.gz to monitor");
        BufferedReader in2=new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("C:/Users/Bluesky/Desktop/test.gz"))));
        String s ;
        while ((s=in2.readLine())!=null){
            System.out.println(s);         
        }
        in2.close();
        System.out.println("Writing decompression to D:/newHello.txt");
        GZIPInputStream in3=new GZIPInputStream(new FileInputStream("C:/Users/Bluesky/Desktop/test.gz"));
        FileOutputStream out2=new FileOutputStream("C:/Users/Bluesky/Desktop/thenew1.txt");
        while((c=in3.read())!=-1){
        out2.write(c);
        }
        in3.close();
        out2.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.File;

/**
 *
 * @author Bluesky
 */
public class FindAllFiles {
    public static void main(String[] args) {  
          
        //创建File对象  
        File file = new File("E:\\Schoolphotos\\14");  
        //获取该目录下的所有文件  
        String[] files = file.list();  
          
        for (String f : files){  
            System.out.println(f);  
        }  
          
        //listFiles是获取该目录下所有文件和目录的绝对路径  
        File[] fs = file.listFiles();  
        for (File f : fs){  
            System.out.println(f);  
        }  
    }  
}

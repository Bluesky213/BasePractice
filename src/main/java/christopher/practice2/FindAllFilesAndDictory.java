/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Bluesky
 */
public class FindAllFilesAndDictory {
 private static ArrayList<String> filelist = new ArrayList<String>();
 public static void main(String[] args) throws Exception {
    int i=0;
    String filePath = "E:\\Schoolphotos";
    getFiles1(filePath);
    for(String a:filelist)
    {
        System.out.println(a);
    }
    
 }
 /*
  * 通过递归得到某一路径下所有的目录及其文件
  */
 static void getFiles(String filePath){
  File root = new File(filePath);
    File[] files = root.listFiles();
    
    for(File file:files){     
     if(file.isDirectory()){
      /*
       * 递归调用
       */
      getFiles(file.getAbsolutePath());
      //filelist.add(file.getAbsolutePath());
      System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
     }else{
      System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
     }     
    }
 }
  static void getFiles1(String filePath){
  File root = new File(filePath);
    File[] files = root.listFiles();
    
    for(File file:files){     
     if(file.isDirectory()){//如果时目录则递归调用函数自身继续寻找该目录下的子文件夹
      /*
       * 递归调用
       */
      getFiles1(file.getAbsolutePath());
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
 }

}

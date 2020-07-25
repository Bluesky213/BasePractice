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
public class getAllRootFilePath {
    public static void main(String[] args) throws Exception {
    String filePath = "E:\\Schoolphotos";
    ArrayList<String> filelist=new ArrayList<String>();
    filelist=getFiles2(filePath,filelist);
    for(String a:filelist)
    {
        System.out.println(a);
    }
    
 }
   
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

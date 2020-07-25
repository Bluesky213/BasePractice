/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

/**
 *
 * @author Bluesky
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author Christopher
 *  1.首先查到全年级对应的所有院系所有班级
    2.根据 院系、班级、学号、进行检索下载
    字符串有 年级，学院，专业，班级，学号————
    3.下载的时候判断
    有没有对应的院系文件夹，如果有就写入，否则创建
    有没有对应的班级文件夹，如果有就写入，否则创建
    写入文件应该按照学号.JPG的方式命名
    院系 11 07
    班级 141 541 641 841 
    学号 1-30
    * 
    * 
 */
public class GetImage_changed {
    GetImage_changed getImage_changed=new GetImage_changed();
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
            
                for(int l=16;l<=16;l++)
                {
                for(int k=5;k<=5;k++)
                {
                for(int specialnumber=30;specialnumber<=30;specialnumber++)
                {
                for(int j=541;j<=542;j++)
                {
                    //if(Check_student_major_secondnumber(j)||Check_student_major_thirdnumber(j))
                    //continue;
                for(int i=1;i<=99;i++)
                {
                    String student_year=String.valueOf(Student_year_Auto(l));
                    String student_college=Student_college_Auto(k);
                    String student_number=Student_number_Auto(i);
                    String student_major=Student_major_Auto(j);
                    String url = "http://jwgl.hbeu.cn:8080/hbgcxy/uploadfile/studentphoto/pic/0"+student_year+String.valueOf(specialnumber)+student_college+student_major+student_number+".JPG";
                    
                    byte[] btImg = getImageFromNetByUrl(url);
                    if(null != btImg && btImg.length > 0)
                    {
                        getImagesAndWrite(student_year,specialnumber,student_college,student_major,student_number,btImg,"");//传入数据以供写入磁盘

                    }
                    else
                    {
                        //将后缀改成小写的.jpg再尝试一次
                        url = "http://jwgl.hbeu.cn:8080/hbgcxy/uploadfile/studentphoto/pic/0"+student_year+String.valueOf(specialnumber)+student_college+student_major+student_number+".jpg";
                        btImg = getImageFromNetByUrl(url);
                        if(null != btImg && btImg.length > 0)
                        {
                            getImagesAndWrite(student_year,specialnumber,student_college,student_major,student_number,btImg,".jpg");//传入数据以供写入磁盘
                        }
                        else
                        {
                            System.out.print("写入终止于"+"0"+student_year+String.valueOf(specialnumber));
                            System.out.println(student_college+student_major+"——"+Student_number_Auto((Integer.parseInt(student_number)-1)));
                            continue;
                            //break;
                            //System.out.println("没有从该连接获得内容");
                        }
                    }
                }
                }
                }
                }
                }
	}
	/**
	 * 将图片写入到磁盘
	 * @param img 图片数据流
	 * @param fileName 文件保存时的名称
	 */
        //依次传入学生的 年级、特殊号码、学院、专业、学号后两位和照片信息
        public static void getImagesAndWrite(String student_year,int specialnumber,String student_college,String student_major,String student_number,byte[] btImg,String jpg)
        {
            
            if(student_number.equals("01"))
            {
                System.out.println("正在下载的班级————————————————————"+"0"+student_year+String.valueOf(specialnumber)+student_college+student_major);
            }
            System.out.println("读取到：" + btImg.length + " 字节");
            
            String JPG=".JPG";
            if(!jpg.equals("")) JPG=jpg;//如果不传入.jpg说明是第一次获取图片后缀名不变为.JPG，否则就变为小写的.jpg
            
            String fileName = "Schoolphotos1\\"+student_year+"\\"+student_college+"\\"+"0"+student_year+String.valueOf(specialnumber)+student_college+student_major+"\\0"+student_year+String.valueOf(specialnumber)+student_college+String.valueOf(student_major)+student_number+JPG;
            String filePath = "Schoolphotos1\\"+student_year+"\\"+student_college+"\\"+"0"+student_year+String.valueOf(specialnumber)+student_college+student_major;
            File file=new File("E:\\"+filePath);
            if(file.exists())
            {
                writeImageToDisk(btImg, fileName);
            }
            else
            {
                try
                {
                    file.mkdirs();
                    writeImageToDisk(btImg, fileName);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        public static boolean Check_student_major_secondnumber(int j)
        {
            int m=j/10;
            int n=m%10;
            if(n!=4&&n!=5)
                return true;
            else
                return false;
        }
        public static boolean Check_student_major_thirdnumber(int j)
        {
            int m=j%100;
            int n=m%10;
            if(n>5)
                return true;
            else 
                return false;
        }
        public static int Student_year_Auto(int temp_student_year)
        {
            int student_year;
            student_year=temp_student_year;
            return student_year;
        }
//        public static int Student_major_Auto(int temp_student_college)
//        {
//            int student_college;
//            student_college=temp_student_college;
//            return student_college;
//        }
        public static String Student_major_Auto(int temp_student_major)
        {
            String changed_major="";
            if(temp_student_major<100)
            {
                if(temp_student_major>=10)
                {
                    changed_major="0"+String.valueOf(temp_student_major);
                }
                else
                    changed_major="00"+String.valueOf(temp_student_major);
            }
            else
                changed_major=String.valueOf(temp_student_major);
            return changed_major;
        }
        public static String Student_number_Auto(int temp_student_number)
        {
            String changed_sno="";
            changed_sno=temp_student_number<10?"0"+String.valueOf(temp_student_number):String.valueOf(temp_student_number);
            return changed_sno;
        }
        public static String Student_college_Auto(int temp_student_college)
        {
            String changed_college="";
            changed_college=temp_student_college<10?"0"+String.valueOf(temp_student_college):String.valueOf(temp_student_college);
            return changed_college;
        }
	public static void writeImageToDisk(byte[] img, String fileName){
		try {
			File file = new File("E:\\" + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("图片已经写入到C盘");
		} catch (Exception e) {
			e.printStackTrace();
                        
                }
	}
	/**
	 * 根据地址获得数据的字节流
	 * @param strUrl 网络连接地址
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
//                        if(btImg==null)
//                    {
//                        System.out.println("不存在");
//                    }
			return btImg;
		} catch (Exception e) {
                    System.out.println("————————————————————————————");
                    System.out.println("连接终止！");
			//e.printStackTrace();
		}
		return null;
	}
	/**
	 * 从输入流中获取数据
	 * @param inStream 输入流
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len=inStream.read(buffer)) != -1 ){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}

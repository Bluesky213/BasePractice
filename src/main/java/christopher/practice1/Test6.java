/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.UUID;

/**
 *
 * @author Christopher
 */
public class Test6 {
    public static void main(String args[]){
        test2();
    }
    
    public void test1(){
                String str = "#2,励磁变正向有功总电量,kwh,float64,\"SINE(1, -1000, 1000, 2, 0)\",no,\"1,000\",0,100,no,0,0,100,100";
        for(int i=0;i<320;i++){
//            if(i==1||i==9||i==57||i==61||i==65||i==69){continue;}
            String tempStr = "";
            if(i<10){
                tempStr = "00"+i;
            }else if (i>=10&&i<100){
                tempStr = "0"+i;
            }else {
                tempStr = String.valueOf(i);
            }
            System.out.println("GKDL_"+tempStr+str);
        }
    }
    
        public static void test2(){
            /**
             * kwhli
             * sumflow
             * weightflow
             */
            String type = "sumflow";
            String unit = "立方米";
            String typeCode = "15";
            String classCode = "1500";
        for(int i=201;i<301;i++){
//            if(i==1||i==9||i==57||i==61||i==65||i==69){continue;}
            String tempStr = "";
            if(i<10){
                tempStr = "00"+i;
            }else if (i>=10&&i<100){
                tempStr = "0"+i;
            }else {
                tempStr = String.valueOf(i);
            }
            if(i<101){
                type = "kwhli";
                unit = "千瓦时";
                typeCode = "33";
                classCode = "3300";
            }else if(i>100 && i<201){
                type = "weightflow";
                unit = "吨";
                typeCode = "02";
                classCode = "0201";
            }else if(i>200 && i<301){
                type = "sumflow";
                unit = "立方米";
                typeCode = "15";
                classCode = "1500";
            }
            String str1 = "insert into opc_meter_point(uids,sn,measure_index,point,client_point,unit,coefficient,remark) values('"+String.valueOf(UUID.randomUUID()).substring(0,10)+"','"+"2020"+tempStr+"','"+type+"',"+"'GKDL_"+tempStr+"','"+"NULL','"+unit+"','1','remark');";
            String str2 = "insert into impl_measure_device(uids,sn,pt,ct,energy_type_code,energy_class_code) values('"+String.valueOf(UUID.randomUUID()).substring(0,10)+"','"+"2020"+tempStr+"','1','1',"+"'"+typeCode+"','"+classCode+"');";
            System.out.println(str1+"\t"+str2);
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

/**
 *
 * @author Bluesky
 */
public class ContinueExample {
//    public static void main(String[] args){
//        int i=1;
//        int j=0;
//        for(i=1;i<=9;i++)
//        {
//            for(j=1;j<=9;j++)
//            {
//                if(j>i)
//                    break;
//                System.out.print(i+"*"+j+"="+i*j+" ");
//            }
//        System.out.println();
//        }    
//    }   
        public static void main(String[] args){
        int i=1;
        int j=0;
        for(i=1;i<=9;i++)
        {
            outer:
            for(j=1;j<=9;j++)
            {
                if(j<i)
                  continue;
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
        System.out.println();
        }
    }
}

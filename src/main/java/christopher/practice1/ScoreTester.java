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
enum  Score{
    EXCELLENT,
    QUALIFIED,
    FAILED;}

public class ScoreTester {
    public static void main(String[] args){
        giveScore(Score.EXCELLENT);
    }
    public static void giveScore(Score s){
       switch(s){
           case EXCELLENT:
               System.out.println("EXCELLENT");
               break;
               
           case QUALIFIED:
               System.out.println("Qualified");
               break;
           case FAILED:
               System.out.println("Failed");
               break;
       }
    }
}

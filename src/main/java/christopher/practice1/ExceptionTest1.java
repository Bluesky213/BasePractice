package christopher.practice1;
/*
    The differences of :
    1.try{...} catch{...} finally{...}
    2.
*/

public class ExceptionTest1{
    private int num;
    private String str;
    public static void main(String args[]){
        ExceptionTest1 exceptionTest1 = new ExceptionTest1();
        try{
            exceptionTest1.str = "Hello";
            exceptionTest1.num = Integer.parseInt(exceptionTest1.str);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            exceptionTest1.num = 0;
            System.out.println(exceptionTest1.num);
        }
    }
}
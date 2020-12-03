package christopher.practice1;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
* 位运算符：
 * &：与
 * ~：非
 * |：或
 * ^：异或
 *
 */
public class Operator_BitWise {
    public static void main(String[] args) {
        int a = 1010;// 10进制转2进制: 1111110010
        int b = 1101;// 10进制转2进制: 10001001101
        /**
         * &：将左右两个数均转换为二进制，位数相同则为1，不用为0
         */
        System.out.println(Integer.parseInt(1111110010+"",2)&Integer.parseInt("10001001101",2));
        System.out.println(a&b);
        /**
         * ~：二进制中的1变0，0变1
         */
        System.out.println(~a);// 00000001101：首位0代表负数，输出二进制得到0010
        System.out.println(~b);//011、1011、0010：首位0代表负数，输出二进制得到
        /**
         * |：将二进制中位数匹配，有一个为1则为1，否则为0
         */

        /**
         * ^：将二进制中位数匹配，两个都为1则为1，否则为0
         */
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author Christopher
 */
public class numberToChinese {
    public static void main(String args[]){
//        System.out.println(digital2Chinese(Long.valueOf("600000000")));
        System.out.println(getPrettyNumber("12000000"));
        System.out.println(getPrettyNumber("2000000"));
    }
        public static String getElecDpNumber(String num){
            int length = num.length();
            String prefix;
            String surfix;
            if(length<=4)
            {
                return num;
            }else if(length>4&&length<9)
            {
                prefix = getPrettyNumber(Long.valueOf(num)/10000.0+"");
                surfix = "万";
                return prefix+surfix;
            }else if(length>8&&length<13)
            {
                prefix = getPrettyNumber(Long.valueOf(num)/100000000.0+"");
                surfix = "亿";
                return prefix+surfix;
            }else 
            {
                prefix = getPrettyNumber(Long.valueOf(num)/1000000000000.0+"");
                surfix = "万亿";
                return prefix+surfix;
            }
        };
        
        public static String getPrettyNumber(String number) {
		return BigDecimal.valueOf(Double.parseDouble(number))
				.stripTrailingZeros().toPlainString();
	    }
        
        public String number2Chinese(int number) {
        String[] numbers = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] units = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十"};
        String sign = number < 0 ? "负" : "";
        if (number < 0) {
            number = -number;
        }
        StringBuilder result = new StringBuilder(sign);
        String string = String.valueOf(number);
        int n = string.length();
        char[] numberCharArray = string.toCharArray();
        for (int i = 0; i < n; i++) {
            int digNum = n - i; // 位数
            int num = numberCharArray[i] - '0';
            if (num != 0) {
                result.append(numbers[num]).append(units[digNum - 1]);
                continue;
            }

            if (result.toString().endsWith(numbers[0])) {
                // 如果是单位所在的位数，则去除上一个0，加上单位
                if (digNum % 4 == 1) {
                    result.deleteCharAt(result.length() - 1);
                    result.append(units[digNum - 1]);
                }
            }else{
                result.append(numbers[0]);
            }
        }
        return result.toString();
    }
        
//    private static String[] NUMBER_ZH = new String[]{"零","一","二","三","四","五","六","七","八","九","十"};
    //最大支持9千兆
//    private static String[] NUMBER_UNIT = new String[]{"","十","百","千","万","十","百","千","亿","十","百","千","兆","十","百","千"};

    public static String digital2Chinese(long number){
    String[] NUMBER_ZH = new String[]{"零","一","二","三","四","五","六","七","八","九","十"};
    String[] NUMBER_UNIT = new String[]{"","十","百","千","万","十","百","千","亿","十","百","千","兆","十","百","千"};
    Long value = number;
    Boolean isNegative = false;
    if (value < 0){
        value = -value;
        isNegative= true;
    }
    BigDecimal bigDecimal = BigDecimal.valueOf(value);

    String valueStr = value.toString();

    Integer [] digits = new Integer[valueStr.length()];

    for (int i=0;i<valueStr.length();i++){ //循环数存储每一位数字，从低到高
        digits[i] = bigDecimal.divideAndRemainder(BigDecimal.valueOf(10))[1].intValue();  //value.intValue()%10;
        bigDecimal = bigDecimal.divide(BigDecimal.valueOf(10));
    }
    StringBuilder sb = new StringBuilder();

    CollectionUtils.reverseArray(digits); // 从高到低

    Boolean flush = false;
    Boolean needFilling = true;

    if (digits.length > 16){
        throw new ArrayIndexOutOfBoundsException("数字太大了，超出汉字可读范围");
    }

    for (int i=0;i<digits.length;i++){
        if (digits[i].equals(0)){
            if (needFilling){
                if ( digits.length-i-1  == 4){
                    sb.append("万");
                    needFilling = false;
                }
                if ( digits.length-i-1 == 8){
                    sb.append("亿");
                    needFilling = false;
                }
                if ( digits.length-i-1 == 12){
                    sb.append("兆");
                    needFilling = false;
                }
            }

            flush = true;
            continue;
        }
        if (flush){
            sb.append("零");
            flush = false;
        }
        sb.append( NUMBER_ZH[ digits[i] ] ).append( NUMBER_UNIT[digits.length-i-1] );
        if (Arrays.asList(4,8,12).contains( digits.length-i-1 )){
            needFilling = false;
        }else{
            needFilling = true;
        }
    }

    if (isNegative){
        return "负"+sb.toString();
    }
    return sb.toString();
}
        
}
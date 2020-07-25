/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Vector;

/**
 *
 * @author Bluesky
 */
public class Collection_VectorExample2 {
    public static void main(String args[]){
       String num[]={"one","two","three","four","five"};
       //1.java.util.Arrays.asList(数组名)将数组转变为ArrayList才可以存入Vector
       Vector vector1=new Vector(java.util.Arrays.asList(num));
       //2.Vector.add(元素)用于向Vector对象的最后添加元素
       vector1.add("this");
       vector1.add("that");
       //3.Vecotr.get(int pos)用户获取Vector对象中对应key的元素
       System.out.println("vector1现在第6个元素是："+vector1.get(5));
       //4.boolean addAll(Collection col）将集合类对象col与调用这个方法的对象合并
       Vector vector2=new Vector();
       vector2.addAll(vector1);
       System.out.println(vector2.get(5));
       //int size()返回Vector对象中元素的个数
       System.out.println(vector2.size());
       //boolean isEmpty()判断Vector中是否含有对象
       System.out.println("vector2是否为空："+vector2.isEmpty());
       Vector vector3=new Vector();
       //void set(int pos,Object obj) set方法替换Vector中指定位置的对象
       vector2.set(3,"hundred");
       System.out.println(vector2.get(3));
       //boolean remove(Object obj) 删去Vector中第一次出现的这个对象，其余对象向前移动，若执行了则返回true
       vector2.add("two");  //添加个同名two元素检测是否只删除第一次的two的
       System.out.println(vector2.remove("two"));
       System.out.println("vector2现在第2个元素是："+vector2.get(1));//输出原来two的位置的元素检测是否删除成功并且剩余元素前移
       System.out.println("vector2现在第7个元素是："+vector2.get(6));
       //remove (int pos)去除指定位置的对象并返回被去除的对象
       System.out.println(vector2.remove(6));
       System.out.println("vector3是否为空："+vector3.isEmpty());
       int i=vector2.size();
       int k=vector2.capacity();
       System.out.println(".size得到的值是:"+i+".capacity的到的值是："+k);
       System.out.println("此时Vector中元素的个数是:"+vector2.size()+" 此时Vector的容积是："+vector2.capacity());
       //vector.toArray()方法可以将vector对象转换成数组对象
       Object num2[]=vector2.toArray();
       
       for(Object c:num2){
           System.out.print("Vector中的第");
           System.out.print(i--);
           System.out.println("个元素是："+c);
       }
       vector2.add("add1");
       vector2.add("add2");
       vector2.add("add3");
       vector2.add("add4");
       System.out.println("此时Vector中元素的个数是:"+vector2.size()+" 此时Vector的容积是："+vector2.capacity());
       vector2.add("add5");
       System.out.println("添加一个元素之后!");
       System.out.println("此时Vector中元素的个数是:"+vector2.size()+" 此时Vector的容积是："+vector2.capacity());
       //由此得出Vector的容积会自动增长。初始值为10，增长量为10
       
       //boolean removeAll()移除两个对象的交集
       Vector test1=new Vector();
       Vector test2=new Vector();
       test1.add("1");
       test1.add("2");
       test1.add("4");
       test2.add("1");
       test2.add("2");
       test2.add("3");
       test1.removeAll(test2);
       test1.size();
       System.out.println("removeAll去除交集后的元素:"+test1.get(0));
       //int indexOf返回指定对象的下标
       System.out.println("removeAll去除交集后这个元素的下标："+test1.indexOf("4"));
       
    }
}

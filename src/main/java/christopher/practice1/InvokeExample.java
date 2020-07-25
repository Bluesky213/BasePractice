package christopher.practice1;

import java.lang.reflect.Method;

public class InvokeExample {
	public static void main(String[] args) {
		Example a1 = new Example();
		Class a = a1.getClass();
		try {
			// System.out.println(a.getClass());
			// System.out.println(a1.getClass());
			Method m = a.getMethod("print", int.class,int.class);//有参数直接写
			Object o = m.invoke(a1, 10,20);			
			System.out.println("**************************");
			// Method m1 = a.getMethod("print", String.class,String.class);
			// Object o1 = m1.invoke(a1, "haha","hehe");						
			// System.out.println("**************************");
			// Method m2 = a.getMethod("print");//没有参数不用添加，直接获取
			// Object o3 = m2.invoke(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Example{
	public void print() {
		System.out.println("卧槽");
	}
	public void print(int a,int b) {
		System.out.println(a+b);
	}
	public void print(String a,String b) {
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}
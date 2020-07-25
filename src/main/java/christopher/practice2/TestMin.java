/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bluesky
 */
public class TestMin {
	
	public static void main(String[] args) {
                System.out.println("请输入一个任意的整数：");
		Scanner in = new Scanner(System.in);
		String testShuString = in.nextLine();
                System.out.println("请决定要从中除去几位数字：");
		int s = in.nextInt()-1;
		in.close();
		System.out.println(new TestMin().getResult2(testShuString, s));
	}
        
        //用栈来存储
	public String getResult2(String testString, int k) {
		char[] shuchars = testString.toCharArray();
		Mystack<Character> mystack = new Mystack<Character>();
		//遍历string，加入栈
		for (int i = 0; i < shuchars.length; i++) {
			while (mystack.size() > 0 && shuchars[i] < mystack.getTopItem()
					&& k > 0) {
				mystack.pop();
				k--;
			}
			mystack.push(shuchars[i]);
		}
		char[] result = new char[mystack.size()];
		for (int j = 0; j < result.length; j++) {
			result[j] = mystack.pop();
		}

		return Store(result, shuchars.length - k);
	}

        //翻转字符串,并取得指定的长度
	private String Store(char[] s, int k) {
		char[] StoreString = new char[k];
		for (int i = 0, j = s.length - 1; i < StoreString.length && j > 0; i++, j--) {
			StoreString[i] = s[j];
		}
		return new String(StoreString);
	}

	
	class Mystack<T> {
		List<T> mylist;

		public Mystack() {
			mylist = new ArrayList<T>();
		}
                
		void push(T item) {
			mylist.add(item);
		}

		T pop() {
			if (mylist.size() > 0) {
				return mylist.remove(mylist.size() - 1);
			} else {
				return null;
			}
		}
                
		int size() {
			return mylist.size();
		}

		T getTopItem() {
			if (mylist.size() > 0) {
				return mylist.get(mylist.size() - 1);
			}
			return null;
		}
	}
}

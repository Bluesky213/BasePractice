/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Hashtable;

/**
 *
 * @author Bluesky
 */
public class Collection_HashTableExample1 {
    public static void main(String args[]){
        Hashtable<String,String>aPhoneBook=new Hashtable<String,String>();
        //V put(K key,V value)——值value以key为其关键字加入到哈希表中，如果此关键字在表中不存在，则返回null;否则返回表中存储的Value
        aPhoneBook.put("key1", "value1");
        aPhoneBook.put("key2", "value2");
        aPhoneBook.put("key3", "value3");
        aPhoneBook.put("key4", "value4");
        System.out.print(aPhoneBook.put("key4","value7"));
        System.out.println(aPhoneBook);//输出null
        
        //V get(Object key)——返回关键字为key的值value，如果不存在，则返回null
        System.out.println(aPhoneBook.get("key1"));
        System.out.println(aPhoneBook.get("key2"));
        System.out.println(aPhoneBook.get("value1"));
        
        //V remove(Obejct key)——将键值对从表中去除，并返回从表中去除的值，如果不存在，则返回null
        System.out.println(aPhoneBook.remove("key1"));
        System.out.println(aPhoneBook.remove("value2"));
        System.out.println(aPhoneBook.remove("key1"));//输出null
        
        //boolean isEmpty()——判断哈希表是否为空
        //boolean containsKey(Obejct key)——判断给定的关键字是否在哈希表中
        //boolean contains/containsValue(Object value)——判断给定的值是否在哈希表中
        //void clear()——将哈希表清空
        //Enumeration<V>elements()——返回包含值的Enumeration对象
        //Enumeration<V>keys()——返回包含关键字的Enumeration对象
    }
}

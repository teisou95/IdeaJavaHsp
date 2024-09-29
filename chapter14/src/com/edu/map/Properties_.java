package com.edu.map;

import java.util.Properties;

/**
 * class Properties extends Hashtable<Object,Object>
 * key 和 value 也都不能为 null
 *
 */
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john",100);
//        properties.put(null,100);
//        properties.put("john",null);
        properties.put("lucy",100);
        properties.put("lic",100);
        properties.put("lic",88); // 替换
        System.out.println("properties = " + properties); // 无序

        // get 通过key 获取 value
        System.out.println("value = " + properties.get("lic"));

        // remove 删除
        properties.remove("lic");
        System.out.println("properties = " + properties);

        // put 修改(重新 put 一个相同的key)
        properties.put("john","约翰");
        System.out.println("properties = " + properties);

    }
}

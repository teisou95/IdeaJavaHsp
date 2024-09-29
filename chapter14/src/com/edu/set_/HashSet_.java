package com.edu.set_;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet 本质 是 HashMap
 */
@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
        Set hashSet = new HashSet(); // map = new HashMap<>(); 本质是 HashMap
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet.add(null)); // false
        System.out.println(hashSet);
    }
}

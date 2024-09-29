package com.edu.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 使用 JUnit 测试代码
 * JUnit 5.4 @Test
 */
public class Homework01 {
    public static void main(String[] args) {
    }

    @Test
    public void testSava() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 12, "jack"));
        userDAO.save("1002", new User(1002, 25, "king"));
        userDAO.save("1003", new User(1003, 18, "mary"));
        System.out.println(userDAO);
    }

    @Test
    public void testGet() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 12, "jack"));
        userDAO.save("1002", new User(1002, 25, "king"));
        userDAO.save("1003", new User(1003, 18, "mary"));
        User user1002 = userDAO.get("1002");
        System.out.println(user1002);
    }

    @Test
    public void testUpdate() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 12, "jack"));
        userDAO.save("1002", new User(1002, 25, "king"));
        userDAO.save("1003", new User(1003, 18, "mary"));
        userDAO.update("1001", new User(1001, 16, "杰克"));
        System.out.println(userDAO);
    }

    @Test
    public void testList() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 12, "jack"));
        userDAO.save("1002", new User(1002, 25, "king"));
        userDAO.save("1003", new User(1003, 18, "mary"));
        List<User> list = userDAO.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 12, "jack"));
        userDAO.save("1002", new User(1002, 25, "king"));
        userDAO.save("1003", new User(1003, 18, "mary"));
        userDAO.delete("1003");
        System.out.println(userDAO);
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list() {
        //        Set<Map.Entry<String, T>> entries = map.entrySet();
//        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, T> entry = iterator.next();
//            list.add(entry.getValue());
//        }

//        Collection<T> values = map.values();
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
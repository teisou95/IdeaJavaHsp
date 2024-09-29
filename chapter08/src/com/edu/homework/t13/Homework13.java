package com.edu.homework.t13;

/**
 * 0355
 */
public class Homework13 {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Student("wang", '男',15,"00123001");
        persons[1] = new Student("li", '女', 12, "00121005");
        persons[2] = new Teacher("king", '男', 35, 11);
        persons[3] = new Teacher("mary", '女', 40, 16);
        persons[0].sortArrAge(persons);

        for (int i = 0; i < persons.length; i++) {
            persons[i].printInfo();
            System.out.println("------------------");
        }

        Homework13 homework13 = new Homework13();
        for (int i = 0; i < persons.length; i++) {
            homework13.test(persons[i]);
        }

    }
    public void test(Person person) {
        if (person instanceof Student) {
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }
    }
}

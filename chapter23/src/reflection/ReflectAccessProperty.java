package reflection;

import java.lang.reflect.Field;

/**
 * 反射爆破 属性
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> studentClass = Class.forName("reflection.Student");
        Object student = studentClass.newInstance();
        System.out.println("student = " + student);

        Field age = studentClass.getField("age");
        age.set(student,15);
        System.out.println("age.get(student) = " + age.get(student));
        System.out.println("student = " + student);

        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student,"jack");
        System.out.println("name.get(student) = " + name.get(student));
        System.out.println("student = " + student);

        Field school = studentClass.getDeclaredField("school");
        school.setAccessible(true);
        school.set(null,"初中"); // static属性不属于对象
        System.out.println("school.get(student) = " + school.get(student));
        System.out.println("school.get(null) = " + school.get(null)); // static
        System.out.println("student = " + student);

        Object student2 = studentClass.newInstance();
        System.out.println("student2 = " + student2); // static属性被修改了


    }
}
class Student {
    public int age;
    private String name;
    private static String school = "小学";

    public Student() {
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}' + school;
    }
}

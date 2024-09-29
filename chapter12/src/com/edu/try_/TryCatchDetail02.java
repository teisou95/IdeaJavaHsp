package com.edu.try_;

/**
 * 多个不同 catch
 * 必须子类异常在前,父类异常在后
 */
public class TryCatchDetail02 {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName()); // NullPointException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2; // ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }
    }
}

class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}

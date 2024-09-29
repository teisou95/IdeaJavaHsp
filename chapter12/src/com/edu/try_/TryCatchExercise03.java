package com.edu.try_;

public class TryCatchExercise03 {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        int i = 1;
        try {
            i++; // i = 2
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "hahha";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; // i = 3 ,保存临时变量 temp = i,return temp
        } finally {
            ++i; // i = 4
            System.out.println("i = " + i); // i = 4
        }
    }
}

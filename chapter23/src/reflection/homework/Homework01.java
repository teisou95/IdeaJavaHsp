package reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) {
        Class<PrivateTest> privateTestClass = PrivateTest.class;

        try {
            Field name = privateTestClass.getDeclaredField("name");
            name.setAccessible(true);

            PrivateTest privateTest = privateTestClass.newInstance();
            name.set(privateTest, "jack");

            Method getName = privateTestClass.getMethod("getName");
            Object privateTestName = getName.invoke(privateTest);
            System.out.println("privateTestName = " + privateTestName);
        } catch (NoSuchFieldException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class PrivateTest {
    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}
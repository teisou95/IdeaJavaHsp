package reflection.homework;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }

        Class<String> stringClass = String.class;
        Constructor<String> constructor = stringClass.getConstructor(String.class);
        String filePath = constructor.newInstance("src\\myNew.txt");
        System.out.println("filePath = " + filePath);

        Constructor<?> constructor1 = fileClass.getConstructor(String.class);
        Object file = constructor1.newInstance(filePath);
        Method[] methods = fileClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
         
        Method createNewFile = fileClass.getMethod("createNewFile");
        int modifiers = createNewFile.getModifiers();
        System.out.println("modifiers = " + modifiers);
        Object invoke = createNewFile.invoke(file);
        System.out.println("invoke = " + invoke);

        Class<FileWriter> fileWriterClass = FileWriter.class;
        Constructor<FileWriter> constructor2 = fileWriterClass.getConstructor(File.class);
        FileWriter fileWriter = constructor2.newInstance(file);
        Method write = fileWriterClass.getMethod("write", String.class);
        write.invoke(fileWriter, "你好,world");
        Method close = fileWriterClass.getMethod("close");
        close.invoke(fileWriter);

    }
}

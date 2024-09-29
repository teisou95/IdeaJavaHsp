package reflection.question;

public class Cat {
    private String name = "大白";
    public int age = 10;
    public void hi() {
//        System.out.println("hello " + name);
    }
    public void cry() {
        System.out.println(name + " 喵喵叫");
    }

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }
}

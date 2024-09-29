package reflection;

public class Car {
    public String brand = "宝马";
    public int price = 50;
    public String color = "白色";

    public String  getBrand() {
        return brand;
    }
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}

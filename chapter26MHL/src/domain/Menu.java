package domain;

/**
 * 菜单 domain
 */
public class Menu {
    private Integer dishesId;
    private String dishesName;
    private String dishesType;
    private Double price;

    @Override
    public String toString() {
        return dishesId + "\t\t\t" + dishesName + "\t\t" + dishesType + "\t\t" + price;
    }

    public Integer getDishesId() {
        return dishesId;
    }

    public void setDishesId(Integer dishesId) {
        this.dishesId = dishesId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public String getDishesType() {
        return dishesType;
    }

    public void setDishesType(String dishesType) {
        this.dishesType = dishesType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Menu() {
    }

    public Menu(Integer dishesId, String dishesName, String dishesType, Double price) {
        this.dishesId = dishesId;
        this.dishesName = dishesName;
        this.dishesType = dishesType;
        this.price = price;
    }
}

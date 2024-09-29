package domain;

public class BillAndMenu {
    private Integer id;
    private Integer dishesId;
    private String dishesName;
    private Integer dishesNum;
    private Double money;
    private Integer tableId;
    private String state;

    @Override
    public String toString() {
        return "BillAndMenu{" +
                "id=" + id +
                ", dishesId=" + dishesId +
                ", dishesName='" + dishesName + '\'' +
                ", dishesNum=" + dishesNum +
                ", money=" + money +
                ", tableId=" + tableId +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDishesNum() {
        return dishesNum;
    }

    public void setDishesNum(Integer dishesNum) {
        this.dishesNum = dishesNum;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BillAndMenu() {
    }

    public BillAndMenu(Integer id, Integer dishesId, String dishesName, Integer dishesNum, Double money, Integer tableId, String state) {
        this.id = id;
        this.dishesId = dishesId;
        this.dishesName = dishesName;
        this.dishesNum = dishesNum;
        this.money = money;
        this.tableId = tableId;
        this.state = state;
    }
}

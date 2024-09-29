package domain;

import java.util.Date;

/**
 * 账单 domain
 */
public class Bill {
    private Integer id;
    private String  billId;
    private Integer tableId;
    private Integer dishesId;
    private Integer dishesNum;
    private Double money;
    private Date billDate;
    private String state;
    private String dishesName;

    @Override
    public String toString() {
        // id	账单号	菜品号	菜品名	数量	金额	时间
        return id + "\t" + billId + "\t" + dishesId + "\t" + dishesName + "\t" + dishesNum + "\t" + money + "\t\t" + billDate;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getDishesId() {
        return dishesId;
    }

    public void setDishesId(Integer dishesId) {
        this.dishesId = dishesId;
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

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Bill(Integer id, String billId, Integer tableId, Integer dishesId, Integer dishesNum, Double money, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.tableId = tableId;
        this.dishesId = dishesId;
        this.dishesNum = dishesNum;
        this.money = money;
        this.billDate = billDate;
        this.state = state;
    }

    public Bill() {
    }
}

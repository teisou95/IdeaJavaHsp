package domain;

/**
 * 餐桌 domain
 */
public class DiningTable {
    private Integer tableId;
    private String state;
    private String orderName;
    private String orderTel;

    @Override
    public String toString() {
        return tableId + "\t\t\t" + state;
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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.tableId = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }
}

package service;

import dao.BillAndMenuDAO;
import dao.BillDAO;
import domain.Bill;
import domain.BillAndMenu;
import domain.Menu;

import java.util.List;
import java.util.UUID;

public class BillService {
    private BillDAO billDAO = new BillDAO();
    private BillAndMenuDAO billAndMenuDAO = new BillAndMenuDAO();
    private MenuService menuService = new MenuService();

    /**
     * 多表查询全部账单
     * @return 全部账单 包含菜名
     */
    public List<BillAndMenu> listBillAndMenu() {
        List<BillAndMenu> billAndMenus = billAndMenuDAO.queryMulti
                ("select id,bill.dishesId,dishesName,dishesNum,money,tableId,state from bill join menu on bill.dishesId = menu.dishesId", BillAndMenu.class);
        return billAndMenus;
    }

    /**
     * 点菜
     *
     * @param tableId   餐桌编号
     * @param dishesId  菜品编号
     * @param dishesNum 菜品数量
     * @return 是否点菜成功
     */
    public boolean order(int tableId, int dishesId, int dishesNum) {
        Menu menu = menuService.getMenuByDishesId(dishesId);
        Double price = menu.getPrice();
        double money = price * dishesNum;

//        LocalDateTime date = LocalDateTime.now();

        // UUID生成账单号
        String billId = UUID.randomUUID().toString();

//        return billDAO.order(tableId, "insert into bill values (null,?,?,?,?,?,?,'未结账')", tableId, dishesId, money, billId, dishesNum, date);
        return billDAO.order(tableId, "insert into bill values (null,?,?,?,?,?,now(),'未结账')", tableId, dishesId, money, billId, dishesNum);
    }

    /**
     * 根据餐桌编号查询未结账账单
     *
     * @param tableId 餐桌编号
     * @return 账单集合
     */
    public List<Bill>  getBillByTableId(int tableId) {
        if (showMoney(tableId) == null) {
            return null;
        }
        double money = showMoney(tableId);
        System.out.print(String.format("%d 号餐桌当前总账单金额是 %.2f", tableId, money));
        return billDAO.queryMulti("select b.*,m.dishesName from bill b left join menu m on b.dishesId=m.dishesId where tableId = ? and state = '未结账'", Bill.class,tableId);
    }

    /**
     * 结账,更新餐桌状态
     *
     * @param tableId 桌号
     * @param state   结账方式
     * @return 是否结账成功
     */
    public boolean checkout(int tableId, String state) {
        return billDAO.checkout(tableId, "update bill set state = ? where tableId = ? and state = '未结账'", state, tableId);
    }

    /**
     * 根据桌号返回账单总金额
     *
     * @param tableId 桌号
     * @return 账单总金额
     */
    public Double showMoney(int tableId) {
        return (Double) billDAO.queryScalar("select sum(money) from bill where tableId = ? and state = '未结账'", tableId);
    }
}

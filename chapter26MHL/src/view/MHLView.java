package view;

import domain.*;
import service.BillService;
import service.DiningTableService;
import service.EmployeeService;
import service.MenuService;
import utils.Utility;

import java.util.List;

/**
 * 满汉楼项目 主程序
 */
public class MHLView {
    private boolean loop = true;
    private int key;
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        MHLView mhlView = new MHLView();
        mhlView.mainMenu();
    }

    /**
     * 多表查询 全部账单
     */
    public void showAllBill() {
        List<BillAndMenu> billAndMenus = billService.listBillAndMenu();
        for (BillAndMenu billAndMenu : billAndMenus) {
            System.out.println(billAndMenu);
        }
    }

    /**
     * 结账
     */
    public void checkout() {
        System.out.print("选择桌号(-1退出):");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("退出结账");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableByTableId(tableId);
        if (diningTable == null) {
            System.out.println("没有此编号的餐桌");
            return;
        }
        if (!("用餐中".equals(diningTable.getState())) || billService.showMoney(tableId) == null){
            System.out.println("当前餐桌暂无账单");
            return;
        }
        double moneySum = billService.showMoney(tableId);
        System.out.println(String.format("%d 号餐桌当前总账单金额是 %.2f", tableId, moneySum));
        System.out.print("选择结账方式:");
        String state = Utility.readString(20);
        if (!("支付宝".equals(state) || "微信".equals(state) || "刷卡".equals(state) || "现金".equals(state))){
            System.out.println("暂不支持此方式结账");
            return;
        }
        if(!(billService.checkout(tableId,state))) {
            System.out.println("============结账失败============");
            return;
        }
        System.out.println("============结账成功============");
    }

    /**
     * 按桌号查看账单
     */
    public void showBills() {
        System.out.print("选择桌号(-1退出):");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("退出查看账单");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableByTableId(tableId);
        if (diningTable == null) {
            System.out.println("没有此编号的餐桌");
            return;
        }
        List<Bill> bills = billService.getBillByTableId(tableId);
        if ("空".equals(diningTable.getState()) || "已被预订".equals(diningTable.getState()) || bills == null){
            System.out.println("当前餐桌暂无账单");
            return;
        }
        System.out.println(",账单明细如下:");
        System.out.println("id\t账单编号\t菜品号\t菜品名\t数量\t金额\t时间");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println("显示完毕");
    }

    /**
     * 点餐服务
     */
    public void orderDishes() {
        System.out.println("============点餐服务============");
        System.out.print("选择点餐的桌号(-1退出):");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("退出点餐服务");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableByTableId(tableId);
        if (diningTable == null) {
            System.out.println("没有此编号的餐桌");
            return;
        }
        if ("空".equals(diningTable.getState())) {
            System.out.println("此餐桌尚未预定");
            return;
        }
        System.out.print("选择菜品编号(-1退出):");
        int dishesId = Utility.readInt();
        if (dishesId == -1) {
            System.out.println("退出点餐服务");
            return;
        }
        Menu menu = menuService.getMenuByDishesId(dishesId);
        if (menu == null) {
            System.out.println("没有此编号的菜品");
            return;
        }
        System.out.print("选择菜品数量(<1 退出):");
        int dishesNum = Utility.readInt();
        if (dishesNum < 1) {
            System.out.println("退出点餐服务");
            return;
        }
        System.out.print("确认是否点菜(Y/N):");
        char key = Utility.readConfirmSelection();
        if (key == 'N') {
            System.out.println("退出点餐服务");
            return;
        }
        if (!(billService.order(tableId, dishesId, dishesNum))) {
            System.out.println("============点菜失败============");
            return;
        }
        System.out.println("============点菜成功============");
    }
    /**
     * 显示所有菜品
     */
    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名称\t\t菜品种类\t\t菜品价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("显示完毕");
    }

    /**
     * 显示餐桌状态
     */
    public void listDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("============显示完毕============");
    }

    /**
     * 预定餐桌
     */
    public void orderDiningTable() {
        System.out.println("============预定餐桌============");
        System.out.print("请输入要预定的餐桌编号(-1退出):");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("退出餐桌预定");
            return;
        }
        // 验证是否可预订
        DiningTable diningTable = diningTableService.getDiningTableByTableId(tableId);
        if (diningTable == null) {
            System.out.println("没有此编号的餐桌");
            return;
        }
        if (!("空".equals(diningTable.getState()))) {
            System.out.println("该餐桌无法预定");
            return;
        }
        System.out.print("确定是否预定(Y/N):");
        char key = Utility.readConfirmSelection();
        if (key == 'N') {
            System.out.println("退出餐桌预定");
            return;
        }
        System.out.print("预定人名字:");
        String orderName = Utility.readString(50);
        System.out.print("预定人电话:");
        String orderTel = Utility.readString(20);
        // 预定餐桌
        if (!(diningTableService.order(tableId, orderName, orderTel))) {
            System.out.println("============预定失败============");
            return;
        }
        System.out.println("============预定成功,信息如下============");
        DiningTable info = diningTableService.getDiningTableByTableId(tableId);
        System.out.println("姓名:" + info.getOrderName() + " ,电话:" + info.getOrderTel() + " ,预定了 " + info.getTableId() + " 号餐桌");
    }

    /**
     * 主菜单
     */
    public void mainMenu() {
        while (loop) {
            System.out.println("============满汉楼============");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.print("请输入你的选择:");
            key = Utility.readInt();
            switch (key) {
                case 1:
                    System.out.print("请输入员工号:");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密码:");
                    String pwd = Utility.readString(50);
                    // 验证信息
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee == null) {
                        System.out.println("============登陆失败============");
                        break;
                    }
                    System.out.println("============登陆成功[" + employee.getName() + "]============");
                    // 显示二级菜单
                    while (loop) {
                        System.out.println("============满汉楼二级菜单[" + employee.getName() + "]============");
                        System.out.println("\t\t1 显示餐桌状态");
                        System.out.println("\t\t2 预定餐桌");
                        System.out.println("\t\t3 显示所有菜品");
                        System.out.println("\t\t4 点餐服务");
                        System.out.println("\t\t5 按桌号查看当前账单");
                        System.out.println("\t\t6 结账");
                        System.out.println("\t\t7 查看所有账单");
                        System.out.println("\t\t9 退出满汉楼");
                        System.out.print("请输入你的选择:");
                        key = Utility.readInt();
                        switch (key) {
                            case 1:
                                listDiningTable();
                                break;
                            case 2:
                                orderDiningTable();
                                break;
                            case 3:
                                listMenu();
                                break;
                            case 4:
                                orderDishes();
                                break;
                            case 5:
                                showBills();
                                break;
                            case 6:
                                checkout();
                                break;
                            case 7:
                                showAllBill();
                                break;
                            case 9:
                                loop = false;
                                break;
                            default:
                                System.out.println("输入错误");
                                break;
                        }
                    }
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        System.out.println("退出了满汉楼系统");
    }
}

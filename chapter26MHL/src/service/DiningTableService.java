package service;

import dao.DiningTableDAO;
import domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

//    /**
//     * 修改餐桌状态
//     * @param tableId 桌号
//     * @param state 新状态
//     * @return 是否修改成功
//     */
//    public boolean updateState(int tableId,String state) {
//        int update = diningTableDAO.update("update diningTable set state = ? where tableId = ?", state, tableId);
//        return update > 0;
//    }

    /**
     * 返回全部餐桌的状态信息
     *
     * @return diningTable 的 list 集合,包含 tableId 和 state
     */
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select tableId,state from diningTable", DiningTable.class);
    }

    /**
     * 根据 餐桌编号 查询 餐桌信息
     *
     * @param tableId
     * @return 餐桌信息
     */
    public DiningTable getDiningTableByTableId(int tableId) {
        return diningTableDAO.querySingle
                ("select * from diningTable where tableId = ?", DiningTable.class, tableId);
    }

    /**
     * 预定餐桌,更新餐桌状态
     *
     * @param tableId   餐桌编号
     * @param orderName 预定人姓名
     * @param orderTel  预定人电话
     * @return 预定更新是否成功
     */
    public boolean order(int tableId, String orderName, String orderTel) {
        DiningTable diningTable = getDiningTableByTableId(tableId);
        if (!"空".equals(diningTable.getState())) {
            System.out.println("该餐桌无法预定");
            return false;
        }
        int update = diningTableDAO.update("update diningTable set state = '已被预订',orderName = ?,orderTel = ? where tableId = ?", orderName, orderTel, tableId);
        return (update > 0);
    }

}

package service;

import dao.MenuDAO;
import domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();



    /**
     * 根据菜品编号返回菜品信息
     *
     * @param dishesId 菜品编号
     * @return 菜品对象
     */
    public Menu getMenuByDishesId(int dishesId) {
        return menuDAO.querySingle("select * from menu where dishesId = ?", Menu.class, dishesId);
    }

    /**
     * 返回菜单
     *
     * @return 菜单列表全部信息
     */
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
}

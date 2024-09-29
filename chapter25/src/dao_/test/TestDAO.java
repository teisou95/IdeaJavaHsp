package dao_.test;

import dao_.dao.ActorDAO;
import dao_.dao.GoodsDAO;
import dao_.domain.Actor;
import dao_.domain.Goods;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TestDAO {

    // 测试ActorDAO
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        System.out.println("===========多行查询==============");
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 2);
        Iterator<Actor> iterator = actors.iterator();
        while (iterator.hasNext()) {
            Actor actor = iterator.next();
            System.out.println(actor);
        }

        System.out.println("============单行查询=============");
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 5);
        System.out.println(actor);

        System.out.println("===========单行单列查询==============");
        Object obj = actorDAO.queryScalar("select name from actor where id = ?", 5);
        System.out.println(obj);

        System.out.println("============dml操作=============");
        actorDAO.update("update actor set name = ? where id = ?","天天向上",4);
        actorDAO.update("delete from actor where id = ?",4);
        actorDAO.update("insert into actor values(null,?,?,?)","moto","女","1992-6-17");
    }

    // 测试GoodsDAO
    @Test
    public void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();

        System.out.println("============dml操作===========  ==");
        goodsDAO.update("create table goods(id int, goods_name varchar(10), price double)");
        goodsDAO.update("insert into goods values(?,?,?)",10,"华为手机",2000);
        goodsDAO.update("insert into goods values(?,?,?)",20,"苹果手机",8000);
        goodsDAO.update("insert into goods values(?,?,?)",30,"小米手机",3000);
        goodsDAO.update("insert into goods values(?,?,?)",40,"格力手机",1500);

        System.out.println("===========多行查询==============");
        List<Goods> goods = goodsDAO.queryMulti("select * from goods where price >= ?", Goods.class, 1999);
        Iterator<Goods> iterator = goods.iterator();
        while (iterator.hasNext()) {
            Goods goods1 = iterator.next();
            System.out.println(goods1);
        }

        System.out.println("============单行查询=============");
        Goods goods1 = goodsDAO.querySingle("select * from goods where id = ?", Goods.class, 20);
        System.out.println(goods1);

        System.out.println("===========单行单列查询==============");
        Object obj = goodsDAO.queryScalar("select price from goods where id = ?", 40);
        System.out.println(obj);
    }
}

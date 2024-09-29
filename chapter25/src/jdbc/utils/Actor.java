package jdbc.utils;

import java.sql.Date;

public class Actor { // javaBean PoJo Domain 对象
    private Integer id;
    private String name;
    private java.util.Date born;
    private String sex;

    public Actor() { // 底层反射需要无参构造器
    }

    public Actor(Integer id, String name, Date born, String sex) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.sex = sex;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(java.util.Date born) {
        this.born = born;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public java.util.Date getBorn() {
        return born;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", born=" + born +
                ", sex='" + sex + '\'' +
                '}';
    }
}

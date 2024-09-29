package qqcommon;

import java.io.Serializable;

/**
 * 用户(客户信息)
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L; //
    private String uid; // 用户名/id
    private String passwd; // 用户密码

    public User(String userId, String passwd) {
        this.uid = userId;
        this.passwd = passwd;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

package qqclient.view;

import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;
import qqclient.utils.Utility;

import java.io.IOException;

/**
 * 客户端菜单界面
 */
public class QQView {
    private boolean loop = true; // 控制是否显示菜单
    private String key = ""; // 接收用户键盘输入
    private UserClientService userClientService = new UserClientService(); // 用于登陆服务器,注册用户
    private MessageClientService messageClientService = new MessageClientService(); // 用于发送处理消息

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        QQView qqView = new QQView();
        qqView.mainMenu();
        System.out.println("客户端退出系统");
    }
    // 显示主菜单
    private void mainMenu() throws IOException, ClassNotFoundException {
        while (loop) { // 进入一级菜单
            System.out.println("===========欢迎登陆网络通讯系统===========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择:");

            key = Utility.readString(1); // 限制读取长度1 的字符串 // 1或9
            switch (key){
                case "1": // 登录系统
                    System.out.print("请输入用户名:");
                    String uid = Utility.readString(50);
                    System.out.print("请输入密  码:");
                    String passwd = Utility.readString(6);
                    // 到服务端验证该用户是否合法,使用 UserClientService 类
                    if (userClientService.checkUser(uid,passwd)) { // 如果登录验证成功
                        System.out.println("===========欢迎 " + uid + " 登陆成功===========");
                        while (loop) { // 进入二级菜单
                            System.out.println("\n===========网络通讯系统二级菜单(用户 " + uid + " )===========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择:");

                            key = Utility.readString(1);
                            switch (key) {
                                case "1": // 显示在线用户列表
                                    userClientService.onlineFriendList();
                                    break;
                                case "2": // 群发消息
                                    messageClientService.radioChat(uid);
                                    break;
                                case "3": // 私聊消息,还要设置循环
                                    messageClientService.privateChat(uid);
                                    break;
                                case "4": // 发送文件
                                    messageClientService.fileChat(uid);
                                    break;
                                case "9": // 退出系统
                                    userClientService.logout();
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入错误,请重新输入:");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登陆验证失败");
                    }
                    break;
                case "9": // 退出系统
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入:");
                    break;
            }
        }
    }
}

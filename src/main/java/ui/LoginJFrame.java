package ui;

import javax.swing.*;
//游戏登录界面
public class LoginJFrame extends JFrame {



    public LoginJFrame(){
        initMenu();

        this.setVisible(true);
    }

    private void initMenu() {
        this.setTitle("登录界面");
        this.setSize(488,530);
        //设置页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(2);

    }
}

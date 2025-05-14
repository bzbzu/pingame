package ui;

import javax.swing.*;
//游戏注册界面
public class RegisterJFrame extends JFrame {

    public RegisterJFrame(){
        initJFrame();

        this.setVisible(true);
    }

    private void initJFrame() {
        this.setTitle("注册界面");
        this.setSize(488,530);
        //设置游戏居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭模式
        this.setDefaultCloseOperation(2);

    }
}

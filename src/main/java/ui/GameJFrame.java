package ui;

import javax.swing.*;
//游戏的主界面
public class GameJFrame extends JFrame {




    public GameJFrame(){
        initJFrame();
        initMenu();

        this.setVisible(true);
    }
    private void initJFrame(){
        this.setTitle("拼图游戏单机版");
        this.setSize(603,680);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置游戏关闭模式
        this.setDefaultCloseOperation(2);

    }
    private void initMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu functionMenu = new JMenu("function");
        JMenu helpMenu = new JMenu("help");
        JMenuItem reLoginMenu = new JMenuItem("relogin");
        JMenuItem closeMenu = new JMenuItem("close");
        JMenuItem changeImage = new JMenuItem("change image");
        JMenuItem rePlay = new JMenuItem("rePlay");
        functionMenu.add(changeImage);
        functionMenu.add(reLoginMenu);
        functionMenu.add(rePlay);
        functionMenu.add(closeMenu);
        menu.add(functionMenu);
        menu.add(helpMenu);
        this.setJMenuBar(menu);
    }
}

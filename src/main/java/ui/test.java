package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {
    public static void main(String[] args){
        //创建游戏主界面
        JFrame gameJFrame = new JFrame();
        gameJFrame.setSize(603,680);
        gameJFrame.setVisible(true);
        gameJFrame.setDefaultCloseOperation(2);
        JButton jb  = new JButton("1sadfjj");
        jb.setBounds(0,0,78,45);
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击");
            }
        });
        gameJFrame.getContentPane().add(jb);
        gameJFrame.setLayout(null);
    }
}

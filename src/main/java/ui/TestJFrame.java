package ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestJFrame extends JFrame implements ActionListener, MouseListener, KeyListener {

    JButton jb1 = new JButton("点我啊");
    JButton jb2 = new JButton("别点我");
    JButton jb3 = new JButton("鼠标动作");
    public TestJFrame(){
        this.setTitle("测试");
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(600,600);
        jb1.setBounds(0,0,100,40);
        jb1.addActionListener(this);
        jb2.setBounds(100,0,100,40);
        jb2.addActionListener(this);
        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);
        jb3.setBounds(200,0,100,40);
        jb3.addMouseListener(this);
        this.getContentPane().add(jb3);
        this.addKeyListener(this);
        // 允许框架获得焦点
        this.setFocusable(true);
        // 请求焦点
        this.requestFocusInWindow();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jb1) {
            Random r = new Random();
            jb1.setLocation(r.nextInt(500),r.nextInt(500));
        }else if(source == jb2){
            Random r = new Random();
            jb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        System.out.println(e.getKeyChar());
    }
}

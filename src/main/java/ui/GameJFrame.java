package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Random;

//游戏的主界面
public class GameJFrame extends JFrame {


    int [][] data = new int[4][4];//图片顺序

    public GameJFrame(){
        initJFrame();
        initMenu();
        initData();
        initImage();
        this.setVisible(true);
    }
    private void initJFrame(){
        this.setTitle("拼图游戏单机版");
        this.setSize(660,800);
        this.setLocationRelativeTo(null);//设置页面居中
        this.setDefaultCloseOperation(2);//设置游戏关闭模式
        this.setLayout(null);//取消默认居中布局
    }
    private void initMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu functionMenu = new JMenu("function");
        JMenu helpMenu = new JMenu("help");
        JMenuItem reLoginMenu = new JMenuItem("relogin");
        JMenuItem closeMenu = new JMenuItem("close");
        JMenuItem changeImage = new JMenuItem("change image");
        JMenuItem rePlay = new JMenuItem("replay");
        JMenuItem about  = new JMenuItem("about");
        functionMenu.add(changeImage);
        functionMenu.add(reLoginMenu);
        functionMenu.add(rePlay);
        functionMenu.add(closeMenu);
        helpMenu.add(about);
        menu.add(functionMenu);
        menu.add(helpMenu);
        this.setJMenuBar(menu);
    }
    private void initImage() {
        int x=30,y=30;
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                JLabel jl = new JLabel(new ImageIcon("./image/animal/animal1/"+data[i][j]+".jpg"));
                jl.setBounds(83+j*105+x,134+i*105+y,105,105);
                jl.setBorder(new BevelBorder(0));
                this.getContentPane().add(jl);
            }
        }
        JLabel backGround = new JLabel(new ImageIcon("./image/background.png"));
        backGround.setBounds(39+x,39+y,508,560);
        this.getContentPane().add(backGround);
    }
    private void initData()
    {
        int[] temp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for(int i=0;i<16;++i)
        {
            int index = r.nextInt(16);
            int a=temp[index];
            temp[index] = temp[i];
            temp[i] = a;
        }
        for(int i=0;i<4;++i) {
            for(int j=0;j<4;++j){
                data[i][j] = temp[i*4+j];
            }
        }
    }
}
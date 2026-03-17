package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏的主界面
public class GameJFrame extends JFrame implements KeyListener {


    int [][] data = new int[4][4];//图片顺序
    int x0,y0;
    int count=0;
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
        this.addKeyListener(this);
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
        this.getContentPane().removeAll();
        int x=30,y=30;
        JLabel stepcount =new JLabel("步数"+count);
        stepcount.setBounds(50,30,100,20);
        this.getContentPane().add(stepcount);
        if(vectory()){
            JLabel vec = new JLabel(new ImageIcon("./image/win.png"));
            vec.setBounds(203+x,203+y,197,73);
            this.getContentPane().add(vec);
            System.out.println("胜利");
        }
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
        this.getContentPane().repaint();

    }
    private boolean vectory(){
        boolean f= true;
        for(int i=0;i<4;++i){
            for(int j=0;j<3;++j){
                if(data[i][j]!=i*4+j+1){
                    f=false;
                }
            }
        }
        return f;
    }
    private void initData() {
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
                if(data[i][j]==0)
                {
                    x0=i;
                    y0=j;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code= e.getKeyCode();
        if(code==65){
            int x=30,y=30;
            this.getContentPane().removeAll();
            JLabel stepcount =new JLabel("步数"+count);
            stepcount.setBounds(50,30,100,20);
            this.getContentPane().add(stepcount);
            JLabel all = new JLabel(new ImageIcon("./image/animal/animal1/all.jpg"));
            all.setBounds(83+x,134+y,420,420);
            this.getContentPane().add(all);
            JLabel backGround = new JLabel(new ImageIcon("./image/background.png"));
            backGround.setBounds(39+x,39+y,508,560);
            this.getContentPane().add(backGround);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            initImage();
        }
        if(vectory()){
            return;
        }
        if(code == 37){
            if(y0+1<=3) {
                System.out.println("左移");
                data[x0][y0]=data[x0][y0+1];
                data[x0][y0+1]=0;
                y0+=1;
                count++;
                initImage();
            }
        }else if(code == 38){
            if(x0+1<=3) {
                System.out.println("上移");
                data[x0][y0] = data[x0 + 1][y0];
                data[x0 + 1][y0] = 0;
                x0 += 1;
                count++;
                initImage();
            }
        }else if(code == 39){
            if(y0-1>=0) {
                System.out.println("右移");
                data[x0][y0]=data[x0][y0-1];
                data[x0][y0-1]=0;
                y0-=1;
                count++;
                initImage();
            }
        } else if (code == 40) {
            if(x0-1>=0) {
                System.out.println("下移");
                data[x0][y0] = data[x0 - 1][y0];
                data[x0 - 1][y0] = 0;
                x0 -= 1;
                count++;
                initImage();
            }
        }else if(code==87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x0=3;
            y0=3;
            initImage();
        }
    }
}
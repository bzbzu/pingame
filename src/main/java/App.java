import ui.GameJFrame;
import ui.LoginJFrame;
import ui.RegisterJFrame;

import java.util.GregorianCalendar;

//游戏启动入口
public class App {
    public static void main(String[] args){
        new LoginJFrame();
        new GameJFrame();
        new RegisterJFrame();
    }
}

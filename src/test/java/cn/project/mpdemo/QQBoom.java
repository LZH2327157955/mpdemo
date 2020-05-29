package cn.project.mpdemo;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
/**
 * QQ轰炸机
 */
public class QQBoom {
    //定义桌面类
    static Desktop deskapp = Desktop.getDesktop();

    public static void main(String [] args) throws AWTException{
        inputQQ();
    }
    //打开QQ
    public static void openQQ(){
        //判断当前系统释放支持Desktop提供的接口
        if(Desktop.isDesktopSupported()){
            try {
                //QQ的路径
                deskapp.open(new File("\"F:\\application program\\Tencent\\QQ\\Bin\\QQScLauncher.exe\""));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //账号密码输入
    public static void InputAP() throws AWTException{
        //定义自动化类
        Robot robot = new Robot();
        //3等待3秒后开始执行下面的自动键盘事件
        robot.delay(3000);
        //点击鼠标左键(目的是让光标放到QQ上)
        QQBoom.mouseLeftHit(robot); //获得焦点
        QQBoom.keyPressNumber(robot,324); //账号
        QQBoom.keyPress(robot, KeyEvent.VK_TAB); //TAB换行
        QQBoom.keyPressNumber(robot, 1111);  //密码
        QQBoom.keyPress(robot, KeyEvent.VK_ENTER); //回车
    }
    //QQ消息输入
    public static void inputQQ() throws AWTException{
        //定义自动化类
        Robot robot = new Robot();
        //3等待3秒后开始执行下面的自动键盘事件
        robot.delay(3000);
        //点击鼠标左键(目的是让光标放到QQ上)
        QQBoom.mouseLeftHit(robot);
        for(int i = 0 ; i < 10; i++){
            //输入内容
            QQBoom.keyPressString(robot, "我是小杨研发的自动聊天机器人第"+i+"次发送");
            //按下回车
            QQBoom.keyPress(robot, KeyEvent.VK_ENTER);
        }
    }
    //Ctrl组合键
    public static void keyPressWithCtrl(Robot r,int key){
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(key);

        r.keyRelease(key);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.delay(100);
    }
    //输入字符串
    public static void keyPressString(Robot r ,String str){
        //获取剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        //将传入字符串封装下
        Transferable tText = new StringSelection(str);
        //将字符串放入剪切板
        clip.setContents(tText, null);
        //按下Ctrl+V实现粘贴文本
        keyPressWithCtrl(r, KeyEvent.VK_V);
        r.delay(100);
    }
    //输入数字
    public static void keyPressNumber(Robot r ,int number){
        //将数字转成字符串
        String str = Integer.toString(number);
        //调用字符串的方法
        keyPressString(r,str);
    }
    //实现按一次某个按键
    public static void keyPress(Robot r,int key){
        //按下键
        r.keyPress(key);
        //释放键
        r.keyRelease(key);

        r.delay(1000);
    }
    //点击一下鼠标左键
    public static void mouseLeftHit(Robot r){
        r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        r.delay(1000);
    }
}


package Phase1.Server;

import java.awt.*;


public class Main{
    public static ServerForm    serverForm    = new ServerForm();
    public static SocketHandler socketHandler = new SocketHandler();
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    serverForm.getFrame().setVisible(true);
                    serverForm.display("Waiting for client.....\n");
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

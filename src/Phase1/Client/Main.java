package Phase1.Client;

import java.awt.*;


public class Main{
    public static  ClientForm clientForm;
    public static SocketHandler socketHandler;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    clientForm = new ClientForm();
                    clientForm.getFrame().setVisible(true);
                    socketHandler = new SocketHandler();
                    socketHandler.establishConnection();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

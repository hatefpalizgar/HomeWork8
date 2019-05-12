package Phase1.Client;

import java.awt.*;
import java.net.Socket;


public class Main{
    public static  ClientForm clientForm;
    private static Socket     server;
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    clientForm = new ClientForm();
                    clientForm.getFrame().setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

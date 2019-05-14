package Phase1.Client;

import java.awt.*;


public class Main {
    public static ClientForm    clientForm = new ClientForm();
    public static SocketHandler socketHandler = new SocketHandler();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    clientForm = new ClientForm();
                    clientForm.getFrame().setVisible(true);
                    clientForm.display("Connecting to server.....\n");
                    socketHandler.establishConnection();
    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }
}

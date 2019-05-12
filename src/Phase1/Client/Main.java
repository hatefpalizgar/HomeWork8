package Phase1.Client;

import java.awt.*;


public class Main{
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientForm clientForm = new ClientForm();
                    clientForm.clientForm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

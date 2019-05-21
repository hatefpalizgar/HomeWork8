package Phase1.Client;

import java.awt.*;

public class ClientRunner {
    private static ClientForm          clientForm;
    private static ClientSocketHandler clientSocketHandler = new ClientSocketHandler();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    clientForm = new ClientForm(clientSocketHandler);
                    clientForm.getFrame().setVisible(true);
                    clientForm.display("Connecting to server.....\n");
                    clientSocketHandler.establishConnection();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
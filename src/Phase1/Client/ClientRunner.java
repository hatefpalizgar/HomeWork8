package Phase1.Client;

import java.awt.*;

public class ClientRunner
    {
    private static ClientForm          clientForm;
    private static ClientSocketHandler clientSocketHandler = new ClientSocketHandler();
    
    public static void main(String[] args)
        {
            EventQueue.invokeLater(() ->
                                   {
                                       clientForm = new ClientForm();
                                       clientForm.getFrame().setVisible(true);
                                       clientForm.display("Connecting to server.....\n");
                                       clientSocketHandler.establishConnection();
                                   });
        }
    
    
    public static ClientForm getClientForm()
        {
            return clientForm;
        }
    
    public static ClientSocketHandler getClientSocketHandler()
        {
            return clientSocketHandler;
        }
    }
package Phase1.Server;

import java.awt.*;
import java.io.IOException;

public class ServerRunner
    {
    public static ServerForm         serverForm         = new ServerForm();
    public static ServerSocketDriver serverSocketDriver = new ServerSocketDriver();
    
    public static void main(String[] args) throws IOException
        {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            EventQueue.invokeLater(() ->
                                   {
                                       System.out.println("Current Thread: " + Thread.currentThread().getName());
                                       serverForm.getFrame().setVisible(true);
                                       serverForm.display("Waiting for client.....");
                                   });
            serverSocketDriver.startServer();
        }
    }

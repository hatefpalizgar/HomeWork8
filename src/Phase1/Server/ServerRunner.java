package Phase1.Server;

import java.awt.*;


public class ServerRunner {
    public static ServerForm         serverForm         = new ServerForm();
    public static ServerSocketDriver serverSocketDriver = new ServerSocketDriver();
    
    public static void main(String[] args) {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    System.out.println("Current Thread: " + Thread.currentThread().getName());
                    serverForm.getFrame().setVisible(true);
                    serverForm.display("Waiting for client.....\n");
                }
                catch (Exception e) {
                    System.out.println("Problem starting server");;
                }
            }
        });
        serverSocketDriver.startServer();
    }
}

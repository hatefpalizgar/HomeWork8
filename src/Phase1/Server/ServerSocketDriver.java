package Phase1.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDriver {
    private Socket          socket;
    private InputStream     is;
    private OutputStream    os;
    private SocketProcessor socketProcessor;
    
    public void startServer() {
        try {
            ServerSocket server = new ServerSocket(46857);
            socket          = server.accept();          //waiting for a client to connect
            is              = socket.getInputStream();
            os              = socket.getOutputStream();
            socketProcessor = new SocketProcessor(socket, is, os);  //Create an instance of Thread
            socketProcessor.start();
        }
        catch (IOException e) {
            System.out.println("Error getting input/output stream");
        }
    }
    
    SocketProcessor getSocketProcessor() {
        return this.socketProcessor;
    }
}


package Phase1.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDriver
    {
    private Socket          socket;
    private InputStream     is;
    private OutputStream    os;
    private SocketProcessor socketProcessor; //This class is responsible for sockets and their thread instance
    
    public void startServer() throws IOException
        {
            ServerSocket server = new ServerSocket(46857);
            socket = null;
            while (true)
                {
                    try
                        {
                            socket          = server.accept();          //waiting for a client to connect
                            is              = socket.getInputStream();
                            os              = socket.getOutputStream();
                            socketProcessor =
                                    new SocketProcessor(socket, is, os);  //Create a new thread for every socket
                            socketProcessor.start();
                        }
                    catch (IOException e)
                        {
                            socket.close();
                            System.out.println("error getting input/output stream");
                        }
                }
        }
    
    
    public SocketProcessor getSocketProcessor()
        {
            return this.socketProcessor;
        }
    }


package Phase1.Client;

import java.io.*;
import java.net.Socket;

public class ClientSocketHandler
    {
    private InputStreamReader  reader;
    private OutputStreamWriter writer;
    private String             message;
    
    private Socket       socket;
    private InputStream  is;
    private OutputStream os;
    
    
    public void sendMessage(String string)
        {
            try
                {
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write(string);
                    bw.flush();
                }
            catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
    
    
    public void establishConnection()
        {
            try
                {
                    socket  = new Socket("localhost", 46857); //server ip: 10.211.55.4  port:46857
                    message = ("Connected to server: " + socket.getLocalAddress().toString() + " port:"
                               + socket.getLocalPort() + "\n");
                    ClientRunner.getClientForm().display(message);
                    is     = socket.getInputStream();
                    os     = socket.getOutputStream();
                    writer = new OutputStreamWriter(os);
                    reader = new InputStreamReader(is);
                }
            catch (Exception e)
                {
                    message = ("Server is down. check it. Establish was unsuccessful");
                }
        }
    }


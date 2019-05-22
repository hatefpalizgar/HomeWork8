package Phase1.Server;

import Phase1.Client.ClientRunner;

import java.io.*;
import java.net.Socket;

import static Phase1.Server.ServerRunner.serverForm;

public class SocketProcessor extends Thread
    {
    private InputStreamReader  reader;
    private BufferedReader     br;
    private BufferedWriter     bw;
    private OutputStreamWriter writer;
    private String             string;
    
    private Socket       receivedSocket;
    private InputStream  is;
    private OutputStream os;
    
    public SocketProcessor(Socket receivedSocket, InputStream is, OutputStream os)
        {
            this.receivedSocket = receivedSocket;
            this.is             = is;
            this.os             = os;
        }
    
    /* accept() has received a client request on its port */
    @Override
    public void run()
        {
            //TODO: correct display name below
            serverForm.display(
                    "Client connected: " + receivedSocket.getInetAddress() + " " + receivedSocket.toString() + "\n");
            readSocket();
        }
    
    public void readSocket()
        {
            while (true)
                {
                    try
                        {
                            reader = new InputStreamReader(is);
                            br     = new BufferedReader(reader);
                            String message;
                            message = br.readLine();
                            //TODO add client name in display
                            serverForm.display(message);
                        }
                    catch (IOException e)
                        {
                            System.out.println("no line to read from");
                            e.printStackTrace();
                        }
                }
        }
    
    public void writeSocket(String string)
        {
            writer = new OutputStreamWriter(os);
            bw     = new BufferedWriter(writer);
            try
                {
                    bw.write(string);
                    serverForm.display("Me: " + string);
                    //TODO: correct display()
                    ClientRunner.getClientForm().display("????:" + string);
                    bw.flush();
                }
            catch (IOException e)
                {
                    e.printStackTrace();
                    serverForm.getTxtLog().setText("stream is not available");
                }
        }
    }

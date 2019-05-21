package Phase1.Server;

import java.io.*;
import java.net.Socket;

import static Phase1.Server.ServerRunner.serverForm;

public class SocketProcessor extends Thread {
    private InputStreamReader  reader;
    private BufferedReader     br;
    private BufferedWriter     bw;
    private OutputStreamWriter writer;
    
    
    private Socket       receivedSocket;
    private InputStream  is;
    private OutputStream os;
    
    public SocketProcessor(Socket receivedSocket, InputStream is, OutputStream os) {
        this.receivedSocket = receivedSocket;
        this.is             = is;
        this.os             = os;
    }
    
    @Override
    public void run() {
        processSocket(receivedSocket);
    }
    
    public void processSocket(Socket socket) {
        serverForm.display(
                "Client connected: " + socket.getInetAddress() + " " + socket.toString() + "\n");
    }
    
    
    public void sendMessage(String string) {
        if (receivedSocket == null) {
            serverForm.display("client disconnected\n");
            return;
        }
        writer = new OutputStreamWriter(os);
        bw     = new BufferedWriter(writer);
        try {
            bw.write(string + "\n");
            serverForm.display("Me: " + string + "\n");
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            serverForm.getTxtLog().setText("Client Not Available");
        }
    }
    
    public void getMessage() {
        //TODO:REMOVE IF UNNECESSARY
        if (receivedSocket == null) {
            serverForm.display("client disconnected\n");
            return;
        }
        try {
            reader = new InputStreamReader(is);
            br     = new BufferedReader(reader);
            String message;
            //check if we have input Stream
            if (is.available() != 0) {
                message = br.readLine();
                serverForm.display("Client: " + message + "\n");
                br.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("no line to read from client");
        }
    }
}

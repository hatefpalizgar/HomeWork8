package Phase1.Client;

import java.io.*;
import java.net.Socket;

import static Phase1.Client.Main.clientForm;


class SocketHandler {
    private static Socket server;
    InputStream       is;
    OutputStream      os;
    InputStreamReader reader;
    BufferedReader    br;
    
    
    public void sendMessage(String string) {
        
        try {
            OutputStreamWriter writer = new OutputStreamWriter(os);
            BufferedWriter     bw     = new BufferedWriter(writer);
            bw.write(string + "\n");
            bw.flush();
            clientForm.display("Me: " + string + "\n");
        } catch (Exception e) {
            clientForm.display("Error sending message to server, check your connection\n ");
        }
        
    }
    
    public void getMessage() {
        if (server.isClosed() || server == null) {
            clientForm.display("Server disconnected\n");
            return;
        }
        
        try {
            reader = new InputStreamReader(is);
            br = new BufferedReader(reader);
            String message;
            if (is.available() != 0) {
                message = br.readLine();
                clientForm.display("Server: " + message + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no line to read from server\n");
        }
        
    }
    
    // establish connection to server
    public boolean establishConnection() {
        try {
            if (server == null) {
                server = new Socket("10.211.55.4", 46857); //server ip: 10.211.55.4  port:46857
                clientForm.display(
                        "Connected to server: " + server.getLocalAddress().toString() + " port:" + server.getLocalPort() +
                        "\n");
            }
            
            is = server.getInputStream();//for reading data
            os = server.getOutputStream();//for writing the data
            
            {
                clientForm.getTxtInput().setEnabled(true);
                clientForm.getBtnSend().setEnabled(true);
            }
            return true;
        } catch (Exception e) {
            clientForm.display("Server is down. check it");
            return false;
        }
    }
}


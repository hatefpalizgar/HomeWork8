package Phase1.Client;

import java.io.*;
import java.net.Socket;


public class ClientSocketHandler {
    private InputStreamReader  reader;
    private OutputStreamWriter writer;
    private Socket             server;
    private String             message;
    private String             output;
    
    
    public String sendMessage(String string) {
        try {
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(string + "\n");
            bw.flush();
        }
        catch (Exception e) {
            //TODO: give a good message
            e.printStackTrace();
        }
        finally {
            return string;
        }
    }
    
    public String getMessage() {
        if (server.isClosed() || server == null) {
            message = "Server disconnected\n";
            return message;
        }
        try {
            BufferedReader br = new BufferedReader(reader);
            message = "Server: " + br.readLine() + "\n";
            //TODO
            /*reader.close();
            br.close;*/
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("no line to read from server\n");
        }
        return message;
    }
    
    // establish connection to server
    public String establishConnection() {
        try {
            server  = new Socket("localhost", 46857); //server ip: 10.211.55.4  port:46857
            message =
                    ("Connected to server: " + server.getLocalAddress().toString() + " port:" + server.getLocalPort() +
                     "\n");
            InputStream  is = server.getInputStream();//for reading data
            OutputStream os = server.getOutputStream();//for writing the data
            writer = new OutputStreamWriter(os);
            reader = new InputStreamReader(is);
        }
        catch (Exception e) {
            message = ("Server is down. check it. Establish was unsuccessful");
        }
        return message;
    }
    
    public String getOutput() {
        return output;
    }
}


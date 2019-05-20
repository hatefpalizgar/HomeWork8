package Phase1.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static Phase1.Server.Main.serverForm;


class SocketHandler extends Thread{
    Socket             s;
    ServerSocket       server;
    OutputStream       os;
    InputStream        is;
    InputStreamReader  reader;
    BufferedReader     br;
    BufferedWriter     bw;
    OutputStreamWriter writer;
    
    public void sendMessage(String string){
        if(s.isClosed()){
            serverForm.display("client disconnected\n");
            return;
        }
        writer = new OutputStreamWriter(os);
        bw = new BufferedWriter(writer);
        try{
            bw.write(string + "\n");
            serverForm.display("Me: " + string + "\n");
            bw.flush();
        } catch(IOException e){
            e.printStackTrace();
            serverForm.getTxtLog().setText ("Client Not Available");
        }
    }
    
    public void getMessage(){
        if(s.isClosed()){
            serverForm.display("client disconnected\n");
            return;
        }
        try{
            reader = new InputStreamReader(is);
            br = new BufferedReader(reader);
            String message ;
            if(is.available() != 0){
                message = br.readLine();
                serverForm.display("Client: " + message + "\n");
            }
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("no line to read from client");
        }
    }
    
    // start the server
    public boolean startServer(){
        try{
            if(s == null){
                server = new ServerSocket(46857); //server ip: 10.211.55.4  port:46857
                s = server.accept();
                serverForm.display("Client connected: " + s.getLocalAddress() + " " + s.toString() + "\n");
                serverForm.getBtnSend().setEnabled(true);
            }
            is = s.getInputStream();//for reading data
            os = s.getOutputStream();//for writing the data
            return true;
        } catch(Exception e){
            serverForm.display("Error connecting to client\n");
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public void run() {
        //TODO
        
    }
    
    public Socket getS(){
        return s;
    }
    
    public ServerSocket getServer(){
        return server;
    }
    
    public OutputStream getOs(){
        return os;
    }
    
    public InputStream getIs(){
        return is;
    }
    
    public InputStreamReader getReader(){
        return reader;
    }
    
    public BufferedReader getBr(){
        return br;
    }
    
    public BufferedWriter getBw(){
        return bw;
    }
    
    public OutputStreamWriter getWriter(){
        return writer;
    }
}


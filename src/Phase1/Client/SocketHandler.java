package Phase1.Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static Phase1.Client.Main.clientForm;


class SocketHandler{
    //obtain input and output stream
    private static Socket server;
    InputStream  is;
    OutputStream os;
    
    public SocketHandler(){
        establishConnection();
    }
    
    public void sendMessage(String string) throws Exception{
        OutputStream os=server.getOutputStream();//for writing the data
    
    }
    
    public void getMessage() throws Exception{
        InputStream is=server.getInputStream();//for reading data
    
    }
    
    // establish connection to server
    public void establishConnection() {
        display("Connecting to server.....");
        try{
            server = new Socket("10.211.55.4" , 46857); //server ip: 10.211.55.4  port:46857
            display("Connected to server: " + server.getLocalAddress() + " port:" + server.getLocalPort());
        }catch(Exception e){
            display("Error connecting to server");
            e.printStackTrace();
        }
    }
    
    private void display(String string){
        clientForm.getTxtLog().append(string + "\n");
    }
}


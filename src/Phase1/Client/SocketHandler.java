package Phase1.Client;

import java.io.*;
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
        OutputStreamWriter writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(string);
        clientForm.display("Me: " + string + "\n");
    }
    
    public void getMessage() throws Exception{
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        String message;
        while(clientForm.getFrame().isVisible()){
            message = br.readLine();
            clientForm.display(message);
        }
    }
    
    // establish connection to server
    public boolean establishConnection(){
        clientForm.display("Connecting to server.....");
        try{
            server = new Socket("10.211.55.4" , 46857); //server ip: 10.211.55.4  port:46857
            clientForm.display("Connected to server: " + server.getLocalAddress() + " port:" + server.getLocalPort());
            InputStream is = server.getInputStream();//for reading data
            OutputStream os = server.getOutputStream();//for writing the data
            clientForm.getTxtInput().setEnabled(true);
            clientForm.getBtnSend().setEnabled(true);
            return true;
        } catch(Exception e){
            clientForm.display("Error connecting to server");
            e.printStackTrace();
            return false;
        }
    }
}


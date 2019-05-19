package Phase1.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Phase1.Server.Main.socketHandler;


public class ServerForm extends JFrame{
    public ServerForm(){
        initComponents();
    }
    
    // Send button clicked
    private void btnSendActionPerformed(ActionEvent e){
            socketHandler.getMessage();
            socketHandler.sendMessage(txtInput.getText());
      
    }
    
    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hatef
        this.frame = new JFrame();
        this.scrollPane1 = new JScrollPane();
        this.txtLog = new JTextArea();
        this.scrollPane2 = new JScrollPane();
        this.txtInput = new JTextField();
        this.btnSend = new JButton();
        this.frame.setTitle("Server");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container ClientFormContentPane = this.frame.getContentPane();
        this.frame.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){
            }
    
            @Override
            public void mouseMoved(MouseEvent e){
            socketHandler.getMessage();
            }
        });
        this.txtLog.setEditable(false);
        this.scrollPane1.setViewportView(this.txtLog);
        this.btnSend.setText("Send");
        this.btnSend.setEnabled(false);
        //ADDED A WINDOW LISTENER
        this.frame.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e){
            }
            
            @Override
            public void windowClosing(WindowEvent e){
            }
            
            @Override
            public void windowClosed(WindowEvent e){
            }
            
            @Override
            public void windowIconified(WindowEvent e){
            }
            
            @Override
            public void windowDeiconified(WindowEvent e){
            }
            
            @Override
            public void windowActivated(WindowEvent e){
                socketHandler.startServer();
               
            }
            
            @Override
            public void windowDeactivated(WindowEvent e){
            }
        });
        this.btnSend.addActionListener(this::btnSendActionPerformed);
        GroupLayout ClientFormContentPaneLayout = new GroupLayout(ClientFormContentPane);
        ClientFormContentPane.setLayout(ClientFormContentPaneLayout);
        ClientFormContentPaneLayout.setHorizontalGroup(ClientFormContentPaneLayout.createParallelGroup().addGroup(
                ClientFormContentPaneLayout.createSequentialGroup().addGroup(
                        ClientFormContentPaneLayout.createParallelGroup().addGroup(
                                ClientFormContentPaneLayout.createSequentialGroup().addGap(280 , 280 ,
                                                                                           280).addComponent(
                                        this.scrollPane2 , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE ,
                                        GroupLayout.PREFERRED_SIZE)).addGroup(
                                ClientFormContentPaneLayout.createSequentialGroup().addGap(45 , 45 , 45).addGroup(
                                        ClientFormContentPaneLayout.createParallelGroup().addGroup(
                                                ClientFormContentPaneLayout.createSequentialGroup().addComponent(
                                                        this.txtInput , GroupLayout.PREFERRED_SIZE , 428 ,
                                                        GroupLayout.PREFERRED_SIZE).addGap(18 , 18 , 18).addComponent(
                                                        this.btnSend , GroupLayout.DEFAULT_SIZE ,
                                                        GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)).addComponent(
                                                this.scrollPane1 , GroupLayout.PREFERRED_SIZE , 587 ,
                                                GroupLayout.PREFERRED_SIZE)))).addContainerGap(81 , Short.MAX_VALUE)));
        ClientFormContentPaneLayout.setVerticalGroup(ClientFormContentPaneLayout.createParallelGroup().addGroup(
                ClientFormContentPaneLayout.createSequentialGroup().addGap(41 , 41 , 41).addComponent(this.scrollPane1 ,
                                                                                                      GroupLayout.PREFERRED_SIZE ,
                                                                                                      395 ,
                                                                                                      GroupLayout.PREFERRED_SIZE).addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED , 19 , Short.MAX_VALUE).addGroup(
                        ClientFormContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(
                                this.txtInput , GroupLayout.PREFERRED_SIZE , 44 ,
                                GroupLayout.PREFERRED_SIZE).addComponent(this.btnSend , GroupLayout.PREFERRED_SIZE ,
                                                                         51 ,
                                                                         GroupLayout.PREFERRED_SIZE)).addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED).addComponent(this.scrollPane2 ,
                                                                             GroupLayout.PREFERRED_SIZE ,
                                                                             GroupLayout.DEFAULT_SIZE ,
                                                                             GroupLayout.PREFERRED_SIZE).addGap(22 ,
                                                                                                                22 ,
                                                                                                                22)));
        this.frame.pack();
        this.frame.setLocationRelativeTo(this.frame.getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    // Generated using JFormDesigner Evaluation license - Hatef
    private JFrame      frame;
    private JScrollPane scrollPane1;
    private JTextArea   txtLog;
    private JScrollPane scrollPane2;
    private JTextField  txtInput;
    private JButton     btnSend;
    
    public void display(String string){
        String log    = this.getTxtLog().getText();
        String result = new StringBuffer(log).append(string).toString();
        this.getTxtLog().setText(result);
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    public void setFrame(JFrame frame){
        this.frame = frame;
    }
    
    public JTextArea getTxtLog(){
        return txtLog;
    }
    
    public void setTxtLog(JTextArea txtLog){
        this.txtLog = txtLog;
    }
    
    public JTextField getTxtInput(){
        return txtInput;
    }
    
    public void setTxtInput(JTextField txtInput){
        this.txtInput = txtInput;
    }
    
    public JButton getBtnSend(){
        return btnSend;
    }
    
    public void setBtnSend(JButton btnSend){
        this.btnSend = btnSend;
    }
}

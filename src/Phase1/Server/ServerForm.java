package Phase1.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Phase1.Server.ServerRunner.serverSocketDriver;


public class ServerForm extends JFrame
    {
    // Generated using JFormDesigner Evaluation license - Hatef
    private JFrame      frame;
    private JScrollPane scrollPane1;
    private JTextArea   txtLog;
    private JScrollPane scrollPane2;
    private JTextField  txtInput;
    private JButton     btnSend;
    
    public ServerForm()
        {
            initComponents();
        }
    
    private void btnSendActionPerformed(ActionEvent e)      //Send button behaviour
    {
        serverSocketDriver.getSocketProcessor().writeSocket(txtInput.getText());
    }
    
    
    public void display(String string)
        {
            this.getTxtLog().append(string + "\n");
        }
    
    public JFrame getFrame()
        {
            return frame;
        }
    
    
    public JTextArea getTxtLog()
        {
            return txtLog;
        }
    
    
    public JButton getBtnSend()
        {
            return btnSend;
        }
    
    //====================================== INIT COMPONENT =====================
    private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Hatef
            this.frame       = new JFrame();
            this.scrollPane1 = new JScrollPane();
            this.txtLog      = new JTextArea();
            this.scrollPane2 = new JScrollPane();
            this.txtInput    = new JTextField();
            this.btnSend     = new JButton();
            this.frame.setTitle("Server");
            this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container ClientFormContentPane = this.frame.getContentPane();
       /* this.frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }
            
            @Override
            public void mouseMoved(MouseEvent e) {
                serverSocketDriver.getSocketProcessor().getMessage();
            }
        });*/
            this.txtLog.setEditable(false);
            this.scrollPane1.setViewportView(this.txtLog);
            this.btnSend.setText("Send");
            this.btnSend.setEnabled(true);
            this.btnSend.addActionListener(this::btnSendActionPerformed);
            GroupLayout ClientFormContentPaneLayout = new GroupLayout(ClientFormContentPane);
            ClientFormContentPane.setLayout(ClientFormContentPaneLayout);
            ClientFormContentPaneLayout.setHorizontalGroup(ClientFormContentPaneLayout.createParallelGroup()
                                                                                      .addGroup(
                                                                                              ClientFormContentPaneLayout
                                                                                                      .createSequentialGroup()
                                                                                                      .addGroup(
                                                                                                              ClientFormContentPaneLayout
                                                                                                                      .createParallelGroup()
                                                                                                                      .addGroup(
                                                                                                                              ClientFormContentPaneLayout
                                                                                                                                      .createSequentialGroup()
                                                                                                                                      .addGap(280,
                                                                                                                                              280,
                                                                                                                                              280)
                                                                                                                                      .addComponent(
                                                                                                                                              this.scrollPane2,
                                                                                                                                              GroupLayout.PREFERRED_SIZE,
                                                                                                                                              GroupLayout.DEFAULT_SIZE,
                                                                                                                                              GroupLayout.PREFERRED_SIZE))
                                                                                                                      .addGroup(
                                                                                                                              ClientFormContentPaneLayout
                                                                                                                                      .createSequentialGroup()
                                                                                                                                      .addGap(45,
                                                                                                                                              45,
                                                                                                                                              45)
                                                                                                                                      .addGroup(
                                                                                                                                              ClientFormContentPaneLayout
                                                                                                                                                      .createParallelGroup()
                                                                                                                                                      .addGroup(
                                                                                                                                                              ClientFormContentPaneLayout
                                                                                                                                                                      .createSequentialGroup()
                                                                                                                                                                      .addComponent(
                                                                                                                                                                              this.txtInput,
                                                                                                                                                                              GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                              428,
                                                                                                                                                                              GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                      .addGap(18,
                                                                                                                                                                              18,
                                                                                                                                                                              18)
                                                                                                                                                                      .addComponent(
                                                                                                                                                                              this.btnSend,
                                                                                                                                                                              GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                              GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                              Short.MAX_VALUE))
                                                                                                                                                      .addComponent(
                                                                                                                                                              this.scrollPane1,
                                                                                                                                                              GroupLayout.PREFERRED_SIZE,
                                                                                                                                                              587,
                                                                                                                                                              GroupLayout.PREFERRED_SIZE))))
                                                                                                      .addContainerGap(
                                                                                                              81,
                                                                                                              Short.MAX_VALUE)));
            ClientFormContentPaneLayout.setVerticalGroup(ClientFormContentPaneLayout.createParallelGroup()
                                                                                    .addGroup(
                                                                                            ClientFormContentPaneLayout.createSequentialGroup()
                                                                                                                       .addGap(41,
                                                                                                                               41,
                                                                                                                               41)
                                                                                                                       .addComponent(
                                                                                                                               this.scrollPane1,
                                                                                                                               GroupLayout.PREFERRED_SIZE,
                                                                                                                               395,
                                                                                                                               GroupLayout.PREFERRED_SIZE)
                                                                                                                       .addPreferredGap(
                                                                                                                               LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                               19,
                                                                                                                               Short.MAX_VALUE)
                                                                                                                       .addGroup(
                                                                                                                               ClientFormContentPaneLayout
                                                                                                                                       .createParallelGroup(
                                                                                                                                               GroupLayout.Alignment.BASELINE)
                                                                                                                                       .addComponent(
                                                                                                                                               this.txtInput,
                                                                                                                                               GroupLayout.PREFERRED_SIZE,
                                                                                                                                               44,
                                                                                                                                               GroupLayout.PREFERRED_SIZE)
                                                                                                                                       .addComponent(
                                                                                                                                               this.btnSend,
                                                                                                                                               GroupLayout.PREFERRED_SIZE,
                                                                                                                                               51,
                                                                                                                                               GroupLayout.PREFERRED_SIZE))
                                                                                                                       .addPreferredGap(
                                                                                                                               LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                       .addComponent(
                                                                                                                               this.scrollPane2,
                                                                                                                               GroupLayout.PREFERRED_SIZE,
                                                                                                                               GroupLayout.DEFAULT_SIZE,
                                                                                                                               GroupLayout.PREFERRED_SIZE)
                                                                                                                       .addGap(22,
                                                                                                                               22,
                                                                                                                               22)));
            this.frame.pack();
            this.frame.setLocationRelativeTo(this.frame.getOwner());
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }
    }

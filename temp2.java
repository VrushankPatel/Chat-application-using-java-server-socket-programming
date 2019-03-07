import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class temp2 extends JFrame
{
    String msgs,msg;
    JTextArea content;
    public temp2()
    {
        JLabel title=new JLabel("Chatting Application 2");
        title.setBounds(10,10,150,20);
        JButton close=new JButton("X");
        close.setBounds(344,10,50,20);
        close.addActionListener(ae ->
                                {
                                    System.exit(0);
                                }
                                );
        add(close);
        add(title);
        msgs="==========|Program By : vrushank Patel|==========";
        SimpleDateFormat forr=new SimpleDateFormat("dd/MM/yyyy HH:m:ss");
        //JPanel jj=new JPanel();
        //jj.add(new JButton("Vrushank"));
        //vv.setBorder(BorderFactory.createTitledBorder("vrushank's legend"));
        //add(jj);
        //setOpacity(0.33f);
        setUndecorated(true);
        setBounds(700,200,400,480);
        msg="Console : ";
        JTextArea console=new JTextArea(msg);
        JScrollPane scroll2 = new JScrollPane(console);
        console.setEditable(false);
        scroll2.setBounds(10,380,378,90);
        console.setBackground(Color.BLACK);
        console.setForeground(Color.WHITE);
        scroll2.setBackground(Color.BLACK);
        scroll2.setForeground(Color.WHITE);
        add(scroll2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Chatting Program in Java temp2");
        setLayout(null);
        setBackground(Color.WHITE);
        content=new JTextArea(msgs);
        content.setText(msgs);
        //content.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JScrollPane scroll = new JScrollPane(content);
        content.setBounds(6,30,386,304);
        scroll.setBounds(6,35,388,304);
        content.setEditable(false);
        JLabel messagelbl=new JLabel("Type Message Here : ");
        messagelbl.setBounds(10,340,160,30);
        JTextField message=new JTextField();
        message.setBounds(150,340,170,30);
        JButton send=new JButton("Send");
        send.setBackground(Color.GREEN);
        send.setContentAreaFilled(false);
        send.setOpaque(false);
        send.setBounds(320,340,80,30);
        add(messagelbl);
        add(send);
        add(scroll);
        add(message);
        message.setEditable(true);
        setVisible(true);
        message.grabFocus();
        
        send.addActionListener(new ActionListener()
                               {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    msg=msg+"\n"+"Creating Socket at port 1212 on localhost";
                    console.setText(msg);
                    Socket s=new Socket("localhost",1212);
                    msg=msg+"...............Done\ncreating dataoutputstream object";
                    console.setText(msg);
                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    msg=msg+"...............Done\nnow Binding the Message";
                    console.setText(msg);
                    msgs=msgs+"\n\nSended ["+forr.format(new Date())+"] : -> "+message.getText();
                    msg=msg+"...............Done\nnow sending the message";
                    console.setText(msg);
                    dout.writeUTF(message.getText());
                    msg=msg+"...............Done\nWriting the record";
                    console.setText(msg);
                    content.setText(msgs);
                    msg=msg+"...............Done\nClosing the Connections";
                    console.setText(msg);
                    s.close();
                    dout.close();
                    msg=msg+"...............Done";
                    console.setText(msg);
                }catch(Exception ee)
                {
                    msg=msg+"\n"+ee.toString();
                    console.setText(msg);
                }
            }
        }
                               );
        try
        {
            int y=0;
            
            while(y<10)
            {
                msg=msg+"\nCreating ServerSocket with reserving new port 1111";
                console.setText(msg);
                ServerSocket sssa=new ServerSocket(1111);
                msg=msg+"...............Done\nnow waiting for client whose connection can be accepted by socket";
                console.setText(msg);
                
                Socket ssa=sssa.accept();
                msg=msg+"...............Done\nnow crating datainputstream object";
                console.setText(msg);
                
                DataInputStream disa=new DataInputStream(ssa.getInputStream());
                msg=msg+"...............Done\nnow receiving message and storing it inside the string object";
                console.setText(msg);
                
                String stra=(String)disa.readUTF();
                msg=msg+"...............Done\nnow creating the String with date and time for storing record";
                console.setText(msg);
                
                msgs=msgs+"\n\nReceived ["+forr.format(new Date())+"] : -> "+stra;
                msg=msg+"...............Done\nnow printing record on message console";
                console.setText(msg);
                
                content.setText(msgs);
                msg=msg+"...............Done\nnow closing connections";
                console.setText(msg);
                
                disa.close();
                msg=msg+"...............Done\n";
                console.setText(msg);
                
                ssa.close();
                msg=msg+"...............Done\n";
                console.setText(msg);
                
                sssa.close();
                msg=msg+"...............Done\n";
                console.setText(msg);
                
            }
            
        }
        catch(Exception e)
        {
            msg=msg+"\n"+e.toString();
            console.setText(msg);
        }
    }
    public static void main(String[] args)
    {
        new temp2();
    }
}

package mypck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton back ,rules;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,700,500);
        add(image);

        JLabel heading = new JLabel("Quiz-App");
        heading.setBounds(850,60,300,45);
        heading.setFont(new Font("Arial",Font.BOLD,28));
        heading.setForeground(Color.BLUE);
        add(heading);


        JLabel name = new JLabel("Enter your name ");
        name.setBounds(800,140,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        name.setForeground(Color.BLUE);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(755,200,300,35);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);

        rules  = new JButton("Rules");
        rules.setBounds(775,270,100,35);
        rules.setBackground(new Color(173, 216, 230));
        rules.setForeground(Color.BLACK);
        rules.setFont(new Font("Georgia",Font.BOLD,20));
        rules.addActionListener(this);
        add(rules);

        back  = new JButton("Back");
        back.setBounds(945,270,100,35);
        rules.setBackground(new Color(173, 216, 230));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Georgia",Font.BOLD,20));
        back.addActionListener(this);
        add(back);
        
        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if(e.getSource()==back) {
              setVisible((false));
        }
    }
 public static void main(String args[]){

        new Login();
 }


}

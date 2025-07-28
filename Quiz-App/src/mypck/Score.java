package mypck;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JLabel heading, scoreLable;
    JButton submit;
    String name;
    Score(String name ,int score){
      this.name = name;
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1   = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,200,300,250);
        add(image);



        heading = new JLabel("Thankyou "+ name + " for playing simple Minds");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Verdana",Font.BOLD,26));
        add(heading);

        scoreLable = new JLabel(" Your score is "+score);
        scoreLable.setBounds(350,200,300,30);
        scoreLable.setFont(new Font("Verdana",Font.BOLD,26));
        add(scoreLable);


        submit = new JButton("Play Again");
        submit.setBounds(380,270,120,30);
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);

        add(submit);

        setVisible(true);

    }
    public  void actionPerformed(ActionEvent e){

        setVisible(false);
        new Quiz(name);
    }

    public  static void  main(String args[]){

        new Score("User",0);
    }
}

package mypck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name ;
    JButton start ,back;
    Rules( String name){
         this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+ name +" to Quiz-App");
        heading.setBounds(50,20,700,35);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,18));
//        rules.setForeground(new Color(30,144,254));
        rules.setText(
                "<html>" +
                        "<b>📋 QUIZ RULES:</b><br>" +
                        "1. Each question carries one mark.<br><br>" +
                        "2. No negative marking for wrong answers.<br><br>" +
                        "3. You must answer all questions to submit the quiz.<br><br>" +
                        "4. Do not refresh or close the window during the quiz.<br><br>" +
                        "5. Timer will be displayed at the top.<br><br>" +
                        "6. Once submitted, answers cannot be changed.<br><br>" +
                        "7. No external help (books, internet, or others) is allowed.<br><br>" +
                        "8. Make sure you have a stable internet connection.<br><br>" +
                        "9. In case of technical issues, contact support immediately.<br><br>" +
                        "10. Cheating or malpractice will result in disqualification." +
                        "</html>"
        );

        back = new JButton("Back");
        back.setBounds(450,500,100,30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        add(rules);
        start  = new JButton("Start");
        start.setBounds(250,500,100,30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==start){
            setVisible(false);
            new Quiz(name);

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static  void main(String args[]){
        new Rules("User");
    }

}

/*
*
* Tictactoe game
*  @ketan
*
*/
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameFrame implements ActionListener
{
    JFrame jf;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    int count=0,n;
    Font f;
    String s=null,p1,p2,temp;
    boolean win=false;
    Color color;

    public GameFrame(String play1, String play2,int i)
    {
        n=i;
        p1=play1;
        p2=play2;
        jf = new JFrame( p1+" start with 0 ");
        jf.setSize(800,500);
        GridLayout gl=new GridLayout(3, 3);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(gl);
        jf.setVisible(true);

        jb1=new JButton();jb1.addActionListener(this);
        jb2=new JButton();jb2.addActionListener(this);
        jb3=new JButton();jb3.addActionListener(this);
        jb4=new JButton();jb4.addActionListener(this);
        jb5=new JButton();jb5.addActionListener(this);
        jb6=new JButton();jb6.addActionListener(this);
        jb7=new JButton();jb7.addActionListener(this);
        jb8=new JButton();jb8.addActionListener(this);
        jb9=new JButton();jb9.addActionListener(this);

        jf.add(jb1);jf.add(jb2);jf.add(jb3);jf.add(jb4);jf.add(jb5);
        jf.add(jb6);jf.add(jb7);jf.add(jb8);jf.add(jb9);
    }

    public void actionPerformed(ActionEvent e)
    {
        f=new Font("Ariel", 1, 50);
        count=count+1;
        if(count%2==0)
        {
            s="X";
            jf.setTitle(p1+" turn 0");
            color=Color.BLUE;
        }
        else
        {
            s="0";
            jf.setTitle(p2+" turn X");
            color=Color.GRAY;
        }
        jb1.setFont(f);jb2.setFont(f);jb3.setFont(f);jb4.setFont(f);
        jb5.setFont(f);jb6.setFont(f);jb7.setFont(f);jb8.setFont(f);jb9.setFont(f);

        if(e.getSource()==jb1 ) {
            jb1.setBackground(color);
            jb1.setText(s);
            jb1.setEnabled(false);
        }
        else if(e.getSource()==jb2) {
            jb2.setBackground(color);
            jb2.setText(s);
            jb2.setEnabled(false);
        }
        else if(e.getSource()==jb3)
        {
            jb3.setBackground(color);
            jb3.setText(s);
            jb3.setEnabled(false);
        }
        else if(e.getSource()==jb4)
        {
            jb4.setBackground(color);
            jb4.setText(s);
            jb4.setEnabled(false);
        }
        else if(e.getSource()==jb5)
        {
            jb5.setBackground(color);
            jb5.setText(s);
            jb5.setEnabled(false);
        }
        else if(e.getSource()==jb6)
        {
            jb6.setBackground(color);
            jb6.setText(s);
            jb6.setEnabled(false);
        }
        else if(e.getSource()==jb7)
        {
            jb7.setBackground(color);
            jb7.setText(s);
            jb7.setEnabled(false);
        }
        else if(e.getSource()==jb8)
        {
            jb8.setBackground(color);
            jb8.setText(s);
            jb8.setEnabled(false);
        }
        else if(e.getSource()==jb9)
        {
            jb9.setBackground(color);
            jb9.setText(s);
            jb9.setEnabled(false);
        }

        checkwin();
    }

    void checkwin()
    {
        if(jb1.getText()==jb2.getText() && jb2.getText()==jb3.getText() && jb1.getText()!="")
            win=true;
        else if(jb1.getText()==jb4.getText() && jb4.getText()==jb7.getText() && jb7.getText()!="")
            win=true;
        else if(jb1.getText()==jb5.getText() && jb5.getText()==jb9.getText() && jb9.getText()!="")
            win=true;
        else if(jb2.getText()==jb5.getText() && jb5.getText()==jb8.getText() && jb8.getText()!="")
            win=true;
        else if(jb3.getText()==jb6.getText() && jb6.getText()==jb9.getText() && jb9.getText()!="")
            win=true;
        else if (jb3.getText()==jb5.getText() && jb5.getText()==jb7.getText() && jb7.getText()!="")
            win=true;
        else if (jb7.getText()==jb8.getText() && jb8.getText()==jb9.getText() && jb9.getText()!="")
            win=true;
        else
            win=false;

        if(win && count%2==1)
        {
            JOptionPane.showMessageDialog(jf, p1+ " Wins");
            temp=p1;
        }
        else if(win && count%2==0)
        {
            JOptionPane.showMessageDialog(jf, p2+" wins");
            temp=p2;
        }
        else if(win==false && count==9)
        {
            JOptionPane.showMessageDialog(jf," match draw");
        }

        if(win)
        {
            restartGame(temp);
        }
    }

    void restartGame(String temp)
    {
        if(p1.equals(temp))
        {

        }else
        {
            p2=p1;
            p1=temp;
        }
       int i= JOptionPane.showConfirmDialog(jf, "DO you want to restart");
        if(i==0)
            new GameFrame(p1,p2,i);
        else if(i==1)
            System.exit(1);
        else if(i==2)
            btnSetEnable(false);

    }

    void btnSetEnable(Boolean b)
    {
        jb1.setEnabled(b);
        jb2.setEnabled(b);
        jb3.setEnabled(b);
        jb4.setEnabled(b);
        jb5.setEnabled(b);
        jb6.setEnabled(b);
        jb7.setEnabled(b);
        jb8.setEnabled(b);
        jb9.setEnabled(b);
    }

    /*public static void main(String[] args) {
        new GameFrame("ketan", "kuldip");
    }*/

}
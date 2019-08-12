import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library extends Applet implements ActionListener
{
    Label lheader,lname,lissuedate,llate;
    TextField tname,tissuedate,tlate;
    Button ok;
    String sdbname=new String("");
    String sname=new String("");
    
    public void init() 
    {
        int x1=50,y1=200,w1=250,h1=25;
        int g=20;
        int x2=x1+w1+g,y2=y1,w2=w1*2,h2=h1;
        Font fs=new Font("serif",Font.BOLD,20);
        
        this.setLayout(null);
        this.setSize(1000,700);
        this.setBackground(Color.LIGHT_GRAY);
        
        lheader = new Label("LIBRARY DETAILS");
        Font ft =new Font("serif",Font.BOLD,50);
        lheader.setFont(ft);
        lheader.setForeground(Color.red);
        lheader.setBounds(250,0,500,150);
        add(lheader);
        
        lname = new Label("NAME:");
        lname.setBounds(x1,y1,w1,h1);
        lname.setFont(fs);
        add(lname);
        tname = new TextField();
        tname.setBounds(x2,y2,w2,h2);
        add(tname);
        
    
        
        llate = new Label("NoOfDays AFTER ISSUE:");
        llate.setBounds(x1,y1+2*(g+h1),w1,h1);
        llate.setFont(fs);
        add(llate);
        tlate = new TextField();
        tlate.setBounds(x2,y2+2*(g+h1),w2,h2);
        add(tlate);
        
        
        ok=new Button("OK");
        ok.setBounds(x2+g,y2+3*(g+h1)+40,100,35);
        ok.setFont(fs);
        ok.setBackground(Color.blue);
        ok.setForeground(Color.white);
        add(ok);
        ok.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        int x1=50,y1=200,w1=250,h1=25;
        int g=20;
        int x2=x1+w1+g,y2=y1,w2=w1*2,h2=h1;
        Font fs=new Font("serif",Font.BOLD,20);
        
        if (ae.getSource()==ok)
        {
          int x,y;
          if ((y=Integer.parseInt(tlate.getText()))<7)
              x=0;
          else
              x=(y-7)*2;
          Label l=new Label("Your Fine Is "  + "Rs." + x + " /- Only");
          l.setBounds(x2+g,y2+3*(g+h1)+40,500,35);
          l.setFont(fs);
          add(l);
          
          
          ok.setVisible(false);
        }
    
    }
}

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher extends Applet implements ActionListener
{
    Label lheader,lname,lemail,lphoneno,lgender,ldept,llibcardno,lissuedate;
    TextField tname,temail,tphoneno,tlibcardno,tissuedate;
    Choice cdept;
    Checkbox m,f;
    CheckboxGroup cg;
    Button ok;

    //STRINGS
    String sname=new String("");
    String semail=new String("");
    String sgender =new String("");
    String sphoneno=new String("");
    String sdept=new String("");
    String slibcardno=new String("");
    String sdbname=new String("");
    String scid= new String("");
    String steacher= new String("");
    String spassword = new String("");
    String sissuedate = new String ("");
    
    
    public void init() 
    {
    
        int x1=50,y1=200,w1=150,h1=25;
        int g=20;
        int x2=x1+w1+g,y2=y1,w2=w1*2,h2=h1;
        Font fs=new Font("serif",Font.BOLD,20);
        
        this.setLayout(null);
        this.setSize(1000,700);
        this.setBackground(Color.LIGHT_GRAY);
        
        lheader = new Label("STUDENT DETAILS");
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
        
        lemail = new Label("EMAIL ID:");
        lemail.setBounds(x1,y1+g+h1,w1,h1);
        lemail.setFont(fs);
        add(lemail);
        lemail.setVisible(false);
        temail = new TextField();
        temail.setBounds(x2,y2+g+h1,w2,h2);
        add(temail);
        temail.setVisible(false);
        
        lgender = new Label("GENDER:");
        lgender.setBounds(x1,y1+2*(g+h1),w1,h1);
        lgender.setFont(fs);
        add(lgender);
        lgender.setVisible(false);
        cg=new CheckboxGroup();
        m=new Checkbox("Male",false,cg);
        f=new Checkbox("Female",false,cg);
        m.setBounds(x2,y2+2*(g+h1),100,20);
        f.setBounds(x2+100,y2+2*(g+h1),100,20);
        m.setFont(fs);
        f.setFont(fs);
        add(m);
        add(f);
        m.setVisible(false);
        f.setVisible(false);
        
        
        lphoneno = new Label("PHONE NO.:");
        lphoneno.setBounds(x1,y1+3*(g+h1),w1,h1);
        lphoneno.setFont(fs);
        add(lphoneno);
        lphoneno.setVisible(false);
        tphoneno = new TextField();
        tphoneno.setBounds(x2,y2+3*(g+h1),w2,h2);
        add(tphoneno);
        tphoneno.setVisible(false);
        
        
        ldept = new Label("DEPARTMENT:");
        ldept.setBounds(x1,y1+4*(g+h1),w1,h1);
        ldept.setFont(fs);
        add(ldept);
        ldept.setVisible(false);
        cdept = new Choice();
        cdept.setBounds(x2,y2+4*(g+h1),w2,h2);
        add(cdept);
        cdept.addItem("CMPN(I SHIFT)");
        cdept.addItem("CMPN(II SHIFT)");
        cdept.addItem("IT");
        cdept.addItem("ETRX");
        cdept.addItem("EXTC");
        cdept.addItem("CIVIL");
        cdept.addItem("INSTRU");
        cdept.addItem("MECHANICAL");
        cdept.setVisible(false);
    
        llibcardno = new Label("LIBRARY CARD NO.:");
        llibcardno.setBounds(x1,y1+5*(g+h1),w1,h1);
        llibcardno.setFont(fs);
        add(llibcardno);
        llibcardno.setVisible(false);
        tlibcardno = new TextField();
        tlibcardno.setBounds(x2,y2+5*(g+h1),w2,h2);
        add(tlibcardno);
        tlibcardno.setVisible(false);
        
        
        lissuedate = new Label("ISSUE DATE:");
        lissuedate.setBounds(x1,y1+6*(g+h1),w1,h1);
        lissuedate.setFont(fs);
        add(lissuedate);
        tissuedate = new TextField();
        tissuedate.setBounds(x2,y2+6*(g+h1),w2,h2);
        add(tissuedate);
              lissuedate.setVisible(false);
          tissuedate.setVisible(false);
    
        
        ok=new Button("OK");
        ok.setBounds(x2+g,y2+6*(g+h1)+40,100,35);
        ok.setFont(fs);
        ok.setBackground(Color.blue);
        ok.setForeground(Color.white);
        add(ok);
        ok.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource()==ok)
        {
          try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/applicatioSystem;create=true;user=KARAN;password=KARAN");    
            Statement st=con.createStatement();
            String query="select * from APPLICTIONSYSTEM";
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                sdbname=(rs.getString("NAME"));
                if(sname.equalsIgnoreCase(sdbname))
                {
                    if(("m".equals(rs.getString("GENDER")))||"M".equals(rs.getString("GENDER")))
                        cg.setSelectedCheckbox(m);
                    else
                        cg.setSelectedCheckbox(f);
                    temail.setText(rs.getString("EMAIL_ID"));
                    tphoneno.setText(rs.getString("PHONE_NO"));                    
                    cdept.select(rs.getString("DEPARTMENT"));
                    tlibcardno.setText(rs.getString("LIBRARY_CARDNO"));
                    tissuedate.setText(rs.getString("ISSUE_DATE"));
                }
          ok.setVisible(false);
          lemail.setVisible(true);
          temail.setVisible(true);
          lgender.setVisible(true);
          m.setVisible(true);
          f.setVisible(true);
          lphoneno.setVisible(true);
          tphoneno.setVisible(true);
          ldept.setVisible(true);
          cdept.setVisible(true);
          llibcardno.setVisible(true);
          tlibcardno.setVisible(true);
          sname=tname.getText();
          lissuedate.setVisible(true);
          tissuedate.setVisible(true);
    
            }
    }
      catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) 
      {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
      }

     
        }
    }
}

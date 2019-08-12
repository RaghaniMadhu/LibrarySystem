import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Applet implements ActionListener
{
    Label lheader,lname,lemail,lphoneno,lgender,ldept,llibcardno,lsubmit,lissuedate,llabel;
    TextField tname,temail,tphoneno,tlibcardno,tissuedate;
    Choice cdept;
    Checkbox m,f;
    CheckboxGroup cg;
    Button submit;
    
    
    
    public void init() 
    {
        int x1=50,y1=200,w1=200,h1=25;
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
        temail = new TextField();
        temail.setBounds(x2,y2+g+h1,w2,h2);
        add(temail);
        
        lgender = new Label("GENDER:");
        lgender.setBounds(x1,y1+2*(g+h1),w1,h1);
        lgender.setFont(fs);
        add(lgender);
        cg=new CheckboxGroup();
        m=new Checkbox("Male",false,cg);
        f=new Checkbox("Female",false,cg);
        m.setBounds(x2,y2+2*(g+h1),100,20);
        f.setBounds(x2+100,y2+2*(g+h1),100,20);
        m.setFont(fs);
        f.setFont(fs);
        add(m);
        add(f);
        
        lphoneno = new Label("PHONE NO.:");
        lphoneno.setBounds(x1,y1+3*(g+h1),w1,h1);
        lphoneno.setFont(fs);
        add(lphoneno);

        tphoneno = new TextField();
        tphoneno.setBounds(x2,y2+3*(g+h1),w2,h2);
        add(tphoneno);
        
        ldept = new Label("DEPARTMENT:");
        ldept.setBounds(x1,y1+4*(g+h1),w1,h1);
        ldept.setFont(fs);
        add(ldept);
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
        
        
        llibcardno = new Label("LIBRARY CARD NO.:");
        llibcardno.setBounds(x1,y1+5*(g+h1),w1,h1);
        llibcardno.setFont(fs);
        add(llibcardno);
        tlibcardno = new TextField();
        tlibcardno.setBounds(x2,y2+5*(g+h1),w2,h2);
        add(tlibcardno);
        
        lissuedate = new Label("ISSUE DATE:");
        llabel=new Label("(If Not Write NIL)");
        lissuedate.setBounds(x1,y1+6*(g+h1),w1,h1);
        lissuedate.setFont(fs);
        add(lissuedate);
        add(llabel);
        llabel.setFont(fs);
        llabel.setBounds(x2+w2+10,y2+6*(g+h1),w2,h2);
        tissuedate = new TextField();
        tissuedate.setBounds(x2,y2+6*(g+h1),w2,h2);
        add(tissuedate);
        
        
        
        submit=new Button("SUBMIT");
        submit.setBounds(x2+g,y2+6*(g+h1)+40,100,35);
        submit.setFont(fs);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        add(submit);
        submit.addActionListener(this);
        
        
        Font fsR=new Font("serif",Font.BOLD,30);
        lsubmit = new Label("SUBMITTED");
        lsubmit.setBounds(x2-15,y2+8*(g+h1)+30,185,35);
        lsubmit.setFont(fsR);
        add(lsubmit);
        lsubmit.setVisible(false);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource()==submit)
        {
            
            try
            {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/applicatioSystem;create=true;user=KARAN;password=KARAN");    
                String query ="insert into APPLICTIONSYSTEM values(?,?,?,?,?,?,?)";
                PreparedStatement st =con.prepareStatement(query);
                st.setString(1, tname.getText());
                st.setString(2, temail.getText());
                st.setString(3, cg.getSelectedCheckbox().getLabel());
                st.setString(4, tphoneno.getText());
                st.setString(5, cdept.getSelectedItem());
                st.setString(6, tlibcardno.getText());
                st.setString(7, tissuedate.getText());
                st.execute();
                con.close();	
                lsubmit.setVisible(true);
            }
            catch (SQLException e)
            {
                    System.out.println(e);
            } 
            catch (ClassNotFoundException ex) 
            {
                    System.out.println(ex);
            }   
            catch (InstantiationException ex) 
            {   
                            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IllegalAccessException ex) 
            {
                            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
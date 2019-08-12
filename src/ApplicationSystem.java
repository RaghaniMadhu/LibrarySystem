import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ApplicationSystem extends Applet implements ActionListener
{
    Label lheader;
    Button studentinfo,studentregis,library;
    public void init() 
    {
        //APPLET SCREEN
        this.setLayout(null);
        this.setSize(1000,700);
        this.setBackground(Color.LIGHT_GRAY);
        
        //HEADER
        lheader=new Label("V.E.S.I.T.");
        Font f =new Font("serif",Font.BOLD,100);
        lheader.setFont(f);
        lheader.setForeground(Color.red);
        lheader.setBounds(275,5,500,150);
        add(lheader);
        
        //BUTTON FOR STUDENT
        studentregis = new Button("STUDENT INFORMATION");
        studentregis.setBounds(325,250,300,50);
        Font fsr =new Font("serif",Font.BOLD,20);
        studentregis.setBackground(Color.blue);
        studentregis.setForeground(Color.white);
        studentregis.setFont(fsr);
        add(studentregis);
        
        //BUTTON FOR TEACHER
        studentinfo = new Button("STUDENT REGISTRATION");
        studentinfo.setBounds(325,325,300,50);
        studentinfo.setBackground(Color.blue);
        studentinfo.setForeground(Color.white);
        studentinfo.setFont(fsr);
        add(studentinfo);
        
        
        //BUTTON FOR LIBRARIAN
        library = new Button("CALCULATE FINE");
        library.setBounds(325,400,300,50);
        library.setBackground(Color.blue);
        library.setForeground(Color.white);
        library.setFont(fsr);
        add(library);
        
        
        //ACTION
        studentinfo.addActionListener(this);
        studentregis.addActionListener(this);
        library.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==studentregis)
        {
            studentregis.setVisible(false);
            studentinfo.setVisible(false);
            library.setVisible(false);
            teacher();  
        }
        else if (e.getSource()==studentinfo)
        {
            studentregis.setVisible(false);
            studentinfo.setVisible(false);
            library.setVisible(false);
            student();
        }
        else if (e.getSource()==library)
        {
            studentregis.setVisible(false);
            studentinfo.setVisible(false);
            library.setVisible(false);
            library();
        }
    }
    void student()
    {
        Student s = new Student();
        s.setBounds(50,50,900,600);
        s.init();
        add(s);
    }
    void teacher()
    {
        Teacher t = new Teacher();
        t.setBounds(50,50,900,600);
        t.init();
        add(t);
    }
    void library()
    {
        Library l = new Library();
        l.setBounds(50,50,900,600);
        l.init();
        add(l);
    }
}

package org.example;

import org.example.Util.DbConnectionUtil;
import org.example.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class AppUI {
    JFrame frame1 = new JFrame("message");
    JFrame frame2 = new JFrame("message");
    //JLabel lb = new JLabel("ok");

    JFrame frame;
    JTextField txtId,txtFirstName,txtLastName;
    JButton addBtn, btnReset,testBtn,DisBtn;
    JLabel l1,l2,l3,l4,l5,msg,msg1;
    JRadioButton r1,r2;
    ButtonGroup bg;
    JList  <String>  list1;
    JTable jt;
    DbConnectionUtil dbUtil = new DbConnectionUtil();
    
    public AppUI() {

        frame = new JFrame("Swing APP");
        frame.setBounds(20,20,600,300);

        l1=new JLabel("id:");
        l1.setBounds(10,10,100,20);
        txtId = new JTextField();
        txtId.setBounds(110,10,200,20);



         l2=new JLabel("FirstName:");
         l2.setBounds(10,40,100,20);
         txtFirstName = new JTextField();
         txtFirstName.setBounds(110,40,200,20);


        l3=new JLabel("LastName:");
        l3.setBounds(10,70,100,20);
        txtLastName = new JTextField();
        txtLastName.setBounds(110,70,200,20);


         l4=new JLabel("Branch:");
        l4.setBounds(10,100,100,20);
        DefaultListModel<String> branch = new DefaultListModel<>();
        branch.addElement("CS");
        branch.addElement("ENTC");
        branch.addElement("ELEC");
        branch.addElement("MECH");
        list1 = new JList<>(branch);
        list1.setBounds(110,100, 75,75);

        bg=new ButtonGroup();
         l5=new JLabel("Gender:");
        l5.setBounds(10,180,100,20);
       r1=new JRadioButton("A) Male");
       r1.setActionCommand("Male");
         r2=new JRadioButton("B) Female");
        r2.setActionCommand("Female");
         r1.setBounds(80,170,100,30);
        r2.setBounds(80,190,100,30);

        msg=new JLabel();
        msg.setBounds(10,290,200,20);


        //msg1=new JLabel("Information added sucessfully");
        //msg1.setBounds(120,290,100,20);
        testBtn=new JButton("test");
        testBtn.setBounds(20,290,80, 30);
        testBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg.setText("Information added sucessfully");
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                frame1.setBounds((int) (width / 2), (int) height / 2, 500, 100);
                //lb.setBounds(20, 20, 100, 20);
                JDialog jDialogConifrm = new JDialog(frame1, "Message", true);
                //jDialogConifrm.add(msg);
                frame1.add(msg);
                frame1.setVisible(true);
            }
        });
        DisBtn=new JButton("Display");
        DisBtn.setBounds(220,240,80, 30);
        DisBtn.setActionCommand("revertTable");
        DisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = dbUtil.getDbConnection();
                if(con!=null){
                    try{
                    Statement st= con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * from student");

                        while (rs.next()) {
                            students[]rs.getString(1);
                            rs.getString(2);
                            rs.getString(3);
                            rs.getString(4);
                            rs.getString(5);



                        }
                        String column[]={"ID","FNAME","LNAME","GENDER","BRANCH"};
                        //new JTable(column);
                        jt.setBounds(30,40,200,300);
                        JScrollPane sp=new JScrollPane(jt);
                        frame2.add(sp);
                        frame2.setSize(300,400);
                        frame2.setVisible(true);
                        con.close();
                        }catch (SQLException e2){
                        e2.printStackTrace();
                    }

                    }



            }
        });

            addBtn=new JButton("submit");
        addBtn.setBounds(20,240,80, 30);
        addBtn.setActionCommand("add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
//                student.setId(Long.parseLong(txtId.getText()));
                student.setFname(txtFirstName.getText());
                student.setLastName(txtLastName.getText());
                student.setBranch(list1.getSelectedValue());
                student.setGender(bg.getSelection().getActionCommand());
                dbUtil = new DbConnectionUtil();
                Connection con= dbUtil.getDbConnection();
                if (con!=null){
                    try {
                        PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT (fname,lastName,gender,branch) VALUES(?,?,?,?)");
                        {
                            st.setString(1,student.getFname());
                            st.setString(2,student.getLastName());
                            st.setString(3,student.getGender());
                            st.setString(4,student.getBranch());
                            if (st.executeUpdate()==1){
                                msg.setText("Information added sucessfully");
//                                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//                                double width = screenSize.getWidth();
//                                double height = screenSize.getHeight();
//
//                                frame1.setBounds((int) (width / 2), (int) height / 2, 500, 100);
//                                //lb.setBounds(20, 20, 100, 20);
//                                JDialog jDialogConifrm = new JDialog(frame1, "Message", true);
//                                jDialogConifrm.add(msg);
////                                jDialogConifrm.setVisible(true);
//                                frame1.setVisible(true);
                            }

                        }
                        con.close();
                        //resetAllField();
                        }catch (SQLException e2){
                            e2.printStackTrace();
                        }
                }


                //System.out.println(student.getId() + student.getFname()+ student.getLastName()+student.getBranch()+student.getGender());
            }
        });

        btnReset =new JButton("Reset");
        btnReset.setBounds(120,240,80, 30);
        btnReset.setActionCommand("reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAllField();
            }
        });



        bg.add(r1);
        bg.add(r2);
        frame.add(l1);
        frame.add(txtId);
        frame.add(l2);
        frame.add(txtFirstName);
        frame.add(l3);
        frame.add(txtLastName);
        frame.add(l4);
        frame.add(l5);
        frame.add(list1);
        frame.add(r1);
        frame.add(r2);
        frame.add(addBtn);
        frame.add(btnReset);
//        frame.add(testBtn);

        frame.add(msg);
        frame.add(DisBtn);


        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    void resetAllField(){
        txtFirstName.setText("");
        txtId.setText("");
        txtLastName.setText("");
        bg.clearSelection();
        msg.setText("");

    }
}

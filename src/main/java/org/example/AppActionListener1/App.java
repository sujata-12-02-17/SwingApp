package org.example.AppActionListener1;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Swing APP");
        frame.setBounds(20,20,600,300);

        JLabel l1=new JLabel("id:");
        l1.setBounds(10,10,100,20);
        JTextField txtid = new JTextField();
        txtid.setBounds(110,10,200,20);



        JLabel l2=new JLabel("FirstName:");
        l2.setBounds(10,40,100,20);
        JTextField txtFirstName = new JTextField();
        txtFirstName.setBounds(110,40,200,20);


        JLabel l3=new JLabel("LastName:");
        l3.setBounds(10,70,100,20);
        JTextField txtLastName = new JTextField();
        txtLastName.setBounds(110,70,200,20);


        JLabel l4=new JLabel("Branch:");
        l4.setBounds(10,100,100,20);
        DefaultListModel<String> branch = new DefaultListModel<>();
        branch.addElement("CS");
        branch.addElement("ENTC");
        branch.addElement("ELEC");
        branch.addElement("MECH");
         JList<String> list1 = new JList<>(branch);
        list1.setBounds(110,100, 75,75);
        JLabel l5=new JLabel("Gender:");
        l5.setBounds(10,180,100,20);
        JRadioButton r1=new JRadioButton("A) Male");
        JRadioButton r2=new JRadioButton("B) Female");
        r1.setBounds(80,170,100,30);
        r2.setBounds(80,190,100,30);

        ButtonGroup bg=new ButtonGroup();

        JButton addBtn=new JButton("submit");
        addBtn.setBounds(20,240,80, 30);
        addBtn.setActionCommand("add");
        addBtn.addActionListener(new AppActionListener());

        JButton cancelbtn=new JButton("cancel");
        cancelbtn.setBounds(120,240,80, 30);
        cancelbtn.setActionCommand("cancel");
        cancelbtn.addActionListener(new AppActionListener1());

        bg.add(r1);
        bg.add(r2);
        frame.add(l1);
        frame.add(txtid);
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
        frame.add(cancelbtn);


        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}



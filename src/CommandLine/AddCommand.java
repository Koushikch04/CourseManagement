package CommandLine;
import personPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddCommand {
    public static void addStudentGUI(Student student) {
        final JTextField f1 = new JTextField();
        final JTextField f2 = new JTextField();
        final JTextField f3 = new JTextField("YY-MM-DD FORMAT");
        final JTextField f4 = new JTextField();
        final JTextField f5 = new JTextField();

        JFrame f = new JFrame();
        final JDialog fr = new JDialog(f, "Add Student");
        fr.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel();
        l1.setText("Name ");
        l1.setBounds(50,68,108,20);
        l1.setFont(new Font("Serif", Font.PLAIN, 20));
        fr.getContentPane().add(l1);
        l2.setText("Gender ");
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        l2.setBounds(50,100,98,20);
        fr.getContentPane().add(l2);
        l3.setText("DOB ");
        l3.setFont(new Font("Serif", Font.PLAIN, 20));
        l3.setBounds(50,130,122,27);
        fr.getContentPane().add(l3);
        l4.setText("Branch ");
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setBounds(50,167,98,27);
        fr.getContentPane().add(l4);
        l5.setText("Student ID ");
        l5.setFont(new Font("Serif", Font.PLAIN, 20));
        l5.setBounds(50,204,98,27);
        fr.getContentPane().add(l5);
        l6.setText("ENTER THE DETAILS ");
        l6.setFont(new Font("Serif", Font.PLAIN, 20));
        l6.setBounds(69,22,215,27);
        fr.getContentPane().add(l6);
        f1.setBounds(182, 73, 108, 20);
        f2.setBounds(182, 105, 108, 20);
        f3.setBounds(182, 138, 108, 20);
        f4.setBounds(182, 175, 108, 20);
        f5.setBounds(182, 212, 108, 20);

        fr.getContentPane().add(f1, BorderLayout.NORTH);
        fr.getContentPane().add(f2);
        fr.getContentPane().add(f3);
        fr.getContentPane().add(f4);
        fr.getContentPane().add(f5);
        JButton b = new JButton("SUBMIT");
        b.setBounds(118, 263, 122, 33);
        fr.getContentPane().add(b);
        JLabel lab = new JLabel("New label");
        lab.setIcon(new ImageIcon("CommandLine/image.png"));
        lab.setBounds(0, 0, 950, 371);
        fr.getContentPane().add(lab);
        fr.getContentPane().setLayout(null);

        String ans = "true";
        fr.setSize(950,371);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student.setName(f1.getText());
                student.setGender(f2.getText());
                LocalDate dob = LocalDate.parse(f3.getText());
                student.setDob(dob);
                student.setBranch(f4.getText());
                student.setStudID(f5.getText());
                fr.dispose();
            }
        });
        fr.setVisible(true);
    }
    public static void add(String[] args) {
        if(args.length==2) {
            if(args[1].equals("Student")) {

                Student stud = new Student();
                addStudentGUI(stud);
                System.out.println(stud.getName() + " " + stud.getStudID() + " " + stud.getBranch() + " " + stud.getGender() + " " + stud.getDob());
            }
        }
    }
}

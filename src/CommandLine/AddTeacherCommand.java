package CommandLine;

import personPackage.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddTeacherCommand {
    public static void addTeacherGUI(Teacher teacher) {
        final JTextField f1 = new JTextField();
        final JTextField f2 = new JTextField();
        final JTextField f3 = new JTextField("YY-MM-DD FORMAT");
        final JTextField f4 = new JTextField();
        final JTextField f5 = new JTextField();
        final JTextField f6 = new JTextField();
        final JTextField f7 = new JTextField();

        JFrame f = new JFrame();
        final JDialog fr = new JDialog(f, "Add Teacher");
        fr.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel();
        JLabel l7 = new JLabel();
        JLabel l8 = new JLabel();
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
        l4.setText("DeptName ");
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setBounds(50,167,98,27);
        fr.getContentPane().add(l4);
        l5.setText("Teacher ID ");
        l5.setFont(new Font("Serif", Font.PLAIN, 20));
        l5.setBounds(50,204,98,27);
        fr.getContentPane().add(l5);
        l6.setText("Title ");
        l6.setFont(new Font("Serif", Font.PLAIN, 20));
        l6.setBounds(50,240,98,27);
        fr.getContentPane().add(l6);
        l7.setText("Salary ");
        l7.setFont(new Font("Serif", Font.PLAIN, 20));
        l7.setBounds(50,280,98,27);
        fr.getContentPane().add(l7);
        l8.setText("ENTER THE DETAILS ");
        l8.setFont(new Font("Serif", Font.PLAIN, 20));
        l8.setBounds(69,22,215,27);
        fr.getContentPane().add(l8);
        f1.setBounds(182, 73, 150, 20);
        f2.setBounds(182, 105, 150, 20);
        f3.setBounds(182, 138, 150, 20);
        f4.setBounds(182, 175, 150, 20);
        f5.setBounds(182, 212, 150, 20);
        f6.setBounds(182, 250, 150, 20);
        f7.setBounds(182, 290, 150, 20);

        fr.getContentPane().add(f1, BorderLayout.NORTH);
        fr.getContentPane().add(f2);
        fr.getContentPane().add(f3);
        fr.getContentPane().add(f4);
        fr.getContentPane().add(f5);
        fr.getContentPane().add(f6);
        fr.getContentPane().add(f7);
        JButton b = new JButton("SUBMIT");
        b.setBounds(118, 365, 122, 33);
        fr.getContentPane().add(b);
        JLabel lab = new JLabel("New label");
        lab.setIcon(new ImageIcon("src/CommandLine/image.png"));
        lab.setBounds(0, -50, 950, 450);
        fr.getContentPane().add(lab);
        fr.getContentPane().setLayout(null);
        fr.setSize(950,450);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacher.setName(f1.getText());
                teacher.setGender(f2.getText());
                LocalDate dob = LocalDate.parse(f3.getText());
                teacher.setDob(dob);
                teacher.setDepartmentName(f4.getText());
                teacher.setTeacherID(f5.getText());
                teacher.setTitle(f6.getText());
                teacher.setSalary(Double.parseDouble(f7.getText()));
                fr.dispose();
            }
        });
        fr.setVisible(true);
    }
    public static void add(String[] args) {
        if(args.length==2) {
            Teacher teacher = new Teacher();
            addTeacherGUI(teacher);

            try {
                Teacher.addTeacher(teacher);

            } catch (Exception e) {
                System.out.println("Couldn't add the student!");
            }
            System.exit(0);
        }
    }
}

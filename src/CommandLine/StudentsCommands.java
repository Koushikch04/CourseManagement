package CommandLine;
import personPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class StudentsCommands {
    private static void addStudentGUI(Student student) {
        final JTextField f1 = new JTextField();
        final JTextField f3 = new JTextField("YY-MM-DD FORMAT");
        final JTextField f5 = new JTextField();

        final JFrame f= new JFrame();
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
        f1.setBounds(182, 73, 150, 20);
        f3.setBounds(182, 138, 150, 20);
        f5.setBounds(182, 212, 150, 20);

        fr.getContentPane().add(f1, BorderLayout.NORTH);
        fr.getContentPane().add(f3);
        fr.getContentPane().add(f5);
        JButton b = new JButton("SUBMIT");
        b.setBounds(118, 263, 122, 33);
        fr.getContentPane().add(b);

        fr.getContentPane().setLayout(null);

        final JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBounds(181, 104, 59, 21);
        fr.getContentPane().add(rdbtnNewRadioButton);


        final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
        rdbtnNewRadioButton_1.setBounds(250, 104, 71, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1);

        final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("CSE");
        rdbtnNewRadioButton_2.setBounds(182, 174, 58, 20);
        fr.getContentPane().add(rdbtnNewRadioButton_2);

        final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("ECE");
        rdbtnNewRadioButton_3.setBounds(250, 174, 71, 20);
        fr.getContentPane().add(rdbtnNewRadioButton_3);

        final JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Other");
        rdbtnNewRadioButton_4.setBounds(323, 104, 103, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_4);

        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }

        });
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }

        });
        rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton.setSelected(false);
            }

        });
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_3.setSelected(false);
            }

        });
        rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_2.setSelected(false);
            }

        });
        JLabel lab = new JLabel("New label");
        lab.setIcon(new ImageIcon("CommandLine/image.png"));
        lab.setBounds(0, 0, 950, 371);
        fr.getContentPane().add(lab);

        fr.setSize(950,371);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student.setName(f1.getText());
                if (rdbtnNewRadioButton.isSelected()) {
                    student.setGender("Male");
                }
                else if (rdbtnNewRadioButton_1.isSelected()){
                    student.setGender("Female");
                }
                if (rdbtnNewRadioButton_2.isSelected()) {
                    student.setBranch("CSE");
                }
                else if (rdbtnNewRadioButton_3.isSelected()) {
                    student.setBranch("ECE");
                }


                LocalDate dob = LocalDate.parse(f3.getText());
                student.setDob(dob);

                student.setStudID(f5.getText());
                fr.dispose();
            }
        });
        fr.setVisible(true);
    }
    private static void add(String[] args) {
        if(args.length==2) {
            Student stud = new Student();
            addStudentGUI(stud);

            try {
                Student.addStudent(stud);

            } catch (Exception e) {
                System.out.println(e);
            }
            System.exit(0);
        } else if(args.length==3) {
            try {
                Student.addStudents(args[2]);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void connect(String args[]) {
        if (args[0].equals("-add")) {
            add(args);
        } else if (args[0].equals("-details")) {
            if (args.length == 4) {
                if (args[3].equals("studId")) {
                    try {
                        Student.Sort("studId",1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if(args[3].equals("deptName")) {
                    try {
                        Student.Sort("deptName",0);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } else if(args[0].equals("-search")) {
            if(args[2].equals("studId")) {
                try {
                    Student.Search("studId",args[3]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if(args[2].equals("name")) {
                String tempName = args[3];
                if(args.length>4) {
                    int n = args.length;
                    for(int i = 4; i<n; i++) tempName = tempName + " " + args[i];
                }
                try {
                    Student.Search("name",args[4]);
                                    } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if(args[0].equals("-rmv")) {
            if(args.length==2) {
                try {
                    Student.removeStudents();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                try {
                    Student.removeStudent(args[2]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

}

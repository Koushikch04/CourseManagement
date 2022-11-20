package CommandLine;

import AdditionalComponents.Date;
import AdditionalComponents.Login;
import personPackage.Admin;
import personPackage.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class TeachersCommands {
    public static void addTeacherGUI(Teacher teacher) {
        final JTextField f1 = new JTextField();
        final JTextField f3 = new JTextField("YYYY-MM-DD");
        final JTextField f5 = new JTextField();
        final JTextField f6 = new JTextField();
        final JTextField f7 = new JTextField();

        final JFrame f = new JFrame();
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
        l6.setFont(new Font("Serif", Font.PLAIN,
                20));
        l6.setBounds(50,245,98,27);
        fr.getContentPane().add(l6);
        l7.setText("Salary ");
        l7.setFont(new Font("Serif", Font.PLAIN, 20));
        l7.setBounds(50,285,98,27);
        fr.getContentPane().add(l7);
        l8.setText("ENTER THE DETAILS ");
        l8.setFont(new Font("Serif", Font.PLAIN, 20));
        l8.setBounds(69,22,215,27);
        fr.getContentPane().add(l8);
        f1.setBounds(182, 73, 161, 20);
        f3.setBounds(182, 138, 161, 20);
        f5.setBounds(182, 212, 161, 20);
        f6.setBounds(182, 250, 161, 20);
        f7.setBounds(182, 290, 161, 20);

        fr.getContentPane().add(f1, BorderLayout.NORTH);
        fr.getContentPane().add(f3);
        fr.getContentPane().add(f5);
        fr.getContentPane().add(f6);
        fr.getContentPane().add(f7);
        JButton b = new JButton("SUBMIT");
        b.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b.setBounds(118, 333, 122, 33);
        fr.getContentPane().add(b);
        final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
        rdbtnNewRadioButton_1.setBounds(243, 104, 82, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1);
        fr.setSize(950,450);


        final JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Male");
        rdbtnNewRadioButton_1_1.setBounds(181, 104, 60, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1_1);


        final JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Other");
        rdbtnNewRadioButton_1_2.setBounds(327, 104, 60, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1_2);


        final JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("CSE");
        rdbtnNewRadioButton_1_1_1.setBounds(182, 174, 69, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1_1_1);

        final JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("ECE");
        rdbtnNewRadioButton_1_3.setBounds(253, 174, 82, 21);
        fr.getContentPane().add(rdbtnNewRadioButton_1_3);

        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1_1.setSelected(false);
                rdbtnNewRadioButton_1_2.setSelected(false);
            }

        });
        rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_1_2.setSelected(false);
            }

        });
        rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_1_1.setSelected(false);
            }

        });
        rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1_3.setSelected(false);
            }

        });
        rdbtnNewRadioButton_1_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                rdbtnNewRadioButton_1_1_1.setSelected(false);
            }

        });



        JLabel lab = new JLabel("new label");
        lab.setIcon(new ImageIcon("CommandLine/teacher.jpeg"));
        lab.setBounds(10, 0, 926, 413);
        fr.getContentPane().add(lab);
        fr.getContentPane().setLayout(null);



        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacher.setName(f1.getText());
                if (rdbtnNewRadioButton_1_1.isSelected()) {
                    teacher.setGender("Male");
                }
                else if (rdbtnNewRadioButton_1.isSelected()){
                    teacher.setGender("Female");
                } else if(rdbtnNewRadioButton_1_2.isSelected()) {
                    teacher.setGender("Other");
                }
                if (rdbtnNewRadioButton_1_1_1.isSelected()) {
                    teacher.setDepartmentName("CSE");
                }
                else if (rdbtnNewRadioButton_1_3.isSelected()) {
                    teacher.setDepartmentName("ECE");
                }
                LocalDate dob = LocalDate.parse(f3.getText());
                teacher.setDob(new Date(dob.getYear(),(short)dob.getMonthValue(),(short)dob.getDayOfMonth()));
                teacher.setTeacherID(f5.getText());
                teacher.setTitle(f6.getText());
                teacher.setSalary(Double.parseDouble(f7.getText()));
                fr.dispose();
            }
        });
        fr.setVisible(true);
    }

    private static void printTeacherDetails(ArrayList<Teacher> s) {
        JFrame f = new JFrame("Teacher DETAILS");
        JLabel lblNewLabel = new JLabel("Teacher DETAILS");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 27));
        lblNewLabel.setBounds(205, 10, 536, 66);

        f=new JFrame("                                                        TEACHER DETAILS");
        int n = s.size();
        String data[][]= new String[n][7];
        for(int i = 0; i<n; i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = s.get(i).getTeacherID();
            data[i][2] = s.get(i).getName();
            data[i][3] = s.get(i).getDepartmentName();
            data[i][4] = s.get(i).getDob().toString();
            data[i][5] = s.get(i).getGender();
            data[i][6] = Double.toString(s.get(i).getSalary());
        }
        int si = 470;
        String column[]={"S. NO","TEACHER_ID","NAME","DEPT_NAME","DOB","GENDER","SALARY"};
        JTable jt=new JTable(data,column);
        jt.setBounds(230,100,800,si);
        jt.getColumnModel().getColumn(0).setPreferredWidth(50);
        jt.getColumnModel().getColumn(2).setPreferredWidth(200);
        jt.getColumnModel().getColumn(3).setPreferredWidth(80);
        jt.getColumnModel().getColumn(4).setPreferredWidth(80);
        jt.getColumnModel().getColumn(5).setPreferredWidth(100);
        jt.getColumnModel().getColumn(6).setPreferredWidth(100);
        JScrollPane sp=new JScrollPane(jt);
        f.getContentPane().add(sp, BorderLayout.NORTH);
        f.setBounds(230,100,800,si);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
    private static void add(String[] args) {
        String values[] = new String[2];
        Login.log("Admin", values);
        int x = Admin.authentication(values[0], values[1]);
        if (x == 1) {
            if (args.length == 2) {
                Teacher teacher = new Teacher();
                addTeacherGUI(teacher);

                try {
                    Teacher.addTeacher(teacher);

                } catch (Exception e) {
                    System.out.println(e);
                }
                System.exit(0);
            } else {
                try {
                    Teacher.addTeachers(args[2]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            System.out.println("Error");
        }
        System.exit(0);
    }

    public static void connect(String args[]) {
        String values[] = new String[2];
        if(args[0].equals("-add")) {
            add(args);
        } else if(args[0].equals("-rmv")) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                if (args.length == 3) {
                    try {
                        Teacher.removeTeacher(args[2]);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    try {
                        Teacher.removeTeachers();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                System.out.println("Error");
            }
            System.exit(0);
        } else if(args[0].equals("-sort") || args[0].equals("-details")) {
            int x = 0;
            if(args.length > 3 && args[3].equals("desc")) x=1;
            try {
                ArrayList<Teacher> teachers;
                if(args[0].equals("-details")) {
                    teachers = Teacher.Sort("teacherId", 0);
                } else {
                    teachers = Teacher.Sort(args[2], x);
                }
                printTeacherDetails(teachers);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(args[0].equals("-search")) {
            try {
                ArrayList<Teacher> teachers = Teacher.Search(args[2], args[3]);
                printTeacherDetails(teachers);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(args[0].equals("-update")) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                try {
                    Teacher.update(args[2], args[3], args[4]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Error");
            }
            System.exit(0);
        }
    }
}

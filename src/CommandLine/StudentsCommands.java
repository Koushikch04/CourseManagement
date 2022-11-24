package CommandLine;
import AdditionalComponents.Error;
import AdditionalComponents.Login;
import AdditionalComponents.Message;
import com.mysql.cj.x.protobuf.Mysqlx;
import personPackage.*;
import AdditionalComponents.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.io.FileNotFoundException;
import java.security.spec.ECField;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentsCommands {
    private static void addStudentGUI(Student student) {
        final JTextField f1 = new JTextField();
        final JTextField f3 = new JTextField("YYYY-MM-DD");
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
        l2.setBounds(50,104,98,20);
        fr.getContentPane().add(l2);
        l3.setText("DOB ");
        l3.setFont(new Font("Serif", Font.PLAIN, 20));
        l3.setBounds(50,158,122,27);
        fr.getContentPane().add(l3);
        l4.setText("Branch ");
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setBounds(50,195,98,27);
        fr.getContentPane().add(l4);
        l5.setText("Student ID ");
        l5.setFont(new Font("Serif", Font.PLAIN, 20));
        l5.setBounds(50,232,98,27);
        fr.getContentPane().add(l5);
        l6.setText("ENTER THE DETAILS ");
        l6.setFont(new Font("Serif", Font.PLAIN, 20));
        l6.setBounds(69,22,215,27);
        fr.getContentPane().add(l6);
        f1.setBounds(182, 68, 150, 25);
        f3.setBounds(182, 158, 150, 29);
        f5.setBounds(182, 233, 150, 27);

        fr.getContentPane().add(f1, BorderLayout.NORTH);
        fr.getContentPane().add(f3);
        fr.getContentPane().add(f5);
        JButton b = new JButton("SUBMIT");
        b.setBounds(118, 277, 122, 33);
        fr.getContentPane().add(b);

        fr.getContentPane().setLayout(null);

        final JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBounds(181, 98, 71, 28);
        fr.getContentPane().add(rdbtnNewRadioButton);


        final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
        rdbtnNewRadioButton_1.setBounds(181, 119, 77, 29);
        fr.getContentPane().add(rdbtnNewRadioButton_1);

        final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("CSE");
        rdbtnNewRadioButton_2.setBounds(182, 202, 70, 20);
        fr.getContentPane().add(rdbtnNewRadioButton_2);

        final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("ECE");
        rdbtnNewRadioButton_3.setBounds(250, 202, 82, 20);
        fr.getContentPane().add(rdbtnNewRadioButton_3);

        final JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Other");
        rdbtnNewRadioButton_4.setBounds(250, 98, 82, 27);
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
        lab.setBounds(0, 0, 950, 334);
        fr.getContentPane().add(lab);

        fr.setSize(950,371);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student.setName(f1.getText());
                System.out.println(student.getName());
                if (rdbtnNewRadioButton.isSelected()) {
                    student.setGender("Male");
                }
                else if (rdbtnNewRadioButton_1.isSelected()){
                    student.setGender("Female");
                } else if(rdbtnNewRadioButton_4.isSelected()) {
                    student.setGender("Other");
                }
                if (rdbtnNewRadioButton_2.isSelected()) {
                    student.setBranch("CSE");
                }
                else if (rdbtnNewRadioButton_3.isSelected()) {
                    student.setBranch("ECE");
                }
                try {
                    LocalDate dob = LocalDate.parse(f3.getText());
                    student.setDob(new Date(dob.getYear(), (short) dob.getMonthValue(), (short) dob.getDayOfMonth()));
                } catch (Exception error) {
                    Error.dateError();
                }

                student.setStudID(f5.getText());
                fr.dispose();
            }
        });
        fr.setVisible(true);
    }

    public static void printStudentDetails(ArrayList<Student> s) {
        JFrame f = new JFrame("STUDENT DETAILS");
        JLabel lblNewLabel = new JLabel("STUDENT DETAILS");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 27));
        lblNewLabel.setBounds(205, 10, 536, 66);

        f=new JFrame("                                                        STUDENT DETAILS");
        int n = s.size();
        String data[][]= new String[n][6];
        for(int i = 0; i<n; i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = s.get(i).getStudID();
            data[i][2] = s.get(i).getName();
            data[i][3] = s.get(i).getBranch();
            data[i][4] = s.get(i).getDob().toString();
            data[i][5] = s.get(i).getGender();

        }
        int si = 470;
        String column[]={"S. NO","STUDENT_ID","NAME","DEPT_NAME","DOB","GENDER"};
        JTable jt=new JTable(data,column);
        jt.setBounds(230,100,800,si);
        jt.getColumnModel().getColumn(0).setMaxWidth(50);

        jt.getColumnModel().getColumn(2).setPreferredWidth(250);
        jt.getColumnModel().getColumn(3).setMaxWidth(100);
        jt.getColumnModel().getColumn(4).setPreferredWidth(30);
        jt.getColumnModel().getColumn(5).setMaxWidth(100);
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
                Student stud = new Student();
                addStudentGUI(stud);
                try {
                    Student.addStudent(stud);
                } catch (Exception e) {
                    Error.allFields();
                }
            } else if (args.length == 3) {
                try {
                    Student.addStudents(args[2]);
                } catch (Exception e) {
                    Error.DuplicateEntry();
                }
            }
            Message.added();
        } else {
            Error.loginFailed();
        }
    }

    public static void connect(String args[]) throws SQLException, FileNotFoundException {
        String values[] = new String[2];

        if (args[0].equals("-add")) {
            add(args);
        } else if(args[0].equals("-rmv")) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                if (args.length == 2) {
                    try {
                        Student.removeStudents();
                    } catch (Exception e) {
                        Error.unexpectedError();
                    }
                } else {
                    try {
                        Student.removeStudent(args[2]);
                    } catch (Exception e) {
                        Error.unexpectedError();
                    }
                }
                Message.removed();
            } else {
                Error.loginFailed();
            }
        } else if(args[0].equals("-sort") || args[0].equals("-details")) {
            int x =-1;
            if(args.length > 3 && args[3].equals("desc")) x=1;
            else if(args.length >3 &&args[3].equals("asc")) x=0;


            try {
                ArrayList<Student> students;
                if(args[0].equals("-details")) {
                    students = Student.Sort("studId", 0);
                } else {
                    if(x==-1) Error.errorMsg("Invalid Arguments for the order of sorting");
                    students = Student.Sort(args[2], x);
                }
                if(students.size()==0) Message.noRecords();
                printStudentDetails(students);
            } catch (Exception e) {
                Error.unexpectedError();
            }
        } else if(args[0].equals("-search")) {
            try {
                int l=4;
                String temp = args[3];
                while(l<args.length){
                    temp+=" "+args[l];
                    l++;
                }
                ArrayList<Student> students = Student.Search(args[2], temp);
                if(students.size()==0) Message.noRecords();
                printStudentDetails(students);
            } catch (Exception e) {
                Message.noRecords();
            }
        } else if(args[0].equals("-update") && args.length==3) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                try {
                    Student.updateViaCSV(args[2]);
                } catch (Exception e) {
                    Error.unexpectedError();
                }
                Message.updated();
            } else {
                Error.loginFailed();
            }
        } else if(args[0].equals("-update")) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                try {
                    Student.update(args[2], args[3], args[4]);
                } catch (Exception e) {
                    Error.unexpectedError();
                }
                Message.updated();
            } else {
                Error.loginFailed();
            }
        } else if(args[0].equals("-partialSearch")) {
            try {
                ArrayList<Student> students = Student.partialSearch(args[2],args[3]);
                if(students.size()==0) Message.noRecords();
                printStudentDetails(students);
            } catch(Exception e) {
                Error.errorMsg("Unexpected error occured!");
            }
        }
        else Error.errorMsg("Invalid arguments");

    }
}

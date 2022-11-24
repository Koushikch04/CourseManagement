package CommandLine;

import AdditionalComponents.*;
import AdditionalComponents.Error;
import Courses.*;
import personPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;

public class CoursesCommand {
    public static void addCourseGUI(courses course) {
        final JFrame f = new JFrame();
        final JDialog fr = new JDialog(f, "Add Course");
        fr.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JLabel jl = new JLabel("ADD COURSE");
        jl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jl.setBounds(107, 10, 113, 38);
        fr.getContentPane().add(jl);

        fr.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("COURSE ID ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(42, 52, 105, 27);
        fr.getContentPane().add(lblNewLabel);

        JLabel lblCourseName = new JLabel("COURSE NAME");
        lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseName.setBounds(42, 82, 105, 27);
        fr.getContentPane().add(lblCourseName);
        JLabel lblCourseabbr = new JLabel("COURSE ABBR.");
        lblCourseabbr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseabbr.setBounds(42, 119, 105, 27);
        fr.getContentPane().add(lblCourseabbr);

        JLabel lblNewLabel_1 = new JLabel("BRANCH");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(42, 152, 105, 27);
        fr.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("TEACHER ID");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(42, 215, 105, 27);
        fr.getContentPane().add(lblNewLabel_1_1);

        final JTextField textField = new JTextField();
        textField.setBounds(177, 52, 127, 19);
        fr.getContentPane().add(textField);
        textField.setColumns(10);

        final JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(177, 88, 127, 19);
        fr.getContentPane().add(textField_1);

        final JTextField textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(177, 221, 127, 19);
        fr.getContentPane().add(textField_3);

        final JRadioButton rdbtnNewRadioButton = new JRadioButton("CSE");
        rdbtnNewRadioButton.setBounds(177, 154, 63, 21);
        fr.getContentPane().add(rdbtnNewRadioButton);

        final JRadioButton rdbtnEce = new JRadioButton("ECE");
        rdbtnEce.setBounds(241, 154, 63, 21);
        fr.getContentPane().add(rdbtnEce);
        final JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(177, 125, 127, 19);
        fr.getContentPane().add(textField_2);


        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnEce.setSelected(false);

            }

        });
        rdbtnEce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);


            }

        });
        JLabel lblNewLabel_1_1_1 = new JLabel("CREDIT");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(42, 186, 105, 27);
        fr.getContentPane().add(lblNewLabel_1_1_1);
        final JTextField textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(177, 189, 127, 19);
        fr.getContentPane().add(textField_4);


        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                course.setCourseId(textField.getText());
                course.setTitle(textField_1.getText());
                course.setAbbreviation(textField_2.getText());
                course.setInstructorId(textField_3.getText());
                course.setCredits(Integer.parseInt(textField_4.getText()));
                if (rdbtnNewRadioButton.isSelected()) {
                    course.setDeptName("CSE");

                }
                if (rdbtnEce.isSelected()) {
                    course.setDeptName("ECE");

                }
                fr.dispose();
            }
        });
        fr.getContentPane().add(btnNewButton);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(107, 252, 113, 32);
        JLabel lab = new JLabel("New label");
        lab.setIcon(new ImageIcon("CommandLine/course.jpeg"));
        lab.setBounds(0, -12, 766, 306);
        fr.getContentPane().add(lab);
        fr.setSize(780, 331);

        fr.setVisible(true);
    }

    private static void printCoursesDetails(ArrayList<courses> s) {
        JFrame f = new JFrame("STUDENT DETAILS");
        JLabel lblNewLabel = new JLabel("Courses DETAILS");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 27));
        lblNewLabel.setBounds(205, 10, 536, 66);

        f=new JFrame("                                                        Courses DETAILS");
        int n = s.size();
        String data[][]= new String[n][7];
        for(int i = 0; i<n; i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = s.get(i).getCourseId();
            data[i][2] = s.get(i).getAbbreviation();
            data[i][3] = s.get(i).getTitle();
            data[i][4] = s.get(i).getDeptName();
            data[i][5] = s.get(i).getInstructorId();
            data[i][6] = Integer.toString(s.get(i).getCredits());

        }
        int si = 470;
        String column[]={"S. NO","Course_ID","Abbr.","TITLE","DEPT_NAME","INSTRUCTOR_ID","CREDITS"};
        JTable jt=new JTable(data,column);
        jt.setBounds(230,100,800,si);
        jt.getColumnModel().getColumn(0).setMaxWidth(50);

        jt.getColumnModel().getColumn(3).setPreferredWidth(300);
        jt.getColumnModel().getColumn(2).setPreferredWidth(100);
        jt.getColumnModel().getColumn(4).setPreferredWidth(30);
        jt.getColumnModel().getColumn(5).setPreferredWidth(100);
        jt.getColumnModel().getColumn(6).setPreferredWidth(70);
        JScrollPane sp=new JScrollPane(jt);
        f.getContentPane().add(sp, BorderLayout.NORTH);
        f.setBounds(230,100,800,si);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static void printCourses(ArrayList<courses> s) {
        JFrame f = new JFrame("STUDENT DETAILS");
        JLabel lblNewLabel = new JLabel("Courses taken by the Student");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 27));
        lblNewLabel.setBounds(205, 10, 536, 66);

        f=new JFrame("                   Courses taken by the Student");
        int n = s.size();
        String data[][]= new String[n][6];
        for(int i = 0; i<n; i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = s.get(i).getCourseId();
            data[i][2] = s.get(i).getAbbreviation();
            data[i][3] = s.get(i).getTitle();
            data[i][4] = s.get(i).getInstructorId();
            data[i][5] = Integer.toString(s.get(i).getCredits());

        }
        int si = 470;
        String column[]={"S. NO","Course_ID","Abbr.","TITLE","INSTRUCTOR_ID","CREDITS"};
        JTable jt=new JTable(data,column);
        jt.setBounds(230,100,700,si);
        jt.getColumnModel().getColumn(0).setMaxWidth(50);

        jt.getColumnModel().getColumn(3).setPreferredWidth(300);
        jt.getColumnModel().getColumn(2).setPreferredWidth(100);
        jt.getColumnModel().getColumn(4).setPreferredWidth(100);
        jt.getColumnModel().getColumn(5).setPreferredWidth(70);
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
                courses course = new courses();
                addCourseGUI(course);
                try {
                    courses.addCourse(course);
                } catch (Exception e) {
                    Error.allFields();
                }
            } else {
                try {
                    courses.addCourses(args[2]);
                } catch (Exception e) {
                    Error.errorMsg("File name is not correct!");
                }
            }
            Message.added();
        } else {
            Error.loginFailed();
        }
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
                        courses.removeCourse(args[2]);
                    } catch (Exception e) {
                        Error.unexpectedError();
                    }
                } else {
                    try {
                        courses.removeAllCourses();
                    } catch (Exception e) {
                        Error.unexpectedError();
                    }
                }
                Message.removed();
            } else {
                Error.loginFailed();
            }
            System.exit(0);
        } else if(args[0].equals("-sort") || args[0].equals("-details")) {
            int x = -1;
            if(args.length > 3 && args[3].equals("desc")) x=1;
            else if(args.length >3 &&args[3].equals("asc")) x=0;

            try {
                ArrayList<courses> course;
                if(args[0].equals("-details")) {
                    course = courses.Sort("courseId", 0);
                } else {
                    if(x==-1) Error.errorMsg("Invalid Arguments for the order of sorting");
                    course = courses.Sort(args[2], x);
                }
                if(course.size()==0) Message.noRecords();
                printCoursesDetails(course);
            } catch (Exception e) {
                Error.unexpectedError();
            }
        } else if(args[0].equals("-search")) {
            try {
                ArrayList<courses> course = courses.Search(args[2], args[3]);
                if(course.size()==0) Message.noRecords();
                printCoursesDetails(course);
            } catch (Exception e) {
                Error.unexpectedError();
            }
        } else if(args[0].equals("-update") && args.length==3) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if (x == 1) {
                try {
                    courses.updateViaCsv(args[2]);
                } catch (Exception e) {
                    Error.unexpectedError();
                }
                Message.updated();
            } else {
                Error.loginFailed();
            }
        }
        else if(args[0].equals("-update")) {
            Login.log("Admin", values);
            int x = Admin.authentication(values[0], values[1]);
            if(x==1) {
                try {
                    courses.update(args[2], args[3], args[4]);
                } catch (Exception e) {
                    Error.unexpectedError();
                }
                Message.updated();
            } else {
                Error.loginFailed();
            }
        } else if(args[0].equals("-partialSearch")) {
            try {
                ArrayList<courses> course = courses.partialSearch(args[2],args[3]);
                if(course.size()==0) Message.noRecords();
                printCoursesDetails(course);
            } catch(Exception e) {
                Error.unexpectedError();
            }
        } else if(args[0].equals("-numericSearch")) {
            try {
                ArrayList<courses> course = courses.numericSearch(args[2],args[4],args[3]);
                if(course.size()==0) Message.noRecords();
                printCoursesDetails(course);
            } catch (Exception e) {
                Error.unexpectedError();
            }
        } else if(args[0].equals("-student")) {
            try {
                ArrayList<courses> course = Student.studentCourses(args[2]);
                if(course.size()==0) Message.noRecords();
                printCourses(course);
            } catch(Exception e) {
                Error.unexpectedError();
            }
        }
    }
}

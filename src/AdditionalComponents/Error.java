package AdditionalComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.PreparedStatement;

public class Error {
    public static void errorMsg(String s) {
        final JFrame f = new JFrame("  ERROR 404");
        final JDialog fr = new JDialog(f, "                        ERROR ");
        fr.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JLabel l = new  JLabel(s,  SwingConstants.CENTER);
        l.setBounds(40,44,401,30);
        fr.getContentPane().add(l);
        fr.setSize(513,169);
        fr.getContentPane().setLayout(null);
        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton.setBounds(204, 84, 85, 21);
        fr.getContentPane().add(btnNewButton);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }

    public static void loginFailed() {
        errorMsg("INVALID USERNAME OR PASSWORD!");
    }

    public static void dateError() {
        errorMsg("INVALID DATE FORMAT!");
    }

    public static void doubleError() {
        errorMsg("PLEASE ENTER SALARY IN NUMERICAL VALUE!");
    }

    public static void allFields() {
        errorMsg("ALL FIELDS VALUES ARE REQUIRED!");
    }

    public static void unexpectedError() {errorMsg("Unexpected Error Occurred!");}

    public static void DuplicateEntry(){
        errorMsg("Duplicate entry Already Present or All Field values are not filled");
    }
}

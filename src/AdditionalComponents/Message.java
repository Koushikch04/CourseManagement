package AdditionalComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message {
    public static void message(String s) {
        final JFrame f = new JFrame("  Message");
        final JDialog fr = new JDialog(f, "                        Message ");
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

    public static void updated() {
        message("RECORDS UPDATED SUCCESSFULLY!");
    }

    public static void added() {
        message("RECORDS ADDED SUCCESSFULLY!");
    }
    public static void removed() {
        message("RECORDS REMOVED SUCCESSFULLY!");
    }

    public static void noRecords() {
        message("NO RECORDS FOUND!");
    }
}

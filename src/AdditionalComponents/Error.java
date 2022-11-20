package AdditionalComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                fr.dispose();
            }
        });
        btnNewButton.setBounds(204, 84, 85, 21);
        fr.getContentPane().add(btnNewButton);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }

    public static void loginFailed() {
        errorMsg("INVALID USERNAME PASSWORD");
    }

}

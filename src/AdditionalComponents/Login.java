package AdditionalComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void log(String name, String values[]) {
        final JFrame f = new JFrame();
        final JDialog fr = new JDialog(f, name + " login");
        fr.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);


        fr.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("USERNAME");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(39, 86, 92, 27);
        fr.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(39, 136, 92, 27);
        fr.getContentPane().add(lblNewLabel_1);

        final JTextField textField = new JTextField();
        textField.setBounds(141, 86, 146, 25);
        fr.getContentPane().add(textField);
        textField.setColumns(10);

        final JPasswordField textfield_p = new JPasswordField();
        textfield_p.setColumns(10);
        textfield_p.setBounds(141, 139, 146, 25);
        fr.getContentPane().add(textfield_p);

        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                values[0] = textField.getText();
                char passs[] = textfield_p.getPassword();
                values[1] = String.copyValueOf(passs);
//                System.out.print(user + pass);
                fr.dispose();
//                System.exit(0);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(90, 196, 116, 37);
        fr.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("ENTER DETAILS");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblNewLabel_2.setBounds(91, 25, 153, 27);
        fr.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("AdditionalComponents/auth.jpeg"));
        lblNewLabel_3.setBounds(293, 20, 234, 234);
        fr.getContentPane().add(lblNewLabel_3);
        fr.setLocationRelativeTo(null);
        fr.setSize(541,330);
        //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}

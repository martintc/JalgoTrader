package dev.toddmartin.Jalgo.ui.gui;

import dev.toddmartin.Jalgo.ui.ConfCreator;
import dev.toddmartin.Jalgo.Configuration;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiConfCreator implements ConfCreator, ActionListener {

    private JTextField apiKeyTextField;
    private JTextField secretKeyTextField;

    public void newConfFile () {
        GridLayout gl = new GridLayout(3, 2);
        JDialog diag = new JDialog();
        JLabel apiKeyLabel = new JLabel("api key");
        JLabel secretyKeyLabel = new JLabel("secret key");
        apiKeyTextField = new JTextField();
        secretKeyTextField = new JTextField();
        JButton submitButton = new JButton("Submit");

        diag.setLayout(gl);
        diag.add(apiKeyLabel);
        diag.add(apiKeyTextField);
        diag.add(secretyKeyLabel);
        diag.add(secretKeyTextField);
        diag.add(submitButton);

        submitButton.addActionListener(this);

        diag.setSize(250, 250);
        diag.show();
    }

    public void actionPerformed (ActionEvent e) {
        String apiKey = apiKeyTextField.getText();
        String secretKey = secretKeyTextField.getText();
        Configuration.createConfFile(apiKey, secretKey);
        // this.dispose();
    }

}

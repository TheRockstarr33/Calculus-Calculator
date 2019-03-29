package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FunctionView implements ActionListener {

    Polynomial function;

    JPanel panel;
    JTextField functionTextField;
    JLabel functionDisplayLabel;
    JButton updateFunctionButton;

    public FunctionView(Polynomial function) {
        this.function = function;
        initFunctionViewSwing();
    }

    protected void initFunctionViewSwing() {
        panel = new JPanel();
        panel.setMinimumSize(new Dimension(300, 300));

        functionTextField = new JTextField("Enter a function...");
        functionTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (functionTextField.getText().equals("Enter a function...")) {
                    functionTextField.setText("");
                    functionTextField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (functionTextField.getText().isEmpty()) {
                    functionTextField.setForeground(Color.GRAY);
                    functionTextField.setText("Enter a function...");
                }
            }
        });
        //TODO: Try not to hard-code this in the future
        functionTextField.setBounds(40, 150, 200, 30);

        //Make this nicer later, add a handler for updating
        functionDisplayLabel = new JLabel("f(x) = " + function.toString());
        functionDisplayLabel.setBounds(40, 50, 200, 40);

        updateFunctionButton = new JButton("Update function");
        updateFunctionButton.setBounds(260, 150, 50, 30);

        panel.add(functionTextField);
        panel.add(functionDisplayLabel);
        panel.add(updateFunctionButton);

        panel.setVisible(true);
    }

    //For setting from the program
    void setFunctionDisplayLabel(Polynomial polynomial) {
        this.functionDisplayLabel.setText("f(x) = " + polynomial.toString());
    }

    //For setting from the user
    void setFunctionDisplayLabel(String s) {
        if(s.startsWith("f(x) = ")) {
            s.replaceAll("f(x) = ", "");
        }
        if(s.startsWith("f(x)=")) {
            s.replaceAll("f(x)=", "");
        }
        this.functionDisplayLabel.setText("f(x) = " + s);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateFunctionButton) {
            setFunctionDisplayLabel(functionTextField.getText());
        }
    }
}

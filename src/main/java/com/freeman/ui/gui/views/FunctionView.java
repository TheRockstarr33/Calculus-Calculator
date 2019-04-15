package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FunctionView extends View {

    Polynomial function;

    JPanel panel;
    JTextField functionTextField;
    JLabel functionDisplayLabel;
    JButton updateFunctionButton;

    final private int WIDTH = 500;
    final private int HEIGHT = 650;

    public FunctionView() {

    }

    public FunctionView(Polynomial function) {
        this.function = function;
        initFunctionViewSwing();
    }

    protected void initFunctionViewSwing() {
        panel = new JPanel();
        //Possibly try using GroupLayout?
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 300));  //Necessary???

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

        //Make this nicer later, add a handler for updating
        functionDisplayLabel = new JLabel("f(x) = " + function.toString());
        functionDisplayLabel.setBounds(200, 20, 200, 40);
        functionDisplayLabel.setSize(200, 40);

        //TODO: Try not to hard-code this in the future
        functionTextField.setBounds(40, 80, 200, 25);
        functionTextField.setColumns(15);
        functionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(e.equals())
            }
        });



        updateFunctionButton = new JButton("Update function");
        updateFunctionButton.setBounds(260, 80, 175, 25);
        updateFunctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFunctionDisplayLabel(functionTextField.getText());
            }
        });

        panel.add(functionDisplayLabel);
        panel.add(functionTextField);
        panel.add(updateFunctionButton);

        panel.setVisible(true);
    }

    public Polynomial getFunction() {
        return function;
    }

    //For setting from the program
    void setFunctionDisplayLabel(Polynomial polynomial) {
        this.functionDisplayLabel.setText("f(x) = " + polynomial.toString());
    }

    //For setting from the user
    void setFunctionDisplayLabel(String s) {
        if(!s.equals("Enter a function...")) {
            if (s.startsWith("f(x) = ")) {
                s.replaceAll("f(x) = ", "");
            }
            if (s.startsWith("f(x)=")) {
                s.replaceAll("f(x)=", "");
            }
            this.functionDisplayLabel.setText("f(x) = " + s);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}

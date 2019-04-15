package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CalculusView extends View {

    Polynomial function;

    JPanel panel;
    JTextField orderTextField;
    JLabel functionDisplayLabel;
    JButton derivative;

    public CalculusView() {

    }

    public CalculusView(Polynomial function) {
        this.function = function;
        initCalculusViewSwing();
    }

    private void initCalculusViewSwing() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 300));

        orderTextField = new JTextField("Order");
        orderTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (orderTextField.getText().equals("Order")) {
                    orderTextField.setText("");
                    orderTextField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (orderTextField.getText().isEmpty()) {
                    orderTextField.setForeground(Color.GRAY);
                    orderTextField.setText("Order");
                }
            }
        });

        functionDisplayLabel = new JLabel("f(x) = " + function.toString());
        functionDisplayLabel.setBounds(200, 20, 200, 40);
        functionDisplayLabel.setSize(200, 40);

        derivative = new JButton("Update function");
        derivative.setBounds(260, 80, 175, 25);
        derivative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setFunctionDisplayLabel(functionTextField.getText());
            }
        });

        panel.add(functionDisplayLabel);
        panel.add(orderTextField);
        panel.add(derivative);

        panel.setVisible(true);
    }
}

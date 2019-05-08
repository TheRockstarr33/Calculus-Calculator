package com.freeman.ui.gui.views.calc;

import com.freeman.calc.Derivative;
import com.freeman.obj.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DerivativeView {

    Polynomial function;

    JPanel panel;
    JTextField order;

    public DerivativeView(Polynomial p) {
        function = p;
        init();
    }

    private void init() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 200));
//        panel.setPreferredSize(new Dimension(300, 200));

        order = new JTextField("Order");
        order.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (order.getText().equals("Order")) {
                    order.setText("");
                    order.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (order.getText().isEmpty()) {
                    order.setForeground(Color.GRAY);
                    order.setText("Order");
                }
            }
        });
        order.setBounds(40, 120, 75, 25);
        order.setColumns(3);

        panel.add(order);

        panel.setVisible(true);
    }


    ///TODO: Fix getPanel to return a functional panel
    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextField() {
        return order;
    }
}

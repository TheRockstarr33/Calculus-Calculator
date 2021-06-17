package com.freeman.ui.gui.views.calc;

import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.CalculusView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DefIntegralView {

    Polynomial function;
    JButton integrate;
    JTextField bnd_low, bnd_high;

    public DefIntegralView(Polynomial p) {
        function = p;
        init();
    }

    private void init() {
        bnd_high = new JTextField();
        bnd_high.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bnd_high.getText().equals("High")) {
                    bnd_high.setText("");
                    bnd_high.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bnd_high.getText().isEmpty()) {
                    bnd_high.setForeground(Color.GRAY);
                    bnd_high.setText("High");
                }
            }
        });
        bnd_high.setBounds(175, 140, 75, 25);
        bnd_high.setColumns(3);


        bnd_low = new JTextField();
        bnd_low.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bnd_low.getText().equals("Low")) {
                    bnd_low.setText("");
                    bnd_low.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bnd_low.getText().isEmpty()) {
                    bnd_low.setForeground(Color.GRAY);
                    bnd_low.setText("Low");
                }
            }
        });
        bnd_low.setBounds(75, 140, 75, 25);
        bnd_low.setColumns(3);

        integrate = new JButton("Find Integral");
        integrate.setBounds(275, 140, 100, 25);
        integrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculusView.addToList(new Polynomial(String.valueOf(
                        Integral.defIntegralOfPolynomial(function, new double[]{
                                Double.parseDouble(bnd_low.getText()),
                                Double.parseDouble((bnd_high.getText()))
                        })
                )));
            }
        });
    }

    public JButton getIntegrate() {
        return integrate;
    }

    public JTextField getBnd_high() {
        return bnd_high;
    }

    public JTextField getBnd_low() {
        return bnd_low;
    }

    public void setFunction(Polynomial polynomial) {
        this.function = polynomial;
    }
}

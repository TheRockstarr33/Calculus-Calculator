package com.freeman.ui.gui.views.calc;

import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.CalculusView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndefIntegralView {

    Polynomial function;
    JButton integrate;

    public IndefIntegralView(Polynomial p) {
        function = p;
        init();
    }

    private void init() {
        integrate = new JButton("Find Integral");
        integrate.setBounds(135, 140, 200, 25);
        integrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculusView.addToList(Integral.indefIntegralOfPolynomial(function));
            }
        });
    }

    public JButton getIntegrate() {
        return integrate;
    }

    public void setFunction(Polynomial polynomial) {
        this.function = polynomial;
    }
}

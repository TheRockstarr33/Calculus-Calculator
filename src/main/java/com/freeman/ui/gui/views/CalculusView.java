package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.calc.DerivativeView;

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
    JButton derivative, indefIntegral, defIntegral;
    JSeparator separator;
    DerivativeView derivativeView;

    public CalculusView() {
        initCalculusViewSwing();
    }

    public CalculusView(Polynomial function) {
        this.function = function;
        className = "CalculusView";
        initCalculusViewSwing();
    }

    private void initCalculusViewSwing() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 300));

        functionDisplayLabel = new JLabel("f(x) = " + function.toString());
        functionDisplayLabel.setBounds(200, 20, 200, 40);
        functionDisplayLabel.setSize(200, 40);

        derivative = new JButton("Derivative");
        derivative.setBounds(50, 80, 100, 25);
        derivative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Finish derivativeView programming
                derivativeView = new DerivativeView(function);
                derivativeView.getPanel().setVisible(true);
//                panel.add(derivativeView.getPanel());
            }
        });
        derivative.setToolTipText("Derivative");

        indefIntegral = new JButton("Indef Integral");
        indefIntegral.setBounds(183, 80, 100, 25);
        indefIntegral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setFunctionDisplayLabel(functionTextField.getText());
            }
        });
        indefIntegral.setToolTipText("Indefinite Integral");

        defIntegral = new JButton("Def Integral");
        defIntegral.setBounds(326, 80, 100, 25);
        defIntegral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setFunctionDisplayLabel(functionTextField.getText());
            }
        });
        defIntegral.setToolTipText("Definite Integral");

        panel.add(functionDisplayLabel);
//        panel.add(orderTextField);
        panel.add(derivative);
        panel.add(indefIntegral);
        panel.add(defIntegral);

        panel.setVisible(true);
    }

    @Override
    public Polynomial getFunction() {
        return function;
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public void setFunction(Polynomial p) {
        this.function = p;
    }
}

package com.freeman.ui.gui.views;

import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApproxView extends View {

    Polynomial function;

    JPanel panel;
    JButton reimannButton, trapezoidalButton, simpsonsButton;
    JTextField interval1, interval2, n;
    JLabel functionDisplayLabel;

    public ApproxView(Polynomial function) {
        this.function = function;
        className = "ApproxView";

    }

    protected void initApproxViewSwing() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 300));

        functionDisplayLabel = new JLabel("f(x) = " + function.toString());
        functionDisplayLabel.setBounds(200, 20, 200, 40);
        functionDisplayLabel.setSize(200, 40);

        interval1 = new JTextField();
        interval1.setBounds(40, 80, 75, 25);
        interval1.setColumns(5);

        interval2 = new JTextField();
        interval2.setBounds(135, 80, 75, 25);
        interval2.setColumns(5);

        n = new JTextField();
        n.setBounds(210, 80, 75, 25);
        n.setColumns(5);

        reimannButton = new JButton("Reimann Sum");
        reimannButton.setBounds(50, 80, 100, 25);

        trapezoidalButton = new JButton("Trapezoidal Approx");
        trapezoidalButton.setBounds(183, 80, 100, 25);

        simpsonsButton = new JButton("Simpson's Approx");
        simpsonsButton.setBounds(326, 80, 100, 25);
        simpsonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sApprox = Integral.simpsonsApproximation(function, new double[]{Double.parseDouble(interval1.getText()), Double.parseDouble(interval2.getText())}, Integer.parseInt(n.getText()));
            }
        });

        panel.add(functionDisplayLabel);
        panel.add(interval1);
        panel.add(interval2);
        panel.add(n);
        panel.add(reimannButton);
        panel.add(trapezoidalButton);
        panel.add(simpsonsButton);
    }

    @Override
    public Polynomial getFunction() {
        return function;
    }

    public void setFunction(Polynomial function) {
        this.function = function;
    }


}

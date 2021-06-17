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
    JButton riemannButton, trapezoidalButton, simpsonsButton, list_useFunc, list_removeFunc;
    JTextField interval1, interval2, n;
    JLabel functionDisplayLabel;
    JList polynomialList;

    static DefaultListModel<Polynomial> lm;

    public ApproxView(Polynomial function) {
        this.function = function;
        className = "ApproxView";
        initApproxViewSwing();
    }

    protected void initApproxViewSwing() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setMinimumSize(new Dimension(300, 300));

        lm = new DefaultListModel<>();
        lm.addElement(function);

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
        n.setBounds(230, 80, 75, 25);
        n.setColumns(5);

        riemannButton = new JButton("Reimann Sum");
        riemannButton.setBounds(50, 120, 100, 25);
        //TODO: Finish Riemann Sum

        //TODO: BUG: fix 1 - 1 - 1 input in the text boxes
        trapezoidalButton = new JButton("Trapezoidal Approx");
        trapezoidalButton.setBounds(183, 120, 100, 25);
        trapezoidalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sApprox = Integral.trapezoidalApproximation(function,
                        new double[]{Double.parseDouble(interval1.getText()),
                                Double.parseDouble(interval2.getText())},
                        Integer.parseInt(n.getText()));
                lm.addElement(new Polynomial(Double.toString(sApprox)));
            }
        });

        simpsonsButton = new JButton("Simpson's Approx");
        simpsonsButton.setBounds(326, 120, 100, 25);
        simpsonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sApprox = Integral.simpsonsApproximation(function,
                        new double[]{Double.parseDouble(interval1.getText()),
                                Double.parseDouble(interval2.getText())},
                        Integer.parseInt(n.getText()));
                //Possibly store as doubles, since we won't really need to get polynomials
                //anyways.
                lm.addElement(new Polynomial(Double.toString(sApprox)));
            }
        });





        polynomialList = new JList(lm);
        polynomialList.setBounds(85, 200, 300, 200);
        polynomialList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        polynomialList.setLayoutOrientation(JList.VERTICAL);
        polynomialList.setVisibleRowCount(12);

        //TODO: Don't necessarily need these
        list_useFunc = new JButton("Select Function");
        list_useFunc.setBounds(85, 420, 140, 25);
        list_useFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(polynomialList.getSelectedValue()!=null) {
                    function = (Polynomial) polynomialList.getSelectedValue();
                    functionDisplayLabel.setText("f(x) = " + function.toString());
                    panel.revalidate();
                    panel.repaint();
                    panel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a function",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        list_removeFunc = new JButton("Remove Function");
        list_removeFunc.setBounds(245, 420, 140, 25);
        list_removeFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind = polynomialList.getSelectedIndex();
                lm.remove(ind);
                polynomialList.remove(ind);
            }
        });


        panel.add(functionDisplayLabel);
        panel.add(interval1);
        panel.add(interval2);
        panel.add(n);
        panel.add(riemannButton);
        panel.add(trapezoidalButton);
        panel.add(simpsonsButton);
        panel.add(list_removeFunc);
        panel.add(list_useFunc);
        panel.add(polynomialList);

        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Polynomial getFunction() {
        return function;
    }

    public void setFunction(Polynomial function) {
        this.function = function;
    }

    public static void addToList(Polynomial p) {
        if(lm.size()>11) {
            lm.remove(0);
        }
        lm.addElement(p);
    }
}

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
    JButton derivative, indefIntegral, defIntegral, list_useFunc, list_removeFunc;
    JSeparator separator;
    DerivativeView derivativeView;
    JList polynomialList;

    static DefaultListModel<Polynomial> lm;

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
//                derivativeView.getPanel().setVisible(true);
//                panel.add(derivativeView.getPanel());
                panel.add(derivativeView.getTextField());
                panel.add(derivativeView.getDer());
//                JPanel p = derivativeView.getPanel();
//                p.setBounds(100, 150, 300, 300);
//                p.revalidate();
//                p.repaint();
//                panel.add(p);
////                panel.revalidate();
                panel.repaint();
                panel.setVisible(true);
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

        lm = new DefaultListModel<>();
        lm.addElement(function);

        polynomialList = new JList(lm);
        polynomialList.setBounds(85, 200, 300, 200);
        polynomialList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        polynomialList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        polynomialList.setVisibleRowCount(6);

        list_useFunc = new JButton("Select Function");
        list_useFunc.setBounds(85, 420, 140, 25);
        list_useFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                function = (Polynomial) polynomialList.getSelectedValue();
                functionDisplayLabel.setText("f(x) = " + function.toString());
                panel.revalidate();
                panel.repaint();
                panel.setVisible(true);
            }
        });

        list_removeFunc = new JButton("Remove Function");
        list_removeFunc.setBounds(245, 420, 140, 25);
        list_removeFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lm.remove(polynomialList.getSelectedIndex());
                polynomialList.remove(polynomialList.getSelectedIndex());
            }
        });

        panel.add(functionDisplayLabel);
//        panel.add(orderTextField);
        panel.add(derivative);
        panel.add(indefIntegral);
        panel.add(defIntegral);
        panel.add(polynomialList);
        panel.add(list_removeFunc);
        panel.add(list_useFunc);

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

    public static void addToList(Polynomial p) {
        lm.addElement(p);
    }
}

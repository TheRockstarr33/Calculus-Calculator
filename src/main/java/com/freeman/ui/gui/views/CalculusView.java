package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.calc.DefIntegralView;
import com.freeman.ui.gui.views.calc.DerivativeView;
import com.freeman.ui.gui.views.calc.IndefIntegralView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculusView extends View {

    Polynomial function;

    JPanel panel;
    JTextField orderTextField;
    JLabel functionDisplayLabel;
    JButton derivative, indefIntegral, defIntegral, list_useFunc, list_removeFunc;
    JSeparator separator;
    DerivativeView derivativeView;
    DefIntegralView defIntegralView;
    IndefIntegralView indefIntegralView;
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

    private void setFunctionInViews() {
        if(derivativeView!=null) {
            derivativeView.setFunction(function);
        }
        if(defIntegralView!=null) {
            defIntegralView.setFunction(function);
        }
        if(indefIntegralView!=null) {
            indefIntegralView.setFunction(function);
        }
    }

    private void reset() {
        if(derivativeView!=null) {
            panel.remove(derivativeView.getDer());
            panel.remove(derivativeView.getTextField());
            panel.remove(derivativeView.getPanel());
        }
        if(defIntegralView!=null) {
            panel.remove(defIntegralView.getBnd_high());
            panel.remove(defIntegralView.getBnd_low());
            panel.remove(defIntegralView.getIntegrate());
        }
        if(indefIntegralView!=null) {
            panel.remove(indefIntegralView.getIntegrate());
        }
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
                reset();
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
                reset();
                indefIntegralView = new IndefIntegralView(function);
                panel.add(indefIntegralView.getIntegrate());
                panel.repaint();
                panel.setVisible(true);
            }
        });
        indefIntegral.setToolTipText("Indefinite Integral");

        defIntegral = new JButton("Def Integral");
        defIntegral.setBounds(326, 80, 100, 25);
        defIntegral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                setFunctionDisplayLabel(functionTextField.getText());
                reset();
                panel.repaint();
                defIntegralView = new DefIntegralView(function);
                panel.add(defIntegralView.getBnd_high());
                panel.add(defIntegralView.getBnd_low());
                panel.add(defIntegralView.getIntegrate());
                panel.repaint();
                panel.setVisible(true);
            }
        });
        defIntegral.setToolTipText("Definite Integral");

        lm = new DefaultListModel<>();
        lm.addElement(function);

        polynomialList = new JList(lm);
        polynomialList.setBounds(85, 200, 300, 200);
        polynomialList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        polynomialList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        polynomialList.setLayoutOrientation(JList.VERTICAL);
        polynomialList.setVisibleRowCount(12);

        list_useFunc = new JButton("Select Function");
        list_useFunc.setBounds(85, 420, 140, 25);
        list_useFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(polynomialList.getSelectedValue()!=null) {
                    function = (Polynomial) polynomialList.getSelectedValue();
                    functionDisplayLabel.setText("f(x) = " + function.toString());
                    setFunctionInViews();
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
        if(lm.size()>11) {
            lm.remove(0);
        }
        lm.addElement(p);
    }
}

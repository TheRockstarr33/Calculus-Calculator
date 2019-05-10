package com.freeman.ui.gui.views.calc;

import com.freeman.obj.Polynomial;

import javax.swing.*;

public class IndefIntegralView {

    Polynomial function;
    JButton integrate;

    public IndefIntegralView(Polynomial p) {
        function = p;
        init();
    }

    private void init() {
        integrate = new JButton("Find Integral");
    }
}

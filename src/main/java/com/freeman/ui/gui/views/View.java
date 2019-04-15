package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;

import javax.swing.*;

public abstract class View {

    Polynomial function;

    JPanel panel;

    public View() {

    }

    public View(Polynomial p) {

    }

    public Polynomial getFunction() {
        return function;
    }

    public JPanel getPanel() {
        return panel;
    }
}

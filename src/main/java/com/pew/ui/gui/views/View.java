package com.freeman.ui.gui.views;

import com.freeman.obj.Polynomial;

import javax.swing.*;

public abstract class View {

    Polynomial function;

    JPanel panel;
    static String className;

    public Polynomial getFunction() {
        return function;
    }

    public JPanel getPanel() {
        return panel;
    }

    public static String getClassName() {
        return className;
    }
}

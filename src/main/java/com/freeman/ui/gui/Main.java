package com.freeman.ui.gui;

import com.freeman.obj.Polynomial;

import javax.swing.*;

public class Main {

    static Polynomial function;

    public static void main(String[] args) {
        //FIX X!!
        function = new Polynomial("3x");
        new Window(function);
    }
}

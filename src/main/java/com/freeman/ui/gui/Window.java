package com.freeman.ui.gui;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.FunctionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    Polynomial function;

    JFrame frame;
    JMenuBar menuBar;

    JMenu help, about;
    JMenuItem helpMenuItem, aboutMenuItem, versionMenuItem;

    public Window(Polynomial function) {
        this.function = function;

        frame = new JFrame("Calculus Calculator");
        menuBar = new JMenuBar();

        initHelpMenu();


        FunctionView f = new FunctionView(function);
        frame.add(f.getPanel());

        frame.setJMenuBar(menuBar);

        //TODO: We need to have a way to set the size based on the current display mode
        frame.setSize(500, 650);
        frame.setVisible(true);
    }

    public void initCalculusMenu() {

    }

    public void initHelpMenu() {
        help = new JMenu("Help");
        about = new JMenu("About");
        helpMenuItem = new JMenuItem("Help");
        aboutMenuItem = new JMenuItem("About");
        versionMenuItem = new JMenuItem("Version");
        helpMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        versionMenuItem.addActionListener(this);
        help.add(helpMenuItem);
        about.add(aboutMenuItem);
        about.add(versionMenuItem);
        help.add(about);

        menuBar.add(help);
    }

    public int getFrameWidth() {
        return frame.getWidth();
    }

    public int getFrameHeight() {
        return frame.getHeight();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== helpMenuItem) {
            //Open new help window, documentation?
        } else if(e.getSource() == aboutMenuItem) {
            JOptionPane.showMessageDialog(frame, "This software was made by David Ryan.", "About",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == versionMenuItem) {
            //Update version #'s in the future: 1.0.0 will be release
            //0.8 for development, 0.9 for pre-release
            JOptionPane.showMessageDialog(frame, "0.8.0", "Version",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

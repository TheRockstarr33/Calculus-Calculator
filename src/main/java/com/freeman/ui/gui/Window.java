package com.freeman.ui.gui;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.CalculusView;
import com.freeman.ui.gui.views.FunctionView;
import com.freeman.ui.gui.views.View;
import com.freeman.ui.gui.views.visualize.GraphView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    Polynomial function;

    JFrame frame;
    JMenuBar menuBar;

    JMenu help, about, view;
    JMenuItem h_helpMenuItem, h_aboutMenuItem, h_versionMenuItem;
    JMenuItem v_function, v_calc, v_graph;

    View currentView;

    public Window(Polynomial function) {
        this.function = function;

        frame = new JFrame("Calculus Calculator");
        menuBar = new JMenuBar();

        initViewMenu();
        initHelpMenu();

        currentView = new FunctionView(function);
        frame.add(currentView.getPanel());

        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //TODO: We need to have a way to set the size based on the current display mode
        frame.setSize(500, 650);
        frame.setVisible(true);
    }

    public void initViewMenu() {
        view = new JMenu("Views");
        v_function = new JMenuItem("Function");
        v_calc = new JMenuItem("Calculus");
        v_graph = new JMenuItem("Graph");
        v_function.addActionListener(this);
        v_calc.addActionListener(this);
        v_graph.addActionListener(this);
        view.add(v_function);
        view.add(v_calc);
        view.add(v_graph);

        menuBar.add(view);
    }

    public void initCalculusMenu() {

    }

    public void initHelpMenu() {
        help = new JMenu("Help");
        about = new JMenu("About");
        h_helpMenuItem = new JMenuItem("Help");
        h_aboutMenuItem = new JMenuItem("About");
        h_versionMenuItem = new JMenuItem("Version");
        h_helpMenuItem.addActionListener(this);
        h_aboutMenuItem.addActionListener(this);
        h_versionMenuItem.addActionListener(this);
        help.add(h_helpMenuItem);
        about.add(h_aboutMenuItem);
        about.add(h_versionMenuItem);
        help.add(about);

        menuBar.add(help);
    }

    public int getFrameWidth() {
        return frame.getWidth();
    }

    public int getFrameHeight() {
        return frame.getHeight();
    }

    protected void changeView(View o) {
        frame.getContentPane().removeAll();
        function = currentView.getFunction();

        try {
            if(o.getClassName().equals("FunctionView")) {
                currentView = new FunctionView(function);
            } else if(o.getClassName().equals("CalculusView")) {
                currentView = new CalculusView(function);
            }
        } catch (Exception e) {
            System.out.println("Failed to change view. ");
            System.out.println("changeView(Object o) in Window.java for reason: " + e);
        }
        frame.getContentPane().add(currentView.getPanel());

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== h_helpMenuItem) {
            //Open new help window, documentation?
        } else if(e.getSource() == h_aboutMenuItem) {
            JOptionPane.showMessageDialog(frame, "This software was made by David Ryan.", "About",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == h_versionMenuItem) {
            //Update version #'s in the future: 1.0.0 will be release
            //0.8 for development, 0.9 for pre-release
            JOptionPane.showMessageDialog(frame, "0.8.0", "Version",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == v_function) {
            changeView(new FunctionView(function));
        } else if(e.getSource() == v_calc) {
            changeView(new CalculusView(function));
        } else if(e.getSource() == v_graph) {
//            changeView(new GraphView(function));
            new GraphView(function);
        }
    }
}

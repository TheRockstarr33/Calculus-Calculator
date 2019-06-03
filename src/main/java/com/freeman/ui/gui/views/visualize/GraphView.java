package com.freeman.ui.gui.views.visualize;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import com.freeman.obj.Polynomial;
import com.freeman.ui.gui.views.View;

import javax.swing.*;

public class GraphView extends View {

    private Polynomial function;

    private JPanel panel;
    private JFrame frame;

    private Graphics2D g2d;

    private ArrayList<Shape> graph;
    private double x_min, x_max;
    private double y_min, y_max;

    private Shape xAxis, yAxis;
    private ArrayList<Shape> xAxisMarkers, yAxisMarkers;

    public GraphView(Polynomial polynomial) {
        this.frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        this.function = polynomial;
        x_min=-10;
        x_max=10;
        y_min=-10;
        y_max=10;
        jPanelSetup();
        frame.setTitle("Graph of " + function);
        frame.getContentPane().add(panel);
    }

    public void drawAxis() {
        //TODO: Add a more flexible system for this in the future...
        xAxis = new Line2D.Double(0, 200, 400, 200);
        yAxis = new Line2D.Double(200, 0, 200, 400);
        g2d.draw(xAxis);
        g2d.draw(yAxis);

        xAxisMarkers = new ArrayList<>();
        yAxisMarkers = new ArrayList<>();
        for(int i = 0; i<=400; i+=20) {
            xAxisMarkers.add(new Line2D.Double(i, 195, i, 205));
            yAxisMarkers.add(new Line2D.Double(195, i, 205, i));
        }
        for (Shape s : xAxisMarkers) {
            g2d.draw(s);
        }
        for (Shape s : yAxisMarkers) {
            g2d.draw(s);
        }
    }

    public void jPanelSetup() {
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g2d = (Graphics2D) g;
                drawAxis();
            }
        };
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}

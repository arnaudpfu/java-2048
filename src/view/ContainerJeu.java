package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.Serializable;

public class ContainerJeu extends JPanel implements Serializable {
    
    private static final long serialVersionUID = 8L;
    
    public ContainerJeu(){
        super();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(8, 8, 8, 8));
    }
            
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor( new Color(177,164,152) );
        Graphics2D graphics2 = (Graphics2D) g;
        int radius = 10;
        int padding = 0;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float( padding, padding, getWidth() - 2*padding, getHeight() - 2*padding, radius, radius);
        graphics2.fill(roundedRectangle);
    }
}

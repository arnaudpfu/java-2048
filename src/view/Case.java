package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.io.Serializable;

public class Case extends JPanel implements Serializable {
    private static final long serialVersionUID = 8L;
    
    private int valeur;
    private JLabel label;
    
    public Case( int valeur ){
        super();
        this.valeur = valeur;

        setLayout(new BorderLayout());
        setBackground(new Color(177,164,152));
        
        displayValeur();
    }

    public void displayValeur(){
        this.label = new JLabel( String.valueOf(valeur) );
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(getFontColor());

        label.setFont(new Font("Open Sans", Font.BOLD, 45));
        add(label, BorderLayout.CENTER );

        defineVisibily();
    }

    public Color getFontColor(){
        Color color = new Color( 255,243,243 );
        if( 4 >= this.valeur ){
            color = new Color( 116,109,95 );
        }
        return color;
    }

    public void setValeur(int newValeur){
        this.valeur = newValeur;
    }

    public void update(int newValeur){
        if(valeur != newValeur){
            setValeur(newValeur);
            label.setForeground(getFontColor());
            label.setText( String.valueOf(newValeur) );
        }
        defineVisibily();
        revalidate();
        repaint();
    }

    public void defineVisibily(){
        if( 0 == valeur ){
            label.setVisible(false);
        }else{
            label.setVisible(true);
        }
    }

    public Color getBackgroundColor(){
        Color color;
        switch (this.valeur) {
            case 2:
                color = new Color( 239,229,218 );
                break;
            case 4:
                color = new Color( 236,224,198 );
                break;
            case 8:
                color = new Color( 241,177,121 );
                break;
            case 16:
                color = new Color( 246,149,100 );
                break;
            case 32:
                color = new Color( 247,124,95 );
                break;
            case 64:
                color = new Color( 245,94,58 );
                break;
            case 128:
                color = new Color( 237,206,114 );
                break;
            case 256:
                color = new Color( 226,194,91 );
                break;
            case 512:
                color = new Color( 224,189,87 );
                break;
            case 1024:
                color = new Color( 232,188,54 );
                break;
            case 2048:
                color = new Color( 225,187,60 );
                break;
            default:
                color = new Color( 204,192,180 );
                break;

        }
        return color;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor( getBackgroundColor() );
        Graphics2D graphics2 = (Graphics2D) g;
        int radius = 5;
        int padding = 7;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float( padding, padding, getWidth() - 2*padding, getHeight() - 2*padding, radius, radius);
        graphics2.fill(roundedRectangle);
    }
}

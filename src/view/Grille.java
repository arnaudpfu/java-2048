package view;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PlayKeyAdapter;
import controller.PlayMouseAdapter;
import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;

import java.io.Serializable;

public class Grille extends JPanel implements PropertyChangeListener, Serializable {

    private static final long serialVersionUID = 4L;
    
    private Jeu2048 jeu;
    private Chrono chrono;
    private Case[][] cases;

    public Grille(Jeu2048 jeu, Chrono chrono){
        this.jeu = jeu;
        this.chrono = chrono;
        this.cases = new Case[jeu.getNbLignes()][jeu.getNbCols()];
        jeu.addPropertyChangeListener("grille", this);

        setFocusable(true);
        setLayout(new GridLayout(jeu.getNbLignes(), jeu.getNbCols()));
        setBackground(new Color(177,164,152));

        createCase();

        addMouseListener(new PlayMouseAdapter(jeu, chrono));
        addKeyListener(new PlayKeyAdapter(jeu));
    }

    public void createCase(){
        int[][] valeursGrille = jeu.getGrilleInt();

        for (int i = 0; i < jeu.getNbLignes(); i++) {
            for (int j = 0; j < jeu.getNbCols(); j++) {
                Case currentCase = new Case(valeursGrille[i][j]);
                cases[i][j] = currentCase;
                add(currentCase);
            }
        }
    }

    public void update(){
        int[][] valeursGrille = jeu.getGrilleInt();

        for (int i = 0; i < jeu.getNbLignes(); i++) {
            for (int j = 0; j < jeu.getNbCols(); j++) {
                cases[i][j].update(valeursGrille[i][j]);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor( new Color(177,164,152) );
        Graphics2D graphics2 = (Graphics2D) g;
        int radius = 5;
        int padding = 0;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float( padding, padding, getWidth() - 2*padding, getHeight() - 2*padding, radius, radius);
        graphics2.fill(roundedRectangle);
    }

    public void checkEtatPartie(){
        if(jeu.estTermine()){
            if(jeu.estVainqueur()){
                showMessageDialog(null, "Vous avez gagné!");
            }else{
                showMessageDialog(null, "Vous êtes bloqué :/");
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        update();
        checkEtatPartie();
    }
    
}

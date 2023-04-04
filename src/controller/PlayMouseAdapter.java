package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import fr.univsavoie.java.jeu2048.Jeu2048;
import view.Grille;
import model.Chrono;

import java.io.Serializable;

public class PlayMouseAdapter extends MouseAdapter implements Serializable{

    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;
    private Chrono chrono;

    public PlayMouseAdapter(Jeu2048 jeu, Chrono chrono){
        super();
        this.jeu = jeu;
        this.chrono = chrono;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        chrono.start();
        ( (JPanel) e.getSource() ).requestFocus();
        int direction = getDirection(e);
        jeu.decaler(direction);
    }

    
    public int getDirection(MouseEvent e){
        int direction = Jeu2048.HAUT;

        // Distances
        int left = e.getX();
        int right = ( (Grille) e.getSource()).getWidth() - e.getX();
        int top = e.getY();
        int bottom = ( (Grille) e.getSource()).getHeight() - e.getY();
        int mini = Integer.min( Integer.min(top, bottom), Integer.min(left, right) );

        if(mini == left){
            direction = Jeu2048.GAUCHE;
        }else if(mini == right){
            direction = Jeu2048.DROITE;
        }else if(mini == top){
            direction = Jeu2048.HAUT;
        }else if(mini == bottom){
            direction = Jeu2048.BAS;
        }

        return direction;
    }
}
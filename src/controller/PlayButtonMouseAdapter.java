package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;

import java.io.Serializable;

public class PlayButtonMouseAdapter extends MouseAdapter implements Serializable {
    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;
    private Chrono chrono;

    public PlayButtonMouseAdapter(Jeu2048 jeu, Chrono chrono){
        super();
        this.jeu = jeu;
        this.chrono = chrono;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        jeu.nouveauJeu();
        System.out.println( chrono.getDureeSec() );
        chrono.reset();
    }

    
}

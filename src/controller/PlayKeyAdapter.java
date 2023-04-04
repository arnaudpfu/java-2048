package controller;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.univsavoie.java.jeu2048.Jeu2048;

import java.io.Serializable;

public class PlayKeyAdapter extends KeyAdapter implements Serializable {

    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;

    public PlayKeyAdapter(Jeu2048 jeu){
        this.jeu = jeu;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                jeu.decaler(Jeu2048.HAUT);
                break;
            case KeyEvent.VK_LEFT:
                jeu.decaler(Jeu2048.GAUCHE);
                break;
            case KeyEvent.VK_RIGHT:
                jeu.decaler(Jeu2048.DROITE);
                break;
            case KeyEvent.VK_DOWN:
                jeu.decaler(Jeu2048.BAS);
                break;
        }
    }
}

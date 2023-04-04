package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.univsavoie.java.jeu2048.Jeu2048;
import view.InterfaceJeu;

import java.io.Serializable;

public class LoadButtonMouseAdapter extends MouseAdapter implements Serializable {

    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;
    private InterfaceJeu interfaceJeu;

    public LoadButtonMouseAdapter(Jeu2048 jeu, InterfaceJeu interfaceJeu) {
        super();
        this.jeu = jeu;
        this.interfaceJeu = interfaceJeu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        String path = System.getProperty("user.dir") + "\\sauvegarde.txt";
        charger( path );
    }

    void charger(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Jeu2048 jeuCharge = (Jeu2048)ois.readObject();
            // System.out.println( new PropertyChangeSupport(jeuCharge) );
            // jeuCharge.addPropertyChangeListener("grille", );
            interfaceJeu.setJeu(jeuCharge);

            // jeu.setNbBut(jeuCharge.getNbBut());
            // jeu.setBestScore(jeuCharge.getBestScore());

        } catch (Exception e) {
            System.out.println( e );
        }
    }
}

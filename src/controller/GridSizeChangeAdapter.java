package controller;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.univsavoie.java.jeu2048.Jeu2048;
import view.InterfaceJeu;

import java.io.Serializable;

public class GridSizeChangeAdapter implements ChangeListener, Serializable {
    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;
    private InterfaceJeu interfaceJeu;
    private JSpinner rowSpinner;
    private JSpinner colSpinner;

    public GridSizeChangeAdapter(Jeu2048 jeu, InterfaceJeu interfaceJeu, JSpinner rowSpinner,JSpinner colSpinner){
        this.jeu = jeu;
        this.interfaceJeu = interfaceJeu;
        this.rowSpinner = rowSpinner;
        this.colSpinner = colSpinner;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int rowNb = (int) rowSpinner.getValue();
        int colNb = (int) colSpinner.getValue();

        Jeu2048 newJeu = new Jeu2048(rowNb, colNb, jeu.getNbBut());
        interfaceJeu.setJeu(newJeu);
        newJeu.setNbBut(jeu.getNbBut());
        newJeu.setBestScore(jeu.getBestScore());
    }

}

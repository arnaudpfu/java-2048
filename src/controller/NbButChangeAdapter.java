package controller;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.univsavoie.java.jeu2048.Jeu2048;

import java.io.Serializable;

public class NbButChangeAdapter implements ChangeListener, Serializable {
    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;
    private JLabel indication;

    public NbButChangeAdapter(Jeu2048 jeu, JLabel indication){
        this.jeu = jeu;
        this.indication = indication;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = (int) ( (JSpinner) e.getSource() ).getValue();
        indication.setText("Objectif : " + String.valueOf( (int) Math.pow(2,newValue) ));
        jeu.setNbBut( (int) Math.pow(2,newValue));
    }

}

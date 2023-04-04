package view;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.ChronoUpdater;
import controller.GridSizeChangeAdapter;
import controller.LoadButtonMouseAdapter;
import controller.NbButChangeAdapter;
import controller.PlayButtonMouseAdapter;
import controller.SaveButtonMouseAdapter;
import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;
import java.io.Serializable;

public class SaveLoadContainer extends JPanel implements Serializable {
    private static final long serialVersionUID = 6L;

    private Jeu2048 jeu;
    private InterfaceJeu interfaceJeu;

    public SaveLoadContainer(Jeu2048 jeu, InterfaceJeu interfaceJeu){
        super();
        this.jeu = jeu;
        this.interfaceJeu = interfaceJeu;

        JButton saveButton = new JButton("Sauvegarder");
        saveButton.addMouseListener(new SaveButtonMouseAdapter(jeu));

        JButton loadButton = new JButton("Charger");
        loadButton.addMouseListener(new LoadButtonMouseAdapter(jeu, interfaceJeu));

        add(saveButton);
        add(loadButton);
    }
    
}


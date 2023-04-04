package view;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BoxLayout;
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

public class CommandPanel extends JPanel implements Serializable {
    private static final long serialVersionUID = 6L;
    /**
     * Largeur du JPanel
     */
    private static final int WIDTH = 600;
    /**
     * Hauteur du JPanel
     */
    private static final int HEIGHT = 160;

    private Jeu2048 jeu;
    private InterfaceJeu interfaceJeu;
    private Chrono chrono;

    public CommandPanel(Jeu2048 jeu, InterfaceJeu interfaceJeu, Chrono chrono){
        this.jeu = jeu;
        this.interfaceJeu = interfaceJeu;
        this.chrono = chrono;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // setLayout(new BorderLayout());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new SettingsContainer(jeu, interfaceJeu, chrono));
        // add(new ChronoContainer(chrono));
        add(new SaveLoadContainer(jeu, interfaceJeu));
    }

}

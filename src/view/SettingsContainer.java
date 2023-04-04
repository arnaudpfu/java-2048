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

public class SettingsContainer extends JPanel implements PropertyChangeListener, Serializable {
    private static final long serialVersionUID = 6L;

    private Jeu2048 jeu;
    private InterfaceJeu interfaceJeu;
    private Chrono chrono;
    private JLabel scoreLabel;
    private JLabel bestScoreLabel;

    public SettingsContainer(Jeu2048 jeu, InterfaceJeu interfaceJeu, Chrono chrono){
        super();
        this.jeu = jeu;
        this.interfaceJeu = interfaceJeu;
        this.chrono = chrono;
        setFocusable(false);
        setLayout(new FlowLayout());
        jeu.addPropertyChangeListener(this);

        JButton playButton = new JButton("Jouer une partie");
        playButton.addMouseListener(new PlayButtonMouseAdapter(jeu, chrono));
        add(playButton);

        int powTwo = (int) ( Math.log( jeu.getNbBut() ) / Math.log(2) );
        SpinnerModel nbButModel = new SpinnerNumberModel(powTwo, 1, 99, 1);
        JSpinner nbButSpinner = new JSpinner(nbButModel);
        JLabel nbButIndiaction = new JLabel("Objectif : " + String.valueOf( jeu.getNbBut() ) );
        JPanel nbButSettingContainer = new JPanel();
        nbButSettingContainer.setFocusable(false);
        nbButSettingContainer.setLayout(new FlowLayout());
        nbButSettingContainer.add(nbButIndiaction);
        nbButSettingContainer.add(nbButSpinner);
        nbButSpinner.addChangeListener(new NbButChangeAdapter(jeu, nbButIndiaction));

        this.scoreLabel = new JLabel("Score : " + String.valueOf( jeu.getScore() ));
        this.bestScoreLabel = new JLabel("Best Score : " + String.valueOf( jeu.getBestScore() ));

        SpinnerModel rowModel = new SpinnerNumberModel(jeu.getNbLignes(), 1, 15, 1);
        JSpinner rowSpinner = new JSpinner(rowModel);
        JPanel rowSettingContainer = new JPanel();
        rowSettingContainer.setFocusable(false);
        rowSettingContainer.setLayout(new FlowLayout());
        rowSettingContainer.add(new JLabel("Lignes : "));
        rowSettingContainer.add(rowSpinner);
        
        SpinnerModel colModel = new SpinnerNumberModel(jeu.getNbCols(), 1, 15, 1);
        JSpinner colSpinner = new JSpinner(colModel);
        JPanel colSettingContainer = new JPanel();
        colSettingContainer.setFocusable(false);
        colSettingContainer.setLayout(new FlowLayout());
        colSettingContainer.add(new JLabel("Colonnes : "));
        colSettingContainer.add(colSpinner);

        rowSpinner.addChangeListener(new GridSizeChangeAdapter(jeu, interfaceJeu, rowSpinner, colSpinner));
        colSpinner.addChangeListener(new GridSizeChangeAdapter(jeu, interfaceJeu, rowSpinner, colSpinner));

        add(scoreLabel);
        add(bestScoreLabel);
        add(nbButSettingContainer);
        add(rowSettingContainer);
        add(colSettingContainer);
    }

    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        scoreLabel.setText( "Score : " + String.valueOf( jeu.getScore() ) );
        bestScoreLabel.setText( "Best Score : " + String.valueOf( jeu.getBestScore() ) );
    }
    
}

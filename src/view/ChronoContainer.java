package view;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

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
import controller.PauseChronoMouseAdatper;
import controller.PlayButtonMouseAdapter;
import controller.SaveButtonMouseAdapter;
import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;
import java.io.Serializable;
import javax.swing.BoxLayout;

public class ChronoContainer extends JPanel implements Serializable {
    private static final long serialVersionUID = 6L;

    private Chrono chrono;
    private Thread updateThread;

    public ChronoContainer(Chrono chrono){
        super();
        this.chrono = chrono;
        this.updateThread = null;
        setLayout(new FlowLayout());
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel timerLabel = new JLabel( String.valueOf( String.valueOf( chrono.getDureeSec() + "s" ) ) );
        timerLabel.setFont(new Font("Open Sans", Font.BOLD, 45));

        JButton pauseBtn = new JButton("Pause");

        pauseBtn.addMouseListener(new PauseChronoMouseAdatper(chrono));

        add(timerLabel);
        add(pauseBtn);
        

        chrono.start(); 
        if (this.updateThread == null || ! this.updateThread.isAlive()) {
            this.updateThread = new Thread(new ChronoUpdater(chrono, timerLabel));
            updateThread.start();
        }
    }
    
}

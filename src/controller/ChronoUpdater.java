package controller;

import model.Chrono;
import java.io.Serializable;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class ChronoUpdater implements Runnable, Serializable {
    private static final long serialVersionUID = 8L;
    
    private Chrono chrono;
    private JLabel textField;
    // private MinuteurFrame vue;

    public ChronoUpdater(Chrono chrono, JLabel textField) {
        super();
        this.chrono = chrono;
        this.textField = textField;
    }

    @Override
    public void run() {
        while (chrono.getIsActive()) {
            textField.setText( String.valueOf( chrono.getDureeSec() + "s" ) );
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}

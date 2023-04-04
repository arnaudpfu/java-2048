package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Chrono;

public class PauseChronoMouseAdatper extends MouseAdapter {
    private Chrono chrono;

    public PauseChronoMouseAdatper(Chrono chrono){
        super();
        this.chrono = chrono;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        chrono.pause();
    }
    
}

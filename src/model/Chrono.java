package model;

import java.io.Serializable;

public class Chrono implements Serializable {
    private static final long serialVersionUID = 8L;

    private long tempsDepart = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private boolean isActive;

    public Chrono() {
        tempsDepart = System.currentTimeMillis();
        pauseDepart = 0;
        pauseFin = 0;
        this.isActive = false;
    }

    public void pause() {
        this.isActive = false;
        if (tempsDepart == 0) {
            return;
        }
        pauseDepart = System.currentTimeMillis();
    }

    public void resume() {
        this.isActive = true;
        if (pauseDepart == 0) {
            return;
        }
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        pauseDepart = 0;
        pauseFin = 0;
    }

    public void start() {
        this.isActive = true;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void reset() {
        tempsDepart = System.currentTimeMillis();
        pauseDepart = 0;
        pauseFin = 0;
    }

    public double getDureeMs() {
        return (System.currentTimeMillis()-tempsDepart) - (pauseFin-pauseDepart);
    }

    public double getDureeSec() {
        return getDureeMs() / 1000;
    }
}

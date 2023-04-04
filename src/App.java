import java.io.Serializable;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;
import view.InterfaceJeu;

import java.io.Serializable;

public class App implements Serializable {
    private static final long serialVersionUID = 8L;
    
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        int nbLignes = 4;
        int nbCols = 4;
        int nbBut = 16;
        Chrono chrono = new Chrono();
        Jeu2048 jeu = new Jeu2048(nbLignes, nbCols, nbBut);

        InterfaceJeu window = new InterfaceJeu(jeu, chrono);
        window.setVisible(true);
    }
}

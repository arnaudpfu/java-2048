package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.Serializable;

import fr.univsavoie.java.jeu2048.Jeu2048;

public class SaveButtonMouseAdapter extends MouseAdapter implements Serializable {
    private static final long serialVersionUID = 8L;

    private Jeu2048 jeu;

    public SaveButtonMouseAdapter(Jeu2048 jeu) {
        super();
        this.jeu = jeu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        String path = System.getProperty("user.dir") + "\\sauvegarde.txt";
        sauvegarder( path );
    }

    void sauvegarder(String path) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(jeu);
        }catch(IOException e){
            e.getStackTrace();
            System.out.println( e.getStackTrace() );
        }
    }
}

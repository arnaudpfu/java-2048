package view;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.Serializable;
import java.io.File;

import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import fr.univsavoie.java.jeu2048.Jeu2048;
import model.Chrono;

import java.io.Serializable;

public class InterfaceJeu extends JFrame implements Serializable {

    /**
     * Id pour la serialisation
     */
    private static final long serialVersionUID = 1L;

    /**
     * Largeur de la fen�tre
     */
    private static final int WIDTH = 600;
    /**
     * Hauteur de la fen�tre
     */
    private static final int HEIGHT = 800;

    private Jeu2048 jeu;
    private Chrono chrono;

    ImageIcon logo = new ImageIcon(".//src//images//2048_logo.png");

    public InterfaceJeu(Jeu2048 jeu, Chrono chrono) {
        this.jeu = jeu;
        this.chrono = chrono;

        setTitle("2048");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout());
        setIconImage(logo.getImage());
        this.setLocationRelativeTo(null);
        registerFonts();

        chrono.start();
        setJeu(jeu);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void setJeu(Jeu2048 jeu){
        this.jeu = jeu;
        addContent();
    }

    private void addContent(){
        getContentPane().removeAll();

        // Ce panneau sert juste à ajouter un peu de padding (pour l'affichage)
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        ContainerJeu containerJeu = new ContainerJeu();
        // containerJeu.setLayout(new BorderLayout());
        // containerJeu.add(new ChronoContainer(chrono), BorderLayout.NORTH);
        containerJeu.add(new Grille(jeu, chrono));

        CommandPanel commandPanel = new CommandPanel(jeu, this, chrono);

        mainContainer.add(containerJeu);
        mainContainer.add(commandPanel);
        mainContainer.add(new ChronoContainer(chrono));
        getContentPane().add(mainContainer);

        // getContentPane().add(commandPanel, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    public void registerFonts(){
        try {
            GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/OpenSans-ExtraBold.ttf")));
        } catch (IOException|FontFormatException e) {
                System.out.println( "Echec de l'enregistrement de la police." );
        }
    }

}

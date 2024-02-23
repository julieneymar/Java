package testèclavier;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class clavier extends JFrame implements KeyListener {

    JTextField textField;

    public clavier() {
        // Créer un champ de texte
        textField = new JTextField(20);
        textField.addKeyListener(this);
        this.add(textField);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Méthode appelée lorsqu'une touche est enfoncée
    public void keyPressed(KeyEvent e) {
        System.out.println("Touche pressée: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    // Méthode appelée lorsqu'une touche est relâchée
    public void keyReleased(KeyEvent e) {
    }

    // Méthode appelée lorsqu'une touche est frappée (pression et relâchement)
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new clavier(); // Créer l'instance de la fenêtre
    }
}

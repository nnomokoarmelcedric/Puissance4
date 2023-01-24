package interraction;
import systeme.Jeu;
import systeme.Parametres;
import java.io.IOException;
public class InteligenceArtificiel extends Joueur {

    public InteligenceArtificiel(String nom, int couleur) {
        super(nom, couleur);
    }
//la methode jouer de Intelligance.A genere un nombre aleatoire compris entre 1 et la taille du tableau tant que le placement n'est pas valide
    public void jouer(Jeu jeu, int c) throws IOException {
        jeu.afficher(c);
        //for (int col = 0; col < c; col++) {
        int n;
        do {
            n = 0 + (int) (Math.random() * ((c - 0) + 1));
        } while (!(jeu.joueCoup(n, this.getCouleur(), jeu.getTaille()) ));{

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(  this.getNom() + " a joué  " + (n + 1));
            Parametres.ecrireDansLog(this.getNom() + " a joué  " + (n + 1),true);
            return;
        }

    }
}

package interraction;

import interraction.Joueur;
import systeme.Jeu;
import systeme.Parametres;

import java.io.IOException;
import java.util.Scanner;


public  class Humain extends Joueur {
        public Humain(String nom,int couleur) {
            super(nom, couleur);
        }
        //Ici la methodejoue permet de demander au joueur d'entrer une colonne verifie le placement par l'appel d'autres methode et redemande tant que c'est pas valide
        public void jouer(Jeu jeu, int s) throws IOException {
            Scanner scanner = new Scanner(System.in);
            s= jeu.getTaille();
            jeu.afficher(jeu.getTaille());
            boolean valide;
            do {
                int col;
                System.out.println("Joueur " + this.getNom() + ", entrez un numéro de colonne" +
                        "  (entre 1 et " + jeu.getTaille() + ") : ");
                while (!scanner.hasNextInt()){
                    System.out.println("veuillez entrer un chiffre");
                    Parametres.ecrireDansLog(" Erreur saisie de "  + this.getNom(),true);
                    scanner.next();
                }
                col = scanner.nextInt(); // on pourrait faire ici la validation de la lecture
                col--;                                  // remet entre 0 et taille-1 (indice à la Java)
                valide = jeu.joueCoup(col, this.getCouleur(),jeu.getTaille());
                if (valide == false) {
                    System.out.println("-> Coup NON valide.");
                    Parametres.ecrireDansLog("erreur saisie colonne " + this.getNom(),true);
                }
            } while (valide == false);
        }
    }


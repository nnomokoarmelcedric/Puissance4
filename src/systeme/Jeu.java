package systeme;

public class Jeu {
    public final static int WHITE = 0;
    public final static int ORANGE = 1;
    public final static int RED = 2;
    private int taille=7;
    private int manche=5;
    public void setTaille(int taille) {
        this.taille = taille;
    }
    public int getTaille() {
        return taille;
    }
    public int getManche() {
        return manche;
    }
    public void setManche(int manche) {
        this.manche = manche;
    }
    private int[][] grille;   //tableau a double dimension sur le quel vas se jouer le jeu
    public Jeu(int taille,int manche) { //constructeur avec parametres
        this.taille=taille;
        this.manche=manche;

    }
    public Jeu() {             //constructeur sans parametres avec des valeurs par defaut
        this.taille=7;
        this.manche=4;

    }


    public void initJeu(int taille) {    //met tout les pionts du tableau  tableau a zero
        this.taille = taille;
        grille = new int[taille][taille];
        for (int col = 0; col < taille-2 ; col++) {
            for (int row = 0; row < taille-1; row++) {
                grille[col][row] = WHITE;
            }
        }
    }

    public boolean joueCoup(int col, int joueur,int x) { //prend en parametre ma colonne la couleur et la taille du tableau et indique vrai si un coup est possible
                                                         // et faux dans le cas contraire
        if ((col < 0) || (col >= x)) {
            return false;
        }

                                                     // Permet de trouver le premier espace non occupe dans la colonne  et renvoi vrai et dans le cas contraire renvoi faux
        for (int ligne = 0; ligne < x-1; ligne++) {
            if (grille[col][ligne] == WHITE) {
                grille[col][ligne] = joueur;
                return true;
            }
        }
        return false;
    }


    //la methode recherche4pions cherche 4 pions similaire d'affile dans une direction donnee en parametre
    private boolean recherche4Pions(int oCol, int oLigne, int dCol, int dLigne, int x) {
        int couleur = WHITE;
        int compteur = 0;

        int curCol = oCol;
        int curRow = oLigne;

        while ((curCol >= 0) && (curCol < x) && (curRow >= 0) && (curRow < x)) {
            if (grille[curRow][curCol] != couleur) {
                // Si la couleur change, on réinitialise le compteur
                couleur = grille[curRow][curCol];
                compteur = 1;
            } else {
                // Sinon on l'incrémente
                compteur++;
            }

            // On sort lorsque le compteur atteint 4
            if ((couleur != WHITE) && (compteur == 4)) {
                return true;
            }

            // On passe à l'itération suivante
            curCol += dCol;
            curRow += dLigne;
        }

        // Aucun alignement n'a été trouvé
        return false;
    }

    //cette methode verifie si un joueur a gagne dans toute les directions possible et prend juste en parametre la taille du tableau
    public boolean rechercheGagnant(int x) {
        // Vérifie les horizontales ( - )
        for (int ligne = 0; ligne < x; ligne++) {
            if (recherche4Pions(0, ligne, 1, 0,x)) {
                return true;
            }
        }

        // Vérifie les verticales ( ¦ )
        for (int col = 0; col < x; col++) {
            if (recherche4Pions(col, 0, 0, 1,x)) {
                return true;
            }
        }

        // Diagonales (cherche depuis la ligne du bas)
        for (int col = 0; col < x; col++) {
            // Première diagonale ( / )
            if (recherche4Pions(col, 0, 1, 1,x)) {
                return true;
            }
            // Deuxième diagonale ( \ )
            if (recherche4Pions(col, 0, -1, 1,x)) {
                return true;
            }
        }

        // Diagonales (cherche depuis les colonnes gauches et droites)
        for (int ligne = 0; ligne < x; ligne++) {
            // Première diagonale ( / )
            if (recherche4Pions(0, ligne, 1, 1,x)) {
                return true;
            }
            // Deuxième diagonale ( \ )
            if (recherche4Pions(x - 1, ligne, -1, 1,x)) {
                return true;
            }
        }

        // On n'a rien trouvé
        return false;
    }


    //permet de determiner si il y a encore de l'espace dans le tableau et renvoi vrai si c'est le cas
    public boolean grillePleine(int x) {
        for (int col = 0; col < x; col++) {
            for (int ligne = 0; ligne < x; ligne++) {
                if (grille[col][ligne] == WHITE) {
                    return false;
                }
            }
        }

        return true;
    }


        //Permet d'afficher la grille dansson etat actuel
    public void afficher(int x) {

        for (int i = 0; i < x; ++i) {
            System.out.print(" ");System.out.print(" ");
            System.out.print('_');
        }
        System.out.println(" ");
        for(int i=1; i<x+1; ++i){
            System.out.print(" ");System.out.print(" ");
            System.out.print(i);

        } System.out.println("   ");
        for (int ligne = x - 2; ligne >= 0; --ligne) {
            for (int col = 0; col < x; col++) {
                switch (grille[col][ligne]) {
                    case WHITE:
                        System.out.print(" ");
                        System.out.print(" ");
                        System.out.print('.');
                        break;
                    case RED:
                        System.out.print(" ");
                        System.out.print(" ");
                        System.out.print('O');
                        break;
                    case ORANGE:
                        System.out.print(" ");
                        System.out.print(" ");
                        System.out.print('X');
                        break;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < x; ++i) {
            System.out.print(" ");System.out.print(" ");
            System.out.print('*');
        }
        System.out.println();
        for (int i = 1; i <= x; ++i) {
            System.out.print(" ");System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < x; ++i) {
            System.out.print(" ");System.out.print(" ");
            System.out.print('_');
        }
        System.out.println();
    }
}
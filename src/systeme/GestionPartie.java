package systeme;

import interraction.Humain;
import interraction.InteligenceArtificiel;
import interraction.Joueur;

import java.io.IOException;
import java.util.Scanner;

public class GestionPartie {
    private Joueur[] joueurs = new Joueur[2];//tableau pour gerer les deux joueurs
    static Jeu jeu11 = new Jeu(7,3); //parametres de base de tout jeu
    public GestionPartie(Joueur joueur1, Joueur joueur2) {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
    }
    public GestionPartie(Joueur joueur1, Joueur joueur2, int manche) {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;

    }
//la methode joue prend en parametre un objet de la classe jeu  et se sert des ses attributs de tailleet nombre de manche pour mettre en place le jeu
    public void joue(Jeu x) throws IOException {

        int a1=0;
        int b1=0;
        int c1=0;
        int manche=1;
        int z=0;
        int Joueur = 1;
        x.initJeu(x.getTaille());
        do {
        int a=0;
        int b=0;
        int c=0;
        int vainqueur = -1;
        if (manche%2==1){
            Joueur =0;
        }else Joueur =1;

        if(manche==1){
            System.out.println("Debut de la premiere manche");
            Parametres.ecrireDansLog("Debut de la premiere manche",true);

        }

        while (vainqueur==-1) {

            joueurs[Joueur].jouer(x, x.getTaille());
            if (x.grillePleine(x.getTaille())) {
                vainqueur = 2;
            }

            // Si 4 pions sont alignés, on a un vainqueur
            // (même si le jeu est plein!)

            if (x.rechercheGagnant(x.getTaille())) {
                vainqueur = Joueur;

            }

            // On change de joueur pour l'itération suivante
            Joueur++;
            Joueur %= 2;


        }
        x.afficher(x.getTaille());
        System.out.println("La manche " +manche+ " est finie.");
            Parametres.ecrireDansLog("La manche " +manche+ " est finie.",true);
        if (vainqueur == 0) {
            a++;
            System.out.println("Le vainqueur de la manche "+manche+ " est " + joueurs[vainqueur].getNom());
            Parametres.ecrireDansLog("Le vainqueur de la manche "+manche+ " est " + joueurs[vainqueur].getNom(),true);

        } else if (vainqueur==1){
            b++;
            System.out.println("Le vainqueur de la manche "+manche+ " est " + joueurs[vainqueur].getNom());
            Parametres.ecrireDansLog("Le vainqueur de la manche "+manche+ " est " + joueurs[vainqueur].getNom(),true);

        }else if (vainqueur==-1 || vainqueur==2){
            System.out.println("la manche est un match null");
            Parametres.ecrireDansLog("la manche est un match null",true);
            c++;
        }

        x.initJeu(x.getTaille());
        manche++;
        a1=a1+a;
        b1=b1+b;
        c1=c1+c;
        if(a1==x.getManche()){
            z=2;
        }else if(b1==x.getManche()){z=2;
        }else
        {z=1;
        }
        if (z!=2){System.out.println("debut de la manche " +manche);
            Parametres.ecrireDansLog("debut de la manche " +manche,true);
        }
    }while ( z!=2 );
        System.out.println("La partie est finie.");

        Parametres.ecrireDansLog("La partie est finie.",true);
        if (a1>b1) {
            System.out.println("Le vainqueur est " + joueurs[0].getNom());
            Parametres.ecrireDansLog("Le vainqueur est " + joueurs[0].getNom(),true);
        } else if (a1<b1){
            System.out.println("Le vainqueur est " + joueurs[1].getNom());
            Parametres.ecrireDansLog("Le vainqueur est " + joueurs[1].getNom(),true);
        }else {
            System.out.println("match null");
            Parametres.ecrireDansLog("match null",true);
        }
        System.out.println("le score est de " +a1+ " - " +b1 +"\n \n");
        Parametres.ecrireDansLog("le score est de " +a1+ " - " +b1 +"\n \n",true);
        System.out.println("                                                                 NOUVELLE PARTIE                                                                     ");


        GestionPartie.start(jeu11);



    }
//La methode start permet de lancer le jeu et prend en parametre un jeu initialiser avec des parametres par defaut
    public static void start(Jeu a) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                                                 PUISSANCE4                                                                     ");
        System.out.println("|****************************************************************Menu principal****************************************************************|\n                                                           1) JOUEUR 1 VS JOUEUR 2 \n                                                                2) JOUEUR  VS I.A  \n                                                                    3) I.A VS I.A \n                                                                        4)parametres \n                                                                               5)sortir");
        System.out.println("|***********************************************************************************************************************************************|");
        int choix;
        while (!scanner.hasNextInt()){
            System.out.println("veuillez entrer un chiffre entre 1 et 5");
            scanner.next();
        }

        choix = scanner.nextInt();
        while(choix<1 || choix>5 ){
            System.out.println("veuillez entrer un chiffre entre 1 et 5");
            choix = scanner.nextInt();
        }

        if (choix == 1) {
            Parametres.ecrireDansLog("NOUVELLE PARTIE",false);
            Scanner m = new Scanner(System.in);Scanner m2 = new Scanner(System.in);
            System.out.println("Entrez votre nom joueur 1: ");
            String nom = m.nextLine();
            System.out.println("Entrez votre nom joueur 2: ");
            String nom2 = m2.nextLine();
            GestionPartie p1 = new GestionPartie(new Humain(nom, Jeu.ORANGE), new Humain(nom2, Jeu.RED));
            p1.joue(a);
        } else if (choix == 2) {
            Parametres.ecrireDansLog("NOUVELLE PARTIE",false);
            Scanner m3 = new Scanner(System.in);

            System.out.println("Entrez votre nom joueur 1: ");
            String nom3 = m3.nextLine();
            GestionPartie p2 = new GestionPartie(new Humain(nom3, Jeu.ORANGE), new InteligenceArtificiel("monkey", Jeu.RED));
            p2.joue(a);
        } else if (choix == 3) {
            Parametres.ecrireDansLog("NOUVELLE PARTIE",false);
            /*System.out.println("entrez le nombre de manche a gagner pour remporter la partie ");
            int y = systeme.Main.mz3.nextInt();*/
            GestionPartie p3 = new GestionPartie(new InteligenceArtificiel("Random", Jeu.ORANGE), new InteligenceArtificiel("monkey", Jeu.RED));
            p3.joue(a);}

        else if (choix == 4) {
            Parametres.modif();
        } else if (choix==5) {
            System.exit(0);
        }


    }

    }

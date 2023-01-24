package systeme;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Parametres {
    //la methode modif() permet de modifier la taile et le nombre de manche d'une partie
    public static void modif() throws IOException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("systeme.Parametres \n 1)modifier taille de la grille exemple: 6=5x6 , 9=8x9 , 10=9x10 \n 2) modifier le nombre de manche a gagner \n 3)Retour au menu pincipal \n 4)sortir");
        int choix;

        while (!scanner1.hasNextInt()){
            System.out.println("veuillez entrer un chiffre entre 1 et 4");
            scanner1.next();
        }

        choix = scanner1.nextInt();
        while(choix<1 || choix>4){
            System.out.println("veuillez entrer un chiffre entre 1 et 4");
            choix = scanner1.nextInt();
        }

        if (choix==1){
            Scanner scanner2 = new Scanner(System.in);
            int l;
            System.out.println("entrez une taille superieur a 4");
            while (!scanner2.hasNextInt()){
                System.out.println("veuillez entrer une taille superieur a 4 ");
                scanner2.next();
            }
            l = scanner2.nextInt();

            while(l<=4){
                System.out.println("veuillez entrer un chiffre entre 1 et 5");
                l = scanner2.nextInt();
            }


            GestionPartie.jeu11.setTaille(l);
            Parametres.modif();
           // Partie.start(Partie.z);
        }else if (choix==2){
            Scanner scanner8 = new Scanner(System.in);
            int l;
            System.out.println("entrez le nombre de manche a gagner");
            while (!scanner8.hasNextInt()){
                System.out.println("veuillez entrer un chiffre ");
                scanner8.next();
            }
            l = scanner8.nextInt();
            GestionPartie.jeu11.setManche(l);
            Parametres.modif();
           // Partie.start(Partie.z);
        }  else if (choix==3) {
            GestionPartie.start(GestionPartie.jeu11);

        } else if (choix==4) {
            System.exit(0);
        }

    }

    //La methode ecrire dans log creeun fichier log.txt dans la racine et prend en parametre le text qu'il doit contenir
    public static void ecrireDansLog(String message,boolean g) throws IOException {
        String sep=System.getProperty("file.separator");
        FileWriter fw=new FileWriter("src"+sep+"log.txt",g);
        PrintWriter pw=new PrintWriter(fw);
        pw.println(message);

        pw.close();

    }

}

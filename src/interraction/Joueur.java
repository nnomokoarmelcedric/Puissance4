package interraction;

import systeme.Jeu;

import java.io.IOException;

public abstract class Joueur {
        private String nom;
        private int couleur;

        public Joueur(String nom, int couleur) {
            this.nom = nom;
            this.couleur = couleur;
        }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
            return nom;
        }

        public int getCouleur() {
            return couleur;
        }

       //permet de jouer un coup avec un humain ou un ORDINATEUR et est vide car elle doit etre redefini par les classes filles qui sont humain et Intelligence Artificiel
        public void jouer(Jeu jeu, int taille) throws IOException {}

    }


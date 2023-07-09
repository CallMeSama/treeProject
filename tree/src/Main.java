package src;

import src.file.File;

import src.composite.Composite;
import src.repository.Repository;

public class Main {

    // Prend en entrée un repertoire et parcourt les éléments de ce repertoire et
    // les place dans Compsite racine
    public static void buildRepository(java.io.File folder, Composite racine, int size) {

        // La boucle qui permet de parcurir les éléments du folder
        for (final java.io.File fileEntry : folder.listFiles()) {

            // Si l'elément est un dossier alors on crée sous composite racine et on appelle
            // la
            // methode buildRepository de manière recursive
            if (fileEntry.isDirectory()) {
                Composite subRacine = new Repository(fileEntry.getName());
                racine.addChild(subRacine);
                if (size > 0)
                    buildRepository(fileEntry, subRacine, size - 1);
            }
            // Si c'est un fichier alors on l'ajoute au composite racine comme enfant
            else {
                Composite file = new File(fileEntry.getName());
                racine.addChild(file);
            }
        }
    }

    public static void main(String[] args) {

        // On crée un nouvel object et on recupere le chemin du repertoire à afficher
        java.io.File javaFile = new java.io.File(
                "C:/Users/MAMA DIARRA/Downloads/treeProject-main/treeProject-main/tree/src");

        // Cette variable definit le maximum de sous repertoire qu'on peut afficher
        int size = 3;

        // Récupère tous les éléments du repertoire racine definit précédement
        Composite repRacine = new Repository(javaFile.getName());
        buildRepository(javaFile, repRacine, size);

        repRacine.show(0, 0, 0);
    }
}
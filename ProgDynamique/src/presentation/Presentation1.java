package presentation;

import dao.IDao1;
import metier.IMetier1;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation1 {
    public static void main(String[] args) throws Exception {
        // Lecture du nom de la classe DAO depuis le fichier de configuration
        Scanner scanner = new Scanner(new File("config1.txt"));
        String daoClassName = scanner.nextLine();

        // Utilisation de la réflexion pour charger la classe DAO et créer une instance
        Class<?> cDao1 = Class.forName(daoClassName);
        IDao1 dao1 = (IDao1) cDao1.getDeclaredConstructor().newInstance();

        // Lecture du nom de la classe Métier depuis le fichier de configuration
        String metierClassName = scanner.nextLine();
        Class<?> cMetier1 = Class.forName(metierClassName);
        IMetier1 metier1 = (IMetier1) cMetier1.getDeclaredConstructor().newInstance();

        // Injection de la DAO dans le Métier à l'aide de la réflexion
        Method setDao1Method = cMetier1.getMethod("setDao1", IDao1.class);
        setDao1Method.invoke(metier1, dao1);

        // Invocation d'une méthode sur l'instance de Métier et affichage du résultat
        System.out.println("Résultats = " + metier1.calcul1());

        scanner.close();
    }
}

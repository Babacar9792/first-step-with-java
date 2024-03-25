package Exo1;

import javax.swing.JOptionPane;;

/**
 * Exercice 1
 * La classe principale qui va lancer le programme de l'exercice 1
 */
public class Exercice1 {

    public static String[] MOUNTHINFRENCH = new String[] { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juin",
            "Aout", "Septembre", "Octobre", "Novembre", "Decembre" };
    public static String[] MOUNTHINENGLISH = new String[] { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };

    public static void main(String[] args) {

        menu();

    }

    /**
     * Methode pour obtenir la longueur de la chaine de carateres la plus longue du
     * tableau de chaine de caractere
     * 
     * @param String[] tabMounth
     * @return length of longestString
     */

    public static int getLengthLongestString(String[] tabMounth) {
        String longestString = tabMounth[0];
        for (int i = 0; i < tabMounth.length; i++) {
            if (tabMounth[i].length() > longestString.length()) {
                longestString = tabMounth[i];
            }
        }
        return longestString.length();
    }

    public static void drawLine(String[] tabMounth) {
        String line = "";
        int lengthLongest = getLengthLongestString(tabMounth) * 4;
        for (int i = 0; i < lengthLongest + 5; i++) {
            line = line + "-";
        }
        System.out.println(line);
    }

    public static String paginateTab(String[] tabStrings, int page) {
        String mounthToShow = "|";
        int start = 4 * (page - 1);
        for (int i = start; i < page * 4; i++) {
            if (i < tabStrings.length) {
                while (tabStrings[i].length() < getLengthLongestString(tabStrings)) {
                    tabStrings[i] = tabStrings[i] + " ";
                }
                mounthToShow = mounthToShow + tabStrings[i];
                mounthToShow = mounthToShow + "|";

            }
        }
        return mounthToShow;
    }

    public static int getTotalPage(String[] tabStrings) {
        return tabStrings.length % 4 != 0 ? tabStrings.length / 4 + 1 : tabStrings.length / 4;
    }

    public static void drawArray(String[] arrayStrings) {
        drawLine(arrayStrings);
        for (int i = 0; i < getTotalPage(arrayStrings); i++) {
            System.out.println(paginateTab(arrayStrings, i + 1));
            drawLine(arrayStrings);
        }

    }

    public static void menu() {
        System.out.println("Bonjour, Bienvenue dans le menu de choix du mois à afficher");
        System.out.println("1 pour choisir les mois en français");
        System.out.println("2 pour choisir les mois en anglais");
        String choise = JOptionPane.showInputDialog("");
        switch (choise) {
            case "1":
                System.out.println("Les mois en français");
                drawArray(MOUNTHINFRENCH);
                menu();
                break;
            case "2":
                System.out.println("Les mois en anglais");
                drawArray(MOUNTHINENGLISH);
                menu();
                break;

            default:
                System.out.println("Au revoir");
                break;
        }
    }
}
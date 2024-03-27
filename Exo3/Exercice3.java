package Exo3;

import javax.swing.JOptionPane;

public class Exercice3 {

    public static void main(String[] args) {
        InnerExercice3 exo = new InnerExercice3();
        exo.mainExo();
    }

}

/**
 * InnerExercice3
 */
class InnerExercice3 {

    public void mainExo() {
        System.out.println(
                "Bienvenue dans l'algo de l'exerccice 3. Cet exercice va permettre de supprimer tous les espaces inutiles, les caaractères spéciaux d'une phrase ");
        String sentence;
        do {
            sentence = JOptionPane.showInputDialog("écrire la phrase");
        } while (sentence.length() == 0);
        System.out.println(deleteUnecessarySpace(sentence));

    }

    public String deleteUnecessarySpace(String sentence) {
        String newSentence = "";
        for (int i = 0; i < sentence.length(); i++) {
            
            if (canNotDeleted(sentence.charAt(i)) && !isUnnecessarySpace(sentence.charAt(i), i, sentence)) {
                newSentence += sentence.charAt(i);
            }
        }
        return newSentence;
    }

    public boolean isUnnecessarySpace(char space, int position, String sentence) {
        if (space == ' ') {
            if (position == 0 || position == sentence.length() - 1) {
                return true;

            }
            if (sentence.charAt(position - 1) == ' ' || !canNotDeleted(sentence.charAt(position-1))) {
                return true;
            }

        }
        return false;
    }

    public boolean isNumber(char caractere) {

        return (int) caractere <= 9 && (int) caractere >= 0;
    }

    public boolean isChar(char caractere) {

        return (char) caractere <= 'z' && (char) caractere >= 'a';
    }

    public boolean isCharOrNumber(char caractere) {
        return isChar(caractere) || isNumber(caractere);
    }

    public boolean canNotDeleted(char caractere) {
        return isCharOrNumber(caractere) || caractere == '!' || caractere == '?' || caractere == '.'
                || caractere == ' ';

    }

}

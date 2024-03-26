package Exo2;

import javax.swing.JOptionPane;

/**
 * On doit ecrire un programme qui permet de supprimer tous les espaces inutiles
 * d'une phrases.
 * 
 */
public class Exercice2 {

    public static void main(String[] args) {

        InnerExercice2 sentInnerExercice2 = new InnerExercice2();
        sentInnerExercice2.exercice();

    }

}

/**
 * InnerExercice2
 */
class InnerExercice2 {

    public boolean isUnnecessarySpace(char space, int position, String sentence) {
        if (space == ' ') {
            if (position == 0 || position == sentence.length() - 1) {
                return true;
            }
            if (sentence.charAt(position - 1) == ' ') {
                return true;
            }
        }
        return false;
    }

    public String deleteUnnecessarySpace(String sentence) {
        String newSentence = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (!isUnnecessarySpace(sentence.charAt(i), i, sentence)) {
                newSentence += sentence.charAt(i);
                
            }
        }
        return newSentence;
    }

    public void exercice() {
        System.out.println(
                "Entrez une phrase, ce programme supprimera tous les espaces inutiles et vous renverra une nouvelle chaine sans espace inutole");
        String sentence = JOptionPane.showInputDialog("Entrer la phrase");
        System.out.println(deleteUnnecessarySpace(sentence));

    }

}

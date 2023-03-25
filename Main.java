import java.io.IOException;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        try {
            dictionary.load("diccionario.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar el diccionario.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el texto a traducir:");
        String text = scanner.nextLine();

        System.out.println("Ingrese el idioma al que desea traducir (inglés, español o francés):");
        String language = scanner.nextLine().toLowerCase();

        String translation = dictionary.translate(text, language);
        System.out.println("Traducción:");
        System.out.println(translation);

        System.out.println("Palabras en orden alfabético en inglés:");
        List<Word> englishWords = dictionary.getEnglishWordsInOrder();
        for (Word word : englishWords) {
            System.out.println(word.getEnglish());
        }

        System.out.println("Palabras en orden alfabético en español:");
        List<Word> spanishWords = dictionary.getSpanishWordsInOrder();
        for (Word word : spanishWords) {
            System.out.println(word.getSpanish());
        }

        System.out.println("Palabras en orden alfabético en francés:");
        List<Word> frenchWords = dictionary.getFrenchWordsInOrder();
        for (Word word : frenchWords) {
            System.out.println(word.getFrench());
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
    private BST<String, Word> englishTree;
    private BST<String, Word> spanishTree;
    private BST<String, Word> frenchTree;

    public Dictionary() {
        englishTree = new BST<>();
        spanishTree = new BST<>();
        frenchTree = new BST<>();
    }

    public void load(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String english = parts[0].trim().toLowerCase();
                String spanish = parts[1].trim().toLowerCase();
                String french = parts[2].trim().toLowerCase();

                Word word = new Word(english, spanish, french);

                englishTree.put(english, word);
                spanishTree.put(spanish, word);
                frenchTree.put(french, word);
            }
        }
    }

    public String translate(String text, String toLanguage) {
        String[] words = text.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String translation = null;
            Word dictionaryWord = null;

            switch (toLanguage) {
                case "spanish":
                    dictionaryWord = spanishTree.get(word);
                    break;
                case "french":
                    dictionaryWord = frenchTree.get(word);
                    break;
                default:
                    dictionaryWord = englishTree.get(word);
                    break;
            }

            if (dictionaryWord != null) {
                switch (toLanguage) {
                    case "spanish":
                        translation = dictionaryWord.getSpanish();
                        break;
                    case "french":
                        translation = dictionaryWord.getFrench();
                        break;
                    default:
                        translation = dictionaryWord.getEnglish();
                        break;
                }
            } else {
                translation = "*" + word + "*";
            }

            result.append(translation).append(" ");
        }

        return result.toString();
    }

    public List<Word> getEnglishWords() {
        return englishTree.inOrderTraversal();
    }

    public List<Word> getSpanishWords() {
        return spanishTree.inOrderTraversal();
    }

    public List<Word> getFrenchWords() {
        return frenchTree.inOrderTraversal();
    }
}



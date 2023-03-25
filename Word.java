public class Word implements Comparable<Word> {

    private String english;
    private String spanish;
    private String french;

    public Word(String english, String spanish, String french) {
        this.english = english;
        this.spanish = spanish;
        this.french = french;
    }

    public String getEnglish() {
        return english;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getFrench() {
        return french;
    }

    @Override
    public int compareTo(Word o) {
        return this.english.compareToIgnoreCase(o.english);
    }
}

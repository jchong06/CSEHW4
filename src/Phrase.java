import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;

public class Phrase extends LinkedList<Bigram> {

    public Phrase() {
    }

    public static Phrase buildPhraseFromStringforEnc(String s) {
        Phrase phrase = new Phrase();
        ArrayList<String> pairs = new ArrayList<>();
        String bigram = "";
        s = s.toUpperCase();
        s = s.toUpperCase().replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(bigram)) {
                bigram += "X";
                pairs.add(bigram);
                bigram = String.valueOf(s.charAt(i));
            }
            bigram += String.valueOf(s.charAt(i));
            if (bigram.length() == 2){
                pairs.add(bigram);
                bigram = "";
            }
        }
        if (!(bigram.equals(""))){
            bigram += "X";
            pairs.add(bigram);
        }

        for (String c : pairs){
            Bigram bi = new Bigram();
            bi.setFirst(c.charAt(0));
            bi.setSecond(c.charAt(1));
            phrase.offer(bi);
        }

        return phrase;
    }
}